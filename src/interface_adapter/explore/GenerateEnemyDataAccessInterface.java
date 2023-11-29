package interface_adapter.explore;

import entity.Deck;
import entity.Enemy;

public interface GenerateEnemyDataAccessInterface {
    void setEnemy(Enemy enemy);
    Enemy getEnemy();
    Deck getDeck();
}
