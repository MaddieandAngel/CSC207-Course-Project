package use_case.DropToPickPackage;

import use_case.DropItem.DropItemInputData;

public interface DropToPickPackageInputBoundary {
    void execute(DropToPickPackageInputData dropToPickPackageInputData);
    void back();
}
