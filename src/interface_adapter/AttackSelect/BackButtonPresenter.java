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
        turnSelectViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(turnSelectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
