package interface_adapter.AttackSelect;

import interface_adapter.BattleResult.BattleResultState;
import interface_adapter.BattleResult.BattleResultViewModel;
import interface_adapter.ViewManagerModel;
import use_case.AttackButton.CardButton.CardButtonOutputBoundary;
import use_case.AttackButton.CardButton.CardButtonOutputData;
import view.in_battle.BattleResultView;

public class CardButtonPresenter implements CardButtonOutputBoundary {

    private final BattleResultViewModel battleResultViewModel;

    private final ViewManagerModel viewManagerModel;

    public CardButtonPresenter(BattleResultViewModel battleResultViewModel, ViewManagerModel viewManagerModel) {
        this.battleResultViewModel = battleResultViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(CardButtonOutputData cardButtonOutputData) {

        BattleResultState state = battleResultViewModel.getState();
        state.setPlayerCurrentHealth(cardButtonOutputData.getPlayerCurrentHealth());
        state.setPlayerMaxHealth(cardButtonOutputData.getPlayerMaxHealth());
        state.setPlayerLevel(cardButtonOutputData.getPlayerLevel());
        state.setPlayerAction("attack");
        state.setEnemyHealth(cardButtonOutputData.getEnemyHealth());
        state.setEnemyAction(cardButtonOutputData.getEnemyAction());
        state.setRevivePotionUsed(cardButtonOutputData.getRevivePotionUsed());
        state.setDamageToPlayer(cardButtonOutputData.getDamageToPlayer());
        state.setDamageToEnemy(cardButtonOutputData.getDamageToEnemy());
        this.battleResultViewModel.setState(state);
        battleResultViewModel.firePropertyChanged();

        viewManagerModel.firePropertyChanged();
    }


}
