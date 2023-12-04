package interface_adapter.ItemSelect;

import interface_adapter.BattleResult.BattleResultState;
import interface_adapter.BattleResult.BattleResultViewModel;
import interface_adapter.ViewManagerModel;
import use_case.ItemsButton.HealButton.HealButtonOutputBoundary;
import use_case.ItemsButton.HealButton.HealButtonOutputData;

public class HealButtonPresenter implements HealButtonOutputBoundary {

    private final BattleResultViewModel battleResultViewModel;

    private final ItemSelectViewModel itemSelectViewModel;

    private final ViewManagerModel viewManagerModel;

    public HealButtonPresenter(BattleResultViewModel battleResultViewModel, ViewManagerModel vewManagerModel, ItemSelectViewModel itemSelectViewModel) {
        this.battleResultViewModel = battleResultViewModel;
        this.viewManagerModel = vewManagerModel;
        this.itemSelectViewModel = itemSelectViewModel;
    }

    @Override
    public void prepareSuccessView(HealButtonOutputData healButtonOutputData) {
        BattleResultState state = battleResultViewModel.getState();
        state.setPlayerCurrentHealth(healButtonOutputData.getPlayerCurrentHealth());
        state.setPlayerAction("heal");
        state.setEnemyAction(healButtonOutputData.getEnemyAction());
        state.setRevivePotionUsed(healButtonOutputData.getReviveUsed());
        state.setDamageToPlayer(healButtonOutputData.getDamageToPlayer());
        state.setDamageToEnemy(0);
        state.setPlayerCardValue("");
        state.setPlayerCardSuit(' ');
        state.setPlayerCardImage("");
        state.setEnemyCardValue(healButtonOutputData.getEnemyCardValue());
        state.setEnemyCardSuit(healButtonOutputData.getEnemyCardSuit());
        state.setEnemyCardImage(healButtonOutputData.getEnemyCardImage());
        state.setDamageBonus("");
        state.setEnemyName(healButtonOutputData.getEnemyName());
        this.battleResultViewModel.setState(state);
        battleResultViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(battleResultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // Will still remain in ItemSelectionView
        ItemSelectState state = itemSelectViewModel.getState();
        state.setItemError(error);
        this.itemSelectViewModel.setState(state);
        itemSelectViewModel.firePropertyChanged();
    }
}
