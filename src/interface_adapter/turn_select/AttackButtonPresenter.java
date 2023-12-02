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

        AttackSelectState attackSelectState = this.attackSelectViewModel.getState();
        attackSelectState.setPlayerHand(attackButtonOutputData.getHand());
        attackSelectState.setCard1Image(attackButtonOutputData.getCard1Image());
        attackSelectState.setCard2Image(attackButtonOutputData.getCard2Image());
        attackSelectState.setCard3Image(attackButtonOutputData.getCard3Image());
        attackSelectState.setCard4Image(attackButtonOutputData.getCard4Image());
        attackSelectState.setCard5Image(attackButtonOutputData.getCard5Image());
        this.attackSelectViewModel.setState(attackSelectState);
        attackSelectViewModel.firePropertyChanged();

        viewManagerModel.setActiveView("Attack Select");
        viewManagerModel.firePropertyChanged();

    }
}
