package use_case.DropToPickPackage;

import entity.ActivePlayer;

public interface DropToPickPackageOutputBoundary {
    void prepareSuccessView();
    void prepareFailView();
    void preparePickItemView(ActivePlayer player);
}
