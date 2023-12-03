package use_case.PickUpItem;

import data_access.InBattleDataAccessObject;

public class PickUpItemInteractor implements PickUpItemInputBoundary{
    final PickUpItemDataAccessInterface pickUpItemDataAccessObject;
    final PickUpItemOutputBoundary pickUpItemPresenter;
    final InBattleDataAccessObject inBattleDataAccessObject;

    public PickUpItemInteractor(PickUpItemDataAccessInterface pickUpItemDataAccessObject, PickUpItemOutputBoundary pickUpItemPresenter, InBattleDataAccessObject inBattleDataAccessObject) {
        this.pickUpItemDataAccessObject = pickUpItemDataAccessObject;
        this.pickUpItemPresenter = pickUpItemPresenter;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
    }

    @Override
    public void execute(PickUpItemInputData pickUpItemInputData) {
        boolean success = pickUpItemDataAccessObject.addItem(inBattleDataAccessObject.getPlayer().getBag(), pickUpItemInputData.item);
        PickUpItemOutputData pickUpItemOutputData = new PickUpItemOutputData(inBattleDataAccessObject.getPlayer().getBag());
        if (success){
            pickUpItemPresenter.prepareSuccessView(pickUpItemOutputData);
        }
        else{
            pickUpItemPresenter.prepareFailView();
        }

    }

    @Override
    public void back() {
        pickUpItemPresenter.back();
    }
}
