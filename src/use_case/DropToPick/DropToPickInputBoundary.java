package use_case.DropToPick;

import entity.ActivePlayer;
import entity.Player;

public interface DropToPickInputBoundary {
    public void execute(Player player);
}
