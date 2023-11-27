package interface_adapter.AttackSelect;

import entity.Enemy;
import entity.Player;
import use_case.AttackButton.CardButton.CardButtonInputBoundary;
import use_case.AttackButton.CardButton.CardButtonInputData;

public class CardButtonController {

    CardButtonInputBoundary cardButtonInteractor;

    public CardButtonController(CardButtonInputBoundary cardButtonInteractor) {
        this.cardButtonInteractor = cardButtonInteractor;
    }

    public void execute(Player player, Enemy enemy, int cardValue) {
        CardButtonInputData cardButtonInputData = new CardButtonInputData(player, enemy, cardValue);
        cardButtonInteractor.execute(cardButtonInputData);
    }
}
