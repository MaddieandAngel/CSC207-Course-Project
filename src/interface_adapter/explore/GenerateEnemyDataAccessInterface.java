package interface_adapter.explore;

import entity.Enemy;

public interface GenerateEnemyDataAccessInterface {
    void setEnemy(Enemy enemy);
    void generateInitialEnemyHand();
}
