package use_case.PickUpItem;

import entity.BagAndItems.Bag;
import entity.BagAndItems.Item;

public interface PickUpItemOutputBoundary {
    void prepareSuccessView(PickUpItemOutputData pickUpItemOutputData);
    void prepareFailView();
    void back();
}
