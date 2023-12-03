package interface_adapter.BattleResult;

import interface_adapter.GameOver.GameOverViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.WinBattle.WinBattleViewModel;
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
    public void prepareSuccessView() {
        BattleResultState state = battleResultViewModel.getState();
        if (state.getEnemyCurrentHealth() <= 0){ // Player wins
            viewManagerModel.setActiveView(winBattleViewModel.getViewName());
            winBattleViewModel.firePropertyChanged();
        }
        else if (state.getPlayerCurrentHealth() <= 0) { //Enemy wins
            viewManagerModel.setActiveView(gameOverViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }
        //The battle isn't done
        else{
            viewManagerModel.setActiveView(turnSelectViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }
    }
}
