package interface_adapter.DropItems;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import entity.Player;
import use_case.DropItem.DropItemInputBoundary;
import use_case.DropItem.DropItemInputData;

public class DropItemsController {
    final DropItemInputBoundary dropItemInteractor;

    public DropItemsController(DropItemInputBoundary dropItemInteractor) {
        this.dropItemInteractor = dropItemInteractor;
    }

    public void execute(int num){
        DropItemInputData useItemInputData = new DropItemInputData(num);
        dropItemInteractor.execute(useItemInputData);}

    public void back(){
        dropItemInteractor.back();
    }

}

