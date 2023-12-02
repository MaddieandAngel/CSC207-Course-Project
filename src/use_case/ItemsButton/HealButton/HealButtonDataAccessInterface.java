package use_case.ItemsButton.HealButton;

import entity.Enemy;
import entity.Player;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;

public interface HealButtonDataAccessInterface {

    Player getPlayer();

    EnemyBehaviourInterface getEnemyBehaviour();

    Enemy getEnemy();
}
