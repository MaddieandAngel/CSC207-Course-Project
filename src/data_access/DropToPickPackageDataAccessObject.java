package data_access;

import entity.Player;
import use_case.DropToPickPackage.DropToPickPackageDataAccessInterface;

public class DropToPickPackageDataAccessObject implements DropToPickPackageDataAccessInterface {
    @Override
    public boolean dropItem(int potionType, Player player) {
        boolean success = player.getBag().dropItem(potionType);
        return success;
    }
}
