package use_case.DropToPickPackage;

import entity.ActivePlayer;
import entity.Player;

public interface DropToPickPackageOutputBoundary {
    void prepareSuccessView();
    void prepareFailView();
    void preparePickItemView(DropToPickPackageOutputData dropToPickPackageOutputData);
}
