package use_case.PickUpItem;

import entity.BagAndItems.Bag;
import entity.BagAndItems.Item;
import use_case.movement.MovementOutputData;

public interface PickUpItemOutputBoundary {
    void prepareSuccessView(PickUpItemOutputData pickUpItemOutputData, MovementOutputData movementOutputData);
    void prepareFailView();
    void back(MovementOutputData movementOutputData);
}
