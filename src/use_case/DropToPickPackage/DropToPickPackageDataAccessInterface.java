package use_case.DropToPickPackage;

import entity.ActivePlayer;

public interface DropToPickPackageDataAccessInterface {
    boolean dropItem(int potionType, ActivePlayer player);
}
