package entity;

public class Deck {

    private boolean shuffled;

    private String deckID;

    private int remainingCards;

    private boolean jokers;

    public Deck(boolean shuffled, String deckID, int remainingCards, boolean jokers) {
        this.shuffled = shuffled;
        this.deckID = deckID;
        this.remainingCards = remainingCards;
        this.jokers = jokers;
    }

    public String getDeckID() {
        return this.deckID;
    }

    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }

    public int getRemainingCards() {
        return this.remainingCards;
    }

    public void setRemainingCards(int remainingCards) {
        this.remainingCards = remainingCards;
    }
}