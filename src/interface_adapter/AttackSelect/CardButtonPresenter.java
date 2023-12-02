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
        state.setPlayerAction("attack");
        state.setEnemyAction(cardButtonOutputData.getEnemyAction());
        state.setRevivePotionUsed(cardButtonOutputData.getRevivePotionUsed());
        state.setDamageToPlayer(cardButtonOutputData.getDamageToPlayer());
        state.setDamageToEnemy(cardButtonOutputData.getDamageToEnemy());
        state.setPlayerCardValue(cardButtonOutputData.getPlayerCardValue());
        state.setPlayerCardSuit(cardButtonOutputData.getPlayerCardSuit());
        state.setPlayerCardImage(cardButtonOutputData.getPlayerCardImage());
        state.setEnemyCardValue(cardButtonOutputData.getEnemyCardValue());
        state.setEnemyCardSuit(cardButtonOutputData.getEnemyCardSuit());
        state.setEnemyCardImage(cardButtonOutputData.getEnemyCardImage());
        state.setDamageBonus(cardButtonOutputData.getDamageBonus());
        this.battleResultViewModel.setState(state);
        battleResultViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(battleResultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }


}
