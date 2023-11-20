package interface_adapter.PickUpItem;

import entity.BagAndItems.Item;
import use_case.PickUpItem.PickUpItemInputBoundary;
import use_case.PickUpItem.PickUpItemInputData;

public class PickUpItemController {
    final PickUpItemInputBoundary pickUpItemInteractor;

    public PickUpItemController(PickUpItemInputBoundary pickUpItemInteractor) {
        this.pickUpItemInteractor = pickUpItemInteractor;
    }

    public void execute(Player player, Item item) {
        PickUpItemInputData pickUpItemInputData = new PickUpItemInputData(player, item);
        pickUpItemInteractor.execute(pickUpItemInputData);

    }
}
