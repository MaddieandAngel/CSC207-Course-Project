package data_access;

import entity.Deck;
import entity.DeckInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.fail;

class APIAccessTest {

    private APIAccess api;

    private DeckInterface testDeck;

    @BeforeEach
    void setUp() throws IOException {
        api = new APIAccess();
        // Assume constructor works
        testDeck = api.getDeck();
    }

    @Test
    void newDeck() throws IOException {
        assert testDeck instanceof Deck;
        assert testDeck.getRemainingCards() == 54;
        assert testDeck.isShuffled();
    }

    @Test
    void shuffleWorks() {
        testDeck.setShuffled(false);
        try {
            api.Shuffle();
            assert testDeck.isShuffled();
        } catch (IOException e) {
            fail("IOException not expected");
        }
    }

    @Test
    void drawCard() {
        int currentRemaining = testDeck.getRemainingCards();
        try {
            api.DrawCard("testPile");
            assert testDeck.getRemainingCards() == currentRemaining - 1;
            assert api.GetCardsInPile("testPile").length == 1;
        } catch (IOException e) {
            fail("IOException not expected");
        }
    }

    @Test
    void drawCardZeroRemaining() {
        try {
            for (int i = 0; i < 53; i++) {
                api.DrawCard("discard");
            }
            // There should be only one remaining card left, so the cards should be added back from the discard pile
            api.DrawCard("testPile");
            assert testDeck.getRemainingCards() == 53;
            assert api.GetCardsInPile("discard").length == 0;
            assert api.GetCardsInPile("testPile").length == 1;
        } catch (IOException e) {
            fail("IOException not expected");
        }
    }

    @Test
    void cardPlayed() {
        try {
            api.DrawCard("testPile");
            String card = api.GetCardsInPile("testPile")[0];
            api.CardPlayed("testPile", card);
            assert api.GetCardsInPile("testPile").length == 0 && api.GetCardsInPile("discard").length == 1;
        } catch (IOException e) {
            fail("iOException not expected");
        }
    }

    @Test
    void cardPlayedInvalidPile() {
        try {
            api.DrawCard("testPile");
            String card = api.GetCardsInPile("testPile")[0];
            api.CardPlayed("nonexistentPile", card);
            fail("IOException expected since an invalid non-existing pile was put as a parameter");
        } catch (IOException e) {
            assert true;
        }

    }

    @Test
    void cardPlayedInvalidCardCode() {
        try {
            api.DrawCard("testPile");
            api.CardPlayed("testPile", "1F");
            fail("IOException expected due to invalid cardCode (1 is not a valid value, and F is not a valid suit");
        } catch (IOException e) {
            assert true;
        }

    }

    @Test
    void addToPile() {
        // Only used by other methods. Assuming all other methods are correct, the correct values should always be provided
        try {
            api.AddToPile("testPile", "5S");
            String[] cards = api.GetCardsInPile("testPile");
            assert cards.length == 1 && Objects.equals(cards[0], "5S");
        } catch (IOException e) {
            fail("IOException not expected");
        }

    }

    @Test
    void movePileToDeckSuccessful() {
        // Assume the provided deck and pile name are correct. Assume all other methods are correct
        try {
            api.DrawCard("discard");
            int currentRemainingCards = testDeck.getRemainingCards();
            api.MovePileToDeck("discard");
            assert !testDeck.isShuffled() && testDeck.getRemainingCards() == currentRemainingCards + 1;
        } catch (IOException e) {
            fail("IOException not expected");
        }

    }

    @Test
    void MovePileToDeckInvalidPileName() {
        try {
            api.DrawCard("test1");
            int currentRemainingCards = testDeck.getRemainingCards();
            api.MovePileToDeck("fail");
            fail("IOException expected");
        } catch (IOException e) {
            assert true;
        }
    }

    @Test
    void getCardsInPile() {
        try {
            Random random = new Random();
            int randomInt = random.nextInt(1, 6);
            for (int i = 0; i < randomInt; i++) {
                api.DrawCard("testPile");
            }
            String[] cards = api.GetCardsInPile("testPile");
            assert cards.length == randomInt;
        } catch (IOException e) {
            fail("IOException not expected");
        }
    }

    @Test
    void getCardsInPileInvalidPile() {
        try {
            Random random = new Random();
            int randomInt = random.nextInt(1, 6);
            for (int i = 0; i < randomInt; i++) {
                api.DrawCard("testPile");
            }
            String[] cards = api.GetCardsInPile("failPile");
            fail("IOException expected due to incorrect pile name");
        } catch (IOException e) {
            assert true;
        }

    }

    @Test
    void getCardImage() {
        // Preconditions assume correct card code is provided
        try {
            api.DrawCard("testPile");
            String card = api.GetCardsInPile("testPile")[0];
            String expectedImage = "https://www.deckofcardsapi.com/static/img/" + card + ".png";
            String image = api.GetCardImage(card);
            assert Objects.equals(image, expectedImage);
        } catch (IOException e) {
            fail("IOException not expected");
        }
    }

    @Test
    void getCardValueForJoker() {
        // Preconditions assume correct card code is provided
        int value = api.GetCardValue("X1");
        assert 0 <= value &&  value <= 15;

    }

}