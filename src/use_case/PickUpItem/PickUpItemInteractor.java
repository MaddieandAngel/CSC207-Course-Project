package use_case.PickUpItem;

import data_access.InBattleDataAccessObject;
import interface_adapter.explore.ExploreDataAccessInterface;
import use_case.movement.MovementOutputData;

public class PickUpItemInteractor implements PickUpItemInputBoundary{
    final PickUpItemDataAccessInterface pickUpItemDataAccessObject;
    final PickUpItemOutputBoundary pickUpItemPresenter;
    final InBattleDataAccessObject inBattleDataAccessObject;
    final ExploreDataAccessInterface exploreDataAccessObject;

    public PickUpItemInteractor(PickUpItemDataAccessInterface pickUpItemDataAccessObject, PickUpItemOutputBoundary pickUpItemPresenter,
                                InBattleDataAccessObject inBattleDataAccessObject, ExploreDataAccessInterface exploreDataAccessObject) {
        this.pickUpItemDataAccessObject = pickUpItemDataAccessObject;
        this.pickUpItemPresenter = pickUpItemPresenter;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
        this.exploreDataAccessObject = exploreDataAccessObject;
    }

    @Override
    public void execute(PickUpItemInputData pickUpItemInputData) {
        boolean success = pickUpItemDataAccessObject.addItem(inBattleDataAccessObject.getPlayer().getBag(), pickUpItemInputData.item);
        PickUpItemOutputData pickUpItemOutputData = new PickUpItemOutputData(inBattleDataAccessObject.getPlayer().getBag());

        String directions = exploreDataAccessObject.getDirections();
        boolean searchable = !(exploreDataAccessObject.getHasBeenSearched());
        MovementOutputData movementOutputData = new MovementOutputData(directions, searchable);

        if (success){
            pickUpItemPresenter.prepareSuccessView(pickUpItemOutputData, movementOutputData);
        }
        else{
            pickUpItemPresenter.prepareFailView();
        }

    }

    @Override
    public void back() {
        String directions = exploreDataAccessObject.getDirections();
        boolean searchable = !(exploreDataAccessObject.getHasBeenSearched());
        MovementOutputData movementOutputData = new MovementOutputData(directions, searchable);
        pickUpItemPresenter.back(movementOutputData);
    }
}
