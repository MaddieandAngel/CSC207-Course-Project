package entity;

public class Deck {

    boolean shuffled;

    private String deckID;

    int remainingCards;

    boolean jokers;

    public Deck(boolean shuffled, String deckID, int remainingCards, boolean jokers) {
        this.shuffled = shuffled;
        this.deckID = deckID;
        this.remainingCards = remainingCards;
        this.jokers = jokers;
    }

    public String getDeckID() {
        return this.deckID;
    }
}
