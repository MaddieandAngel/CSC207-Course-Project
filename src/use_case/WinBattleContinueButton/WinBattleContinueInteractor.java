package use_case.WinBattleContinueButton;

import data_access.ExploreDataAccessObject;
import use_case.movement.MovementOutputData;

public class WinBattleContinueInteractor implements WinBattleContinueInputBoundary{
    final WinBattleContinueOutputBoundary winBattleContinueOutputBoundary;
    final ExploreDataAccessObject exploreDataAccessObject;

    public WinBattleContinueInteractor(WinBattleContinueOutputBoundary winBattleContinueOutputBoundary, ExploreDataAccessObject exploreDataAccessObject) {
        this.winBattleContinueOutputBoundary = winBattleContinueOutputBoundary;
        this.exploreDataAccessObject = exploreDataAccessObject;
    }

    @Override
    public void execute() {
        MovementOutputData movementOutputData = new MovementOutputData(this.exploreDataAccessObject.getDirections());
        winBattleContinueOutputBoundary.prepareSuccessView(movementOutputData);
    }
}
