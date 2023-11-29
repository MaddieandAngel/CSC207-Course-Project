package interface_adapter.DropToPick;

import entity.ActivePlayer;
import use_case.DropToPick.DropToPickInputBoundary;

public class DropToPickController {
    final DropToPickInputBoundary dropToPickInteractor;

    public DropToPickController(DropToPickInputBoundary dropToPickInteractor) {
        this.dropToPickInteractor = dropToPickInteractor;
    }
    public void execute(ActivePlayer player){
         dropToPickInteractor.execute(player);
    }
}
