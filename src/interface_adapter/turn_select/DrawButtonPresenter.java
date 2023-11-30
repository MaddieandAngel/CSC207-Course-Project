package interface_adapter.turn_select;

import interface_adapter.BattleResult.BattleResultState;
import interface_adapter.BattleResult.BattleResultViewModel;
import interface_adapter.ViewManagerModel;
import use_case.DrawButton.DrawButtonOutputBoundary;
import use_case.DrawButton.DrawButtonOutputData;

public class DrawButtonPresenter implements DrawButtonOutputBoundary {

    private final BattleResultViewModel battleResultViewModel;

    private final TurnSelectViewModel turnSelectViewModel;

    private ViewManagerModel viewManagerModel;

    public DrawButtonPresenter(BattleResultViewModel battleResultViewModel, TurnSelectViewModel turnSelectViewModel, ViewManagerModel viewManagerModel) {
        this.battleResultViewModel = battleResultViewModel;
        this.turnSelectViewModel = turnSelectViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DrawButtonOutputData drawButtonOutputData) {
        // When a card is successfully drawn, switch to BattleResultView
        BattleResultState state = battleResultViewModel.getState();
        // Update all the values in the battle result state
        state.setPlayerCurrentHealth(drawButtonOutputData.getPlayerCurrentHealth());
        state.setPlayerMaxHealth(drawButtonOutputData.getPlayerMaxHealth());
        state.setPlayerLevel(drawButtonOutputData.getPlayerLevel());
        state.setEnemyAction(drawButtonOutputData.getEnemyAction());
        state.setEnemyHealth(drawButtonOutputData.getEnemyHealth());
        state.setRevivePotionUsed(drawButtonOutputData.revivePotionUsed());
        state.setDamageToPlayer(drawButtonOutputData.getDamageToPlayer());
        state.setDamageToEnemy(0);
        state.setPlayerAction("draw");
        this.battleResultViewModel.setState(state);
        battleResultViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(battleResultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // Will remain in TurnSelectView since the player did not make their turn (since they could not draw)
        TurnSelectState turnSelectState = turnSelectViewModel.getState();
        turnSelectState.setDrawError(error);
        turnSelectViewModel.firePropertyChanged();
    }
}
