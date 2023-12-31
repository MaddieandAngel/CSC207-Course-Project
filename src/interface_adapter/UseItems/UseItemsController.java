package interface_adapter.UseItems;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import entity.Player;
import use_case.UseItem.UseItemInputBoundary;
import use_case.UseItem.UseItemInputData;

public class UseItemsController {
    final UseItemInputBoundary useItemInteractor;

    public UseItemsController(UseItemInputBoundary useItemInteractor) {
        this.useItemInteractor = useItemInteractor;
    }

    public void execute(int num){
        UseItemInputData useItemInputData = new UseItemInputData(num);
        useItemInteractor.execute(useItemInputData);}

    }
