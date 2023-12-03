package interface_adapter.DropToPick;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import entity.Player;
import use_case.DropToPick.DropToPickInputBoundary;

public class DropToPickController {
    final DropToPickInputBoundary dropToPickInteractor;

    public DropToPickController(DropToPickInputBoundary dropToPickInteractor) {
        this.dropToPickInteractor = dropToPickInteractor;
    }
    public void execute(InBattleDataAccessObject inBattleDataAccessObject){
         dropToPickInteractor.execute(inBattleDataAccessObject.getPlayer());
    }
}
