package interface_adapter.DropItems;

import use_case.DropItem.DropItemInputBoundary;
import use_case.DropItem.DropItemInputData;

public class DropItemsController {
    final DropItemInputBoundary dropItemInteractor;

    public DropItemsController(DropItemInputBoundary dropItemInteractor) {
        this.dropItemInteractor = dropItemInteractor;
    }

    public void execute(Player player, int num){
        DropItemInputData useItemInputData = new DropItemInputData(player, num);
        dropItemInteractor.execute(useItemInputData);}

}

