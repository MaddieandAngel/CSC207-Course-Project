package entity;

public class Deck {

    private boolean shuffled;

    private String deckID;

    private int remainingCards;


    public Deck(boolean shuffled, String deckID, int remainingCards) {
        this.shuffled = shuffled;
        this.deckID = deckID;
        this.remainingCards = remainingCards;
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
