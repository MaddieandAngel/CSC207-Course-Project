package use_case.EnemyBehaviour;

public class EnemyBehaviourOutputData {

    private final String action;
    private final int cardValue;
    private final char cardSuit;
    private final char suitWeakness;

    public EnemyBehaviourOutputData(String action, int cardValue, char cardSuit){
        this.action = action;
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;

        if (cardValue == 'S'){ //Spades beats Hearts
            suitWeakness = 'H';
        }
        else if (cardValue == 'H') { //Hearts beats Clubs
            suitWeakness = 'C';
        }
        else if (cardValue == 'C') { //Clubs beats Diamonds
            suitWeakness = 'D';
        }
        else if (cardValue == 'D') { //Diamonds beats Spades
            suitWeakness = 'S';
        }
        else { //Joker's weakness is ' '
            suitWeakness = ' ';
        }
    }

    public String getAction() {
        return action;
    }
    public char getCardSuit() {
        return cardSuit;
    }
    public char getSuitWeakness() {
        return suitWeakness;
    }
    public int getCardValue() {
        return cardValue;
    }
}
