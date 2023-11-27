package data_access;

import interface_adapter.TitleScreen.CreateDeckDataAccessInterface;
import okhttp3.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import entity.Deck;
import interface_adapter.APIAccessInterface;

import java.io.IOException;
import java.util.Random;

public class APIAccess implements APIAccessInterface, CreateDeckDataAccessInterface {

    @Override
    public Deck NewDeck() throws IOException, RuntimeException{
        // Make a call to the API and create a new deck

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("https://www.deckofcardsapi.com/api/deck/new/?jokers_enabled=true").get().build();

        try {
            Response response = client.newCall(request).execute();

            ResponseBody responseBody = response.body();

            // Check if successful
            if (response.code() != 200) {
                throw new RuntimeException("New deck was not successfully made");
            }

                // Converting responseBody into a String
                if (responseBody != null) {
                    String responseBodyString = responseBody.string();
                    String[] newString = responseBodyString.split(",");

                    // Accessing values for new deck
                    boolean shuffled = false;
                    String deckID = newString[1].split(":")[1].trim().replace("\"", "");
                    int remainingCards = Integer.parseInt(newString[2].split(":")[1].trim().replace("}", ""));


                    // Creating new Deck
                    Deck newDeck = new Deck(shuffled, deckID, remainingCards);

                    // Shuffle new deck
                    Shuffle(newDeck);

                    // return the new, shuffled deck
                    return newDeck;
                } else {
                    // means responseBody is null, so a new deck was not created, will therefore throw a RuntimeException
                    throw new RuntimeException("New deck not created");
                }
        }  catch (RuntimeException e) {
            throw new RuntimeException("New deck not created");
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    @Override
    public void Shuffle(Deck deck) throws IOException, RuntimeException{
        // Make a call to the API and shuffle the deck, given by the deckID parameter
        String url = "https://www.deckofcardsapi.com/api/deck/" + deck.getDeckID() + "/shuffle/?remaining=true";
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();

            ResponseBody responseBody = response.body();

            // Check if successful
            // Converting responseBody into a String
            if (responseBody != null) {
                String responseBodyString = responseBody.string();
                String[] newString = responseBodyString.split(",");

                // Get shuffled value from responseBody
                String isShuffledString = newString[3].split(":")[1].trim().replace("}", "");
                boolean shuffled = Boolean.parseBoolean(isShuffledString);

                // Check if shuffled
                if (shuffled) {
                    deck.setShuffled(true);
                }  else {
                    throw new RuntimeException("Shuffle not successful");
                }
            } else {
                throw new RuntimeException("Shuffle not successful");
            }

        } catch (RuntimeException e) {
            throw new RuntimeException("Shuffle not successful");
        } catch (IOException e) {
            throw new IOException(e);
        }

    }

    @Override
    public void DrawCard(Deck deck, String pileName) throws IOException, RuntimeException{
        // Will draw a card from the deck and add it to the intended pile, using the AddToPile method.
        // If there are zero cards left in the deck, the cards from the discard pile will be returned to the deck and will be shuffled

        // Make a call to the API and draw a card from the deck

        String url = "https://www.deckofcardsapi.com/api/deck/" + deck.getDeckID() + "/draw/?count=1";

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();

            ResponseBody responseBody = response.body();

            // Converting responseBody into a string
            if (responseBody != null) {
                String responseBodyString = responseBody.string();
                String[] newString = responseBodyString.split(",");

                // Check if successful
                boolean successful = Boolean.parseBoolean(newString[0].split(":")[1].trim());
                if (!successful) {
                    throw new RuntimeException("Card not drawn");
                }

                // Adding the drawn card to the corresponding pile/hand
                String cardCode = newString[2].split(":")[2].replace("\"", "").trim();
                AddToPile(deck.getDeckID(), pileName, cardCode);

                // Update the value of remaining cards
                int updatedRemainingCards = Integer.parseInt(newString[8].split(":")[1].replace("}", "").trim());
                deck.setRemainingCards(updatedRemainingCards);
                if (deck.getRemainingCards() == 0) {
                    MovePileToDeck(deck, "discard");
                    Shuffle(deck);
                }
            }
        } catch (IOException e) {
            throw new IOException(e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Card not drawn");
        }

    }

    @Override
    public void CardPlayed(String deckID, String pileName, String cardCode) throws IOException, RuntimeException{
        // Will remove the card that was played from the provided pile/hand and will add it to the discard pile

        // Make call to the API and draw the specified card from the provided pile
        String url = "https://www.deckofcardsapi.com/api/deck/" + deckID + "/pile/" + pileName + "/draw/?cards=" + cardCode;

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();

            ResponseBody responseBody = response.body();

            // Converting responseBody into a String
            if (responseBody != null) {
                String responseBodyString = responseBody.string();
                String[] newString = responseBodyString.split(",");

                // Check if successful
                boolean successful = Boolean.parseBoolean(newString[0].split(":")[1].trim());
                if (!successful) {
                    throw new RuntimeException("Provided card not in pile");
                }
                AddToPile(deckID,"discard", cardCode);
            }
        } catch (IOException e) {
            throw new IOException(e);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AddToPile(String deckID, String pileName, String cardCode) throws IOException, RuntimeException{
        // Will add the provided card and add it to the specified pile
        // cardCode follows the cardCode convention in the API

        // Make call to API, adding the specified card to the requested pile
        String url = "https://www.deckofcardsapi.com/api/deck/" + deckID + "/pile/" + pileName + "/add/?cards=" + cardCode;

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();

            // Converting responseBody into a String;
            if (responseBody != null) {
                String responseBodyString = responseBody.string();
                String[] newString = responseBodyString.split(",");

                // Check if successful
                boolean successful = Boolean.parseBoolean(newString[0].split(":")[1].trim());
                if (!successful) {
                    throw new RuntimeException("Card not successfully moved to " + pileName + " pile");
                }
            }
        } catch (IOException e) {
            throw new IOException(e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Card not successfully added to " + pileName + " pile");
        }

    }

    @Override
    public void MovePileToDeck(Deck deck, String pileName) throws IOException, RuntimeException{
        // Will move the cards from the specified pile return them to the main deck then shuffle the main deck
        // Will assume the pile name provided is an already created pile in the deck

        // Call API and move cards from desired pile to the main deck of cards
        String url = "https://www.deckofcardsapi.com/api/deck/" + deck.getDeckID() + "/pile/" + pileName + "/return/";

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();

            // Convert responseBody into a String
            if (responseBody != null) {
                String responseBodyString = responseBody.string();
                String[] newString = responseBodyString.split(",");

                // Check if successful
                boolean successful = Boolean.parseBoolean(newString[0].split(":")[1].trim());
                if (!successful) {
                    throw new RuntimeException("Pile was not moved back to deck");
                }

                // Update the number of remaining cards in the deck
                int updatedRemainingCards = Integer.parseInt(newString[2].split(":")[1].trim());
                deck.setRemainingCards(updatedRemainingCards);

                deck.setShuffled(false); // Since the deck is no longer shuffled
                // Shuffle the main deck
                Shuffle(deck);
            } else {
                // else runs when responseBody is null, indicating the pile was not moved to the deck, so will
                // throw a RuntimeException
                throw new RuntimeException("Pile was not moved back to deck");
            }
        } catch (IOException e) {
            throw new IOException(e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Pile was not moved back to deck");
        }

    }

    @Override
    public String[] GetCardsInPile(Deck deck, String pileName) throws IOException, RuntimeException{
        // Will return a list of the card codes for all the cards in the requested pile. If the pile is empty, will return null

        // Make a call to the API to get a list of the cards in the requested pile
        String url = "https://www.deckofcardsapi.com/api/deck/" + deck.getDeckID() + "/pile/" + pileName + "/list/";

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();

            // Converting responseBody into a String
            if (responseBody != null) {
                String responseBodyString = responseBody.string();
                String[] newString = responseBodyString.split(",");

                // Check if successful
                boolean successful = Boolean.parseBoolean(newString[0].split(":")[1].trim());
                if (!successful) {
                    throw new RuntimeException();
                }

                String[] temp1 = responseBodyString.split("\"" + pileName + "\": ");
                String[] temp2 = temp1[1].split("\"code\": ");
                String resultString = "";
                for (int i = 1; i < temp2.length; i++) {
                    if (i == temp2.length - 1) {
                        resultString = resultString + temp2[i].split(",")[0].replace("\"", "").trim();
                    } else {
                        resultString = resultString + temp2[i].split(",")[0].replace("\"", "").trim() + ",";
                    }
                }
                if (resultString.length() == 0) {
                    return null;
                } else {
                    return resultString.split(",");
                }
            } else {
                // means responseBody is null, so getting the list of cards failed, so a RuntimeException will be thrown
                throw new RuntimeException("Failed to get list of cards");
            }
        } catch (IOException e) {
            throw new IOException(e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to get list of cards");
        }

    }

    @Override
    public String GetCardImage(String cardCode) {
        // Will return the link to the png image of the card
        return "https://www.deckofcardsapi.com/static/img/" + cardCode + ".png";
    }

    @Override
    public int GetCardValue(String cardCode) {
        // Will return the value of the card as a string

        char cardValue = cardCode.charAt(0);
        // Available values in a card code are 2, 3, 4, 5, 6, 7, 8, 9, 0, A, J, Q, and K.
        // For jokers, a random value between 0 and 15 inclusive will be returned
        if (cardValue == '0') {
            return 10;
        } else if (cardValue == 'A') {
            return 1;
        } else if (cardValue == 'J') {
            return 11;
        } else if (cardValue == 'Q') {
            return 12;
        } else if (cardValue == 'K') {
            return 13;
        } else if (cardValue == 'X') {
            // Generate a random int between 0 (inclusive) and 16 (exclusive, so 15 inclusive) for jokers
            Random random = new Random();
            return random.nextInt(16);
        } else {
            return Integer.parseInt(String.valueOf(cardValue));
        }
    }

    @Override
    public char GetCardSuit(String cardCode) {
        // Will return the suit of the card as a char

        if (cardCode.charAt(0) == 'X') {
            return 'J';
        } else {
            return cardCode.charAt(1);
        }
    }
}
