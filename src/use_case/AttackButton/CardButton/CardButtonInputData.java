package use_case.AttackButton.CardButton;

import entity.Enemy;
import entity.Player;

public class CardButtonInputData {

    private String cardCode;

    public CardButtonInputData(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardCode() { return this.cardCode;}
}
