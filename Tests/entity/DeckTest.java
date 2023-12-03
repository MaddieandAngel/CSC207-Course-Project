package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck(false, "wfb82obv39bve204", 54);
    }

    @Test
    void getDeckID() {
        assertEquals(deck.getDeckID(), "wfb82obv39bve204");
    }

    @Test
    void isShuffled() {
        assertFalse(deck.isShuffled());
    }

    @Test
    void setShuffled() {
        deck.setShuffled(true);
        assert deck.isShuffled();
    }

    @Test
    void getRemainingCards() {
        assertEquals(deck.getRemainingCards(), 54);
    }

    @Test
    void setRemainingCards() {
        deck.setRemainingCards(78);
        assertEquals(deck.getRemainingCards(), 78);
    }
}