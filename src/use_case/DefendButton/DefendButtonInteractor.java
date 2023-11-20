package use_case.DefendButton;

import entity.ActivePlayer;
import entity.CurrentEnemy;

public class DefendButtonInteractor implements DefendButtonInputBoundary{
    final DefendButtonOutputBoundary defendPresenter;
    final ActivePlayer activePlayer;
    final CurrentEnemy currentEnemy;

    public DefendButtonInteractor(DefendButtonOutputBoundary defendPresenter, ActivePlayer activePlayer, CurrentEnemy currentEnemy) {
        this.defendPresenter = defendPresenter;
        this.activePlayer = activePlayer;
        this.currentEnemy = currentEnemy;
    }

    public void execute(){

        //TODO: create an EnemyActions class then call to get enemy's action
        // activePlayer.setHealth();
        defendPresenter.prepareDefendSuccessView();
    }
}
