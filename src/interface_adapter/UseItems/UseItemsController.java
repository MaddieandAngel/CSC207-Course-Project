package interface_adapter.UseItems;
import entity.BagAndItems.Item;

import use_case.UseItem.UseItemInputBoundary;
import use_case.UseItem.UseItemInputData;

public class UseItemsController {
    final UseItemInputBoundary useItemInteractor;

    public UseItemsController(UseItemInputBoundary useItemInteractor) {
        this.useItemInteractor = useItemInteractor;
    }

    public void execute(Item item){
        UseItemInputData useItemInputData = new UseItemInputData(item);
        useItemInteractor.execute(useItemInputData);
    }
}
