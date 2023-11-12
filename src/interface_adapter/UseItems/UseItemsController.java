package interface_adapter.UseItems;
import entity.BagAndItems.Item;
import entity.BagAndItems.Bag;
import entity.Player;

import use_case.UseItem.UseItemInputBoundary;
import use_case.UseItem.UseItemInputData;

public class UseItemsController {
    final UseItemInputBoundary useItemInteractor;

    public UseItemsController(UseItemInputBoundary useItemInteractor) {
        this.useItemInteractor = useItemInteractor;
    }

    public void execute(Item item, Bag bag, Player player){
        UseItemInputData useItemInputData = new UseItemInputData(item, bag, player);
        useItemInteractor.execute(useItemInputData);
    }
}
