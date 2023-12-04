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
        int handSize = attackButtonOutputData.getHand().length;
        if (handSize >= 1) {
           attackSelectState.setHas1Card(true);
        } else {
            attackSelectState.setHas1Card(false);
        }
        if (handSize >= 2) {
            attackSelectState.setHas2Cards(true);
        } else {
            attackSelectState.setHas2Cards(false);
        }
        if (handSize >= 3) {
            attackSelectState.setHas3Cards(true);
        } else {
            attackSelectState.setHas3Cards(false);
        }
        if (handSize >= 4) {
            attackSelectState.setHas4Cards(true);
        } else {
            attackSelectState.setHas4Cards(false);
        }
        if (handSize == 5) {
            attackSelectState.setHas5Cards(true);
        } else {
            attackSelectState.setHas5Cards(false);
        }
        attackSelectState.setPlayerHand(attackButtonOutputData.getHand());
        attackSelectState.setCard1Image(attackButtonOutputData.getCard1Image());
        attackSelectState.setCard2Image(attackButtonOutputData.getCard2Image());
        attackSelectState.setCard3Image(attackButtonOutputData.getCard3Image());
        attackSelectState.setCard4Image(attackButtonOutputData.getCard4Image());
        attackSelectState.setCard5Image(attackButtonOutputData.getCard5Image());
        this.attackSelectViewModel.setState(attackSelectState);
        attackSelectViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(attackSelectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
