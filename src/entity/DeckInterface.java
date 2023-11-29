package entity;

public interface DeckInterface {

    String getDeckID();

    boolean isShuffled();

    void setShuffled(boolean shuffled);

    int getRemainingCards();

    void setRemainingCards(int remainingCards);
}
