package interface_adapter.PickUpItem;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import entity.BagAndItems.Item;
import entity.Player;
import use_case.PickUpItem.PickUpItemInputBoundary;
import use_case.PickUpItem.PickUpItemInputData;

public class PickUpItemController {
    final PickUpItemInputBoundary pickUpItemInteractor;

    public PickUpItemController(PickUpItemInputBoundary pickUpItemInteractor) {
        this.pickUpItemInteractor = pickUpItemInteractor;
    }

    public void execute(InBattleDataAccessObject inBattleDataAccessObject, Item item) {
        PickUpItemInputData pickUpItemInputData = new PickUpItemInputData(inBattleDataAccessObject.getPlayer(), item);
        pickUpItemInteractor.execute(pickUpItemInputData);

    }
    public void back(){
        pickUpItemInteractor.back();
    }
}
