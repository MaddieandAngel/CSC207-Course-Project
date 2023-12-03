package use_case.PickUpItem;

public class PickUpItemInteractor implements PickUpItemInputBoundary{
    final PickUpItemDataAccessInterface pickUpItemDataAccessObject;
    final PickUpItemOutputBoundary pickUpItemPresenter;

    public PickUpItemInteractor(PickUpItemDataAccessInterface pickUpItemDataAccessObject, PickUpItemOutputBoundary pickUpItemPresenter) {
        this.pickUpItemDataAccessObject = pickUpItemDataAccessObject;
        this.pickUpItemPresenter = pickUpItemPresenter;
    }

    @Override
    public void execute(PickUpItemInputData pickUpItemInputData) {
        boolean success = pickUpItemDataAccessObject.addItem(pickUpItemInputData.getBag(), pickUpItemInputData.item);
        PickUpItemOutputData pickUpItemOutputData = new PickUpItemOutputData(pickUpItemInputData.getBag());
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
