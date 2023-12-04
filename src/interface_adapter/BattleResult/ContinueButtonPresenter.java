package interface_adapter.BattleResult;

import interface_adapter.GameOver.GameOverViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.WinBattle.WinBattleState;
import interface_adapter.WinBattle.WinBattleViewModel;
import interface_adapter.turn_select.TurnSelectState;
import interface_adapter.turn_select.TurnSelectViewModel;
import use_case.BattleResultContinueButton.BattleResultContinueOutputBoundary;

public class ContinueButtonPresenter implements BattleResultContinueOutputBoundary {
    private final TurnSelectViewModel turnSelectViewModel;
    private final BattleResultViewModel battleResultViewModel;
    private final GameOverViewModel gameOverViewModel;
    private final WinBattleViewModel winBattleViewModel;
    private final ViewManagerModel viewManagerModel;

    public ContinueButtonPresenter(TurnSelectViewModel turnSelectViewModel, BattleResultViewModel battleResultViewModel, GameOverViewModel gameOverViewModel, WinBattleViewModel winBattleViewModel, ViewManagerModel viewManagerModel) {
        this.turnSelectViewModel = turnSelectViewModel;
        this.battleResultViewModel = battleResultViewModel;
        this.gameOverViewModel = gameOverViewModel;
        this.winBattleViewModel = winBattleViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareWinBattleView() {
        WinBattleState winBattleState = winBattleViewModel.getState();
        winBattleState.setExpGained(20);
        winBattleState.setTotalExp(winBattleState.getExpGained() + 20);
        if (winBattleState.getTotalExp() == 100){
            winBattleState.setTotalExp(winBattleState.getTotalExp() % 100);
            winBattleState.setPlayerLevel(winBattleState.getPlayerLevel() + 1);
            winBattleState.setDidPlayerLevelUp(true);
        }
        winBattleViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(winBattleViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareGameOverView() {
        viewManagerModel.setActiveView(gameOverViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareTurnSelectView() {
        TurnSelectState state = turnSelectViewModel.getState();
        BattleResultState battleResultState = battleResultViewModel.getState();
        state.setPlayerHealth(battleResultState.getPlayerCurrentHealth());
        turnSelectViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(turnSelectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
