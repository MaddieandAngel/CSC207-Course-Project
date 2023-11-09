package data_access;

import okhttp3.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import entity.Deck;
import interface_adapter.APIAccessInterface;

import java.io.IOException;

public class APIAccess implements APIAccessInterface {

    @Override
    public Deck NewDeck(boolean jokers) throws IOException {
        // Make a call to the API and create a new deck
        // ** currently does not include joker option **

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder().url("https://www.deckofcardsapi.com/api/deck/new/").build();

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
                    Deck newDeck = new Deck(shuffled, deckID, remainingCards, jokers);

                    // Shuffle new deck
                    Shuffle(newDeck);

                    // return the new, shuffled deck
                    return newDeck;
                }
        }  catch (RuntimeException e) {
            throw new RuntimeException("New deck was not successfully made");
        } catch (IOException e) {
            throw new IOException(e);
        }
        // Will also return null if deck is not successfully created
        return null;
    }

    @Override
    public void Shuffle(Deck deck) throws IOException, RuntimeException{
        // Make a call to the API and shuffle the deck, given by the deckID parameter
        String url = "https://www.deckofcardsapi.com/api/deck/" + deck.getDeckID() + "/shuffle/?remaining=true";
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
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
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();

            ResponseBody responseBody = response.body();

            // Converting responseBody into a string
            if (responseBody != null) {
                String responseBodyString = responseBody.string();
                String[] newString = responseBodyString.split(",");

                // Check if successful
                boolean successful = Boolean.parseBoolean(newString[0].split(":")[1]);
                if (!successful) {
                    throw new RuntimeException("Card not drawn");
                }

                // Adding the drawn card to the corresponding pile/hand
                String cardCode = newString[2].split(":")[2].replace("\"", "");
                AddToPile(pileName, cardCode);

                // Update the value of remaining cards
                int updatedRemainingCards = Integer.parseInt(newString[8].split(":")[1]);
                deck.setRemainingCards(updatedRemainingCards);
                if (deck.getRemainingCards() == 0) {
                    MoveDiscardPileToDeck(deck);
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
    public void CardPlayed(String deckID, String pileName, String cardCode) {

    }

    @Override
    public void AddToPile(String pileName, String card) {

    }

    @Override
    public void MoveDiscardPileToDeck(Deck deck) {

    }

    @Override
    public String GetCardImage(String deckID, String pileName, String cardCode) {
        return null;
    }

    @Override
    public String GetCardValue(String deckID, String pileName, String cardCode) {
        return null;
    }

    @Override
    public String GetCardSuit(String deckID, String pileName, String cardCode) {
        return null;
    }
}
