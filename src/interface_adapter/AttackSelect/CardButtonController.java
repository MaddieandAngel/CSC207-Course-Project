package interface_adapter.AttackSelect;

import entity.Enemy;
import entity.Player;
import use_case.AttackButton.CardButton.CardButtonInputBoundary;
import use_case.AttackButton.CardButton.CardButtonInputData;

import java.io.IOException;

public class CardButtonController {

    CardButtonInputBoundary cardButtonInteractor;

    public CardButtonController(CardButtonInputBoundary cardButtonInteractor) {
        this.cardButtonInteractor = cardButtonInteractor;
    }

    public void execute(String cardCode) throws IOException {
        CardButtonInputData cardButtonInputData = new CardButtonInputData(cardCode);
        cardButtonInteractor.execute(cardButtonInputData);
    }
}
