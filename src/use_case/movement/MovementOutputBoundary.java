package use_case.movement;

public interface MovementOutputBoundary {

    void prepareEmptyRoomView(MovementOutputData movementOutputData);
    void prepareStairsView(MovementOutputData movementOutputData);
    void prepareTurnSelectView(MovementOutputData movementOutputData);
    void prepareItemCollectionView(MovementOutputData movementOutputData);
}
