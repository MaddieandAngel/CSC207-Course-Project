package use_case.AttackButton.CardButton;

import entity.Enemy;
import entity.Player;

public class CardButtonInputData {

    private int cardValue;

    private char cardSuit;

    public CardButtonInputData(int cardValue, char cardSuit) {
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
    }

    public int getCardValue() { return this.cardValue;}

    public char getCardSuit() { return this.cardSuit;}
}
