package interface_adapter.turn_select;

import interface_adapter.AttackSelectViewModel;
import interface_adapter.ViewManagerModel;
import use_case.AttackButton.AttackButtonOutputBoundary;

public class AttackButtonPresenter implements AttackButtonOutputBoundary {

    private final AttackSelectViewModel attackSelectViewModel;

    private final ViewManagerModel viewManagerModel;

    public AttackButtonPresenter(AttackSelectViewModel attackSelectViewModel, ViewManagerModel viewManagerModel) {
        this.attackSelectViewModel = attackSelectViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
        attackSelectViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(AttackSelectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
