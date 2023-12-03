package use_case.movement;

import entity.BagAndItems.Item;

public interface MovementOutputBoundary {

    void prepareEmptyRoomView(MovementOutputData movementOutputData);
    void prepareStairsView();
    void prepareTurnSelectView(EnemyOutputData enemyOutputData);
    void prepareItemCollectionView(Item item);
}
