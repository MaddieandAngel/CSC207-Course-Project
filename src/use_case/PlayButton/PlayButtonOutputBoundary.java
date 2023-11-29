package use_case.PlayButton;

import use_case.movement.MovementOutputData;

public interface PlayButtonOutputBoundary {
    void prepareSuccessView(MovementOutputData movementOutputData);
    void prepareFailView(String error);
}
