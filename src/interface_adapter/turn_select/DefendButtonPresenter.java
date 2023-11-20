package interface_adapter.turn_select;

import interface_adapter.ViewManagerModel;
import use_case.DefendButton.DefendButtonOutputBoundary;
import view.in_battle.BattleResultView;

public class DefendButtonPresenter implements DefendButtonOutputBoundary {
    private final BattleResultViewModel battleResultViewModel;
    private final TurnSelectViewModel turnSelectViewModel;
    private final ViewManagerModel viewManagerModel;
    public DefendButtonPresenter(BattleResultViewModel battleResultViewModel, TurnSelectViewModel turnSelectViewModel, ViewManagerModel viewManagerModel){
        this.turnSelectViewModel = turnSelectViewModel;
        this.battleResultViewModel = battleResultViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareDefendSuccessView() {
        BattleResultState battleResultState = battleResultViewModel.getState();
        TurnSelectState turnSelectState = turnSelectViewModel.getState();
        this.battleResultViewModel.setState(battleResultState);
        this.turnSelectViewModel.setState(turnSelectState);

        battleResultViewModel.firePropertyChanged();
        turnSelectViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(turnSelectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareDefendFailView() {
        TurnSelectState turnSelectState = turnSelectViewModel.getState();
        turnSelectState.getClearError();
        turnSelectViewModel.firePropertyChanged();
    }
}
