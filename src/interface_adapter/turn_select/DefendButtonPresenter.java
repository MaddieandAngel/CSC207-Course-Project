package interface_adapter.turn_select;

import interface_adapter.BattleResult.BattleResultState;
import interface_adapter.BattleResult.BattleResultViewModel;
import interface_adapter.ViewManagerModel;
import use_case.DefendButton.DefendButtonOutputBoundary;
import view.in_battle.BattleResultView;

public class DefendButtonPresenter implements DefendButtonOutputBoundary {
    private final BattleResultViewModel battleResultViewModel;
    private final ViewManagerModel viewManagerModel;
    public DefendButtonPresenter(BattleResultViewModel battleResultViewModel, ViewManagerModel viewManagerModel){
        this.battleResultViewModel = battleResultViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareDefendSuccessView(int playerHealth, int enemyHealth) {
        BattleResultState battleResultState = battleResultViewModel.getState();

        if (playerHealth <= 0){
            battleResultState.setWinner("player");
            battleResultState.setContinueBattle(false);
        }
        if(enemyHealth <= 0){
            battleResultState.setWinner("enemy");
            battleResultState.setContinueBattle(false);
        }

        this.battleResultViewModel.setState(battleResultState);

        battleResultViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(battleResultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
