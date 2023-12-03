package interface_adapter.DropToPick;

import entity.ActivePlayer;
import entity.Player;
import use_case.DropToPick.DropToPickInputBoundary;

public class DropToPickController {
    final DropToPickInputBoundary dropToPickInteractor;

    public DropToPickController(DropToPickInputBoundary dropToPickInteractor) {
        this.dropToPickInteractor = dropToPickInteractor;
    }
    public void execute(Player player){
         dropToPickInteractor.execute(player);
    }
}
