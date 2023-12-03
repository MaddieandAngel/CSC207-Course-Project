package use_case.DropToPickPackage;

import entity.ActivePlayer;
import entity.Player;
import use_case.DropItem.DropItemInputData;

public interface DropToPickPackageInputBoundary {
    void execute(DropToPickPackageInputData dropToPickPackageInputData);
    void back();
}
