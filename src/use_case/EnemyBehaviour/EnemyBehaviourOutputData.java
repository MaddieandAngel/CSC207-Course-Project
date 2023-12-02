package use_case.EnemyBehaviour;

public class EnemyBehaviourOutputData {

    private final String action;

    private final String cardCode;
    private final int cardValue;
    private final char cardSuit;
    private final char suitEnemyIsWeakTo;
    private final char suitEnemyBeats;

    public EnemyBehaviourOutputData(String action, int cardValue, char cardSuit, String cardCode){
        this.action = action;
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
        this.cardCode = cardCode;

        if (cardSuit == 'S'){ //Spades beats Hearts and is beaten by Diamonds
            suitEnemyBeats = 'H';
            suitEnemyIsWeakTo = 'D';
        }
        else if (cardSuit == 'H') { //Hearts beats Clubs and is beaten by Spades
            suitEnemyBeats = 'C';
            suitEnemyIsWeakTo = 'S';
        }
        else if (cardSuit == 'C') { //Clubs beats Diamonds and is beaten by Hearts
            suitEnemyBeats = 'D';
            suitEnemyIsWeakTo = 'H';
        }
        else if (cardSuit == 'D') { //Diamonds beats Spades and is beaten by Clubs
            suitEnemyBeats = 'S';
            suitEnemyIsWeakTo = 'C';
        }
        else { //Joker is always neutral
            suitEnemyBeats = '\0';
            suitEnemyIsWeakTo = '\0';
        }
    }

    public String getAction() {
        return action;
    }
    public char getCardSuit() {
        return cardSuit;
    }
    public char getSuitEnemyIsWeakTo() {
        return suitEnemyIsWeakTo;
    }
    public char getSuitEnemyBeats() {
        return suitEnemyBeats;
    }
    public int getCardValue() {
        return cardValue;
    }

    public String getCardCode() { return this.cardCode;}
}
