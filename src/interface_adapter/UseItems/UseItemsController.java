package interface_adapter.UseItems;

import use_case.UseItem.UseItemInputBoundary;
import use_case.UseItem.UseItemInputData;

public class UseItemsController {
    final UseItemInputBoundary useItemInteractor;

    public UseItemsController(UseItemInputBoundary useItemInteractor) {
        this.useItemInteractor = useItemInteractor;
    }

    public void execute(Player player, int num){
        UseItemInputData useItemInputData = new UseItemInputData(player, num);
        useItemInteractor.execute(useItemInputData);}

    }
