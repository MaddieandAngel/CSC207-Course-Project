package interface_adapter.turn_select;

import interface_adapter.AttackSelect.AttackSelectState;
import interface_adapter.AttackSelect.AttackSelectViewModel;
import interface_adapter.ViewManagerModel;
import use_case.AttackButton.AttackButtonOutputBoundary;
import use_case.AttackButton.AttackButtonOutputData;

public class AttackButtonPresenter implements AttackButtonOutputBoundary {

    private final AttackSelectViewModel attackSelectViewModel;

    private final ViewManagerModel viewManagerModel;

    public AttackButtonPresenter(AttackSelectViewModel attackSelectViewModel, ViewManagerModel viewManagerModel) {
        this.attackSelectViewModel = attackSelectViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(AttackButtonOutputData attackButtonOutputData) {
        attackSelectViewModel.firePropertyChanged();

        AttackSelectState attackSelectState = this.attackSelectViewModel.getState();
        attackSelectState.setPlayerHealth(attackButtonOutputData.getCurrentHealth());
        attackSelectState.setPlayerMaxHealth(attackButtonOutputData.getMaxHealth());
        attackSelectState.setPlayerHand(attackButtonOutputData.getHand());
        this.attackSelectViewModel.setState(attackSelectState);
        attackSelectViewModel.firePropertyChanged();

        viewManagerModel.setActiveView("Attack Select");
        viewManagerModel.firePropertyChanged();

    }
}
