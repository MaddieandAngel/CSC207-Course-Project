package data_access;

import entity.ActivePlayer;
import use_case.DropToPickPackage.DropToPickPackageDataAccessInterface;

public class DropToPickPackageDataAccessObject implements DropToPickPackageDataAccessInterface {
    @Override
    public boolean dropItem(int potionType, ActivePlayer player) {
        boolean success = player.getBag().dropItem(potionType);
        return success;
    }
}
