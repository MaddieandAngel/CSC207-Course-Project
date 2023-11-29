package interface_adapter.AttackSelect;

import interface_adapter.ViewManagerModel;
import interface_adapter.turn_select.TurnSelectState;
import interface_adapter.turn_select.TurnSelectViewModel;
import use_case.AttackButton.BackButton.BackButtonOutputBoundary;
import use_case.AttackButton.BackButton.BackButtonOutputData;

public class BackButtonPresenter implements BackButtonOutputBoundary {

    private final TurnSelectViewModel turnSelectViewModel;

    private final ViewManagerModel viewManagerModel;

    public BackButtonPresenter(TurnSelectViewModel turnSelectViewModel, ViewManagerModel viewManagerModel) {
        this.turnSelectViewModel = turnSelectViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(BackButtonOutputData backButtonOutputData) {

        TurnSelectState state = new TurnSelectState();
        state.setPlayerHealth(backButtonOutputData.getCurrentHealth());
        state.setPlayerMaxHealth(backButtonOutputData.getMaxHealth());
        state.setPlayerLevel(backButtonOutputData.getPlayerLevel());
        this.turnSelectViewModel.setState(state);
        turnSelectViewModel.firePropertyChanged();

        viewManagerModel.firePropertyChanged();

    }
}
