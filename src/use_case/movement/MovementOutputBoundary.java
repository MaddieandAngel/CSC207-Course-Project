package use_case.movement;

public interface MovementOutputBoundary {

    void prepareEmptyRoomView(MovementOutputData movementOutputData);
    void prepareStairsView();
    void prepareTurnSelectView(EnemyOutputData enemyOutputData);
    void prepareItemCollectionView(MovementOutputData movementOutputData);
}
