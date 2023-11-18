package interface_adapter.UseItems;
import entity.BagAndItems.Item;
import entity.BagAndItems.Bag;
import entity.Player;

import use_case.UseItem.UseItemInputBoundary;
import use_case.UseItem.UseItemInputData;

import java.util.Objects;

public class UseItemsController {
    final UseItemInputBoundary useItemInteractor;

    public UseItemsController(UseItemInputBoundary useItemInteractor) {
        this.useItemInteractor = useItemInteractor;
    }

    public void execute(Player player, int num){
        UseItemInputData useItemInputData = new UseItemInputData(player, num);
        useItemInteractor.execute(useItemInputData);}

    }
