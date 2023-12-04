package use_case.DropItem;

import use_case.movement.MovementOutputData;

public interface DropItemOutputBoundary {
    void prepareSuccessView();
    void prepareFailView();
    void prepareExploreView(MovementOutputData movementOutputData);
}
