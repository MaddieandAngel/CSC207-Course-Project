package use_case.EnemyBehaviour;

import entity.Enemy;

import java.io.IOException;

public interface EnemyBehaviourInterface {

    EnemyBehaviourOutputData performRandomAction(Enemy enemy) throws IOException;

    void enemyDrawInitialHand(Enemy enemy) throws IOException;
}
