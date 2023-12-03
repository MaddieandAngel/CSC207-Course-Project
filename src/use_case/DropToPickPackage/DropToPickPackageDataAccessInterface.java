package use_case.DropToPickPackage;

import entity.ActivePlayer;
import entity.Player;

public interface DropToPickPackageDataAccessInterface {
    boolean dropItem(int potionType, Player player);
}
