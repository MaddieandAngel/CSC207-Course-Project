package interface_adapter.DropItems;

import entity.ActivePlayer;
import use_case.DropItem.DropItemInputBoundary;
import use_case.DropItem.DropItemInputData;

public class DropItemsController {
    final DropItemInputBoundary dropItemInteractor;

    public DropItemsController(DropItemInputBoundary dropItemInteractor) {
        this.dropItemInteractor = dropItemInteractor;
    }

    public void execute(ActivePlayer player, int num){
        DropItemInputData useItemInputData = new DropItemInputData(player, num);
        dropItemInteractor.execute(useItemInputData);}

    public void back(){
        dropItemInteractor.back();
    }

}

