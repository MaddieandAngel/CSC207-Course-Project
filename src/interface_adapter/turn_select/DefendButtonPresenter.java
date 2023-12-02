package interface_adapter.turn_select;

import interface_adapter.BattleResult.BattleResultState;
import interface_adapter.BattleResult.BattleResultViewModel;
import interface_adapter.ViewManagerModel;
import use_case.DefendButton.DefendButtonOutputBoundary;
import use_case.DefendButton.DefendButtonOutputData;

public class DefendButtonPresenter implements DefendButtonOutputBoundary {
    private final BattleResultViewModel battleResultViewModel;
    private final ViewManagerModel viewManagerModel;
    public DefendButtonPresenter(BattleResultViewModel battleResultViewModel, ViewManagerModel viewManagerModel){
        this.battleResultViewModel = battleResultViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    public void prepareDefendSuccessView(DefendButtonOutputData defendButtonOutputData) {
        // Update BattleResultState
        BattleResultState battleResultState = battleResultViewModel.getState();
        battleResultState.setPlayerCurrentHealth(defendButtonOutputData.getPlayerCurrentHealth());
        battleResultState.setPlayerMaxHealth(defendButtonOutputData.getPlayerMaxHealth());
        battleResultState.setPlayerLevel(defendButtonOutputData.getPlayerLevel());
        battleResultState.setPlayerAction("defend");
        battleResultState.setEnemyAction(defendButtonOutputData.getEnemyAction());
        battleResultState.setRevivePotionUsed(defendButtonOutputData.isRevivePotionUsed());
        battleResultState.setDamageToPlayer(defendButtonOutputData.getDamageToPlayer());
        battleResultState.setDamageToEnemy(0);
        battleResultState.setPlayerCardValue("");
        battleResultState.setPlayerCardSuit(' ');
        battleResultState.setPlayerCardImage("");
        battleResultState.setEnemyCardValue(defendButtonOutputData.getEnemyCardValue());
        battleResultState.setEnemyCardImage(defendButtonOutputData.getEnemyCardImage());
        battleResultState.setEnemyCardSuit(defendButtonOutputData.getEnemyCardSuit());
        battleResultState.setDamageBonus("");
        battleResultState.setEnemyName(defendButtonOutputData.getEnemyName());

        this.battleResultViewModel.setState(battleResultState);
        battleResultViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(battleResultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

}
