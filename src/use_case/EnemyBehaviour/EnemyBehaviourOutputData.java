package use_case.EnemyBehaviour;

public class EnemyBehaviourOutputData {

    private final String action;
    private final int cardValue;
    private final char cardSuit;

    public EnemyBehaviourOutputData(String action, int cardValue, char cardSuit){
        this.action = action;
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
    }

    public String getAction() {
        return action;
    }
    public char getCardSuit() {
        return cardSuit;
    }
    public int getCardValue() {
        return cardValue;
    }
}
