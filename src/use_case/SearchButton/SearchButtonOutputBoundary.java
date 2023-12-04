package use_case.SearchButton;

import entity.BagAndItems.Item;
import use_case.movement.EnemyOutputData;
import use_case.movement.MovementOutputData;

public interface SearchButtonOutputBoundary {
    void prepareEmptyRoomView();
    void prepareTurnSelectView(EnemyOutputData enemyOutputData);
    void prepareItemCollectionView(Item item);
}
