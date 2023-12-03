package use_case.DefendButton;

import entity.Enemy;
import entity.Player;
import interface_adapter.APIAccessInterface;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;

public interface DefendButtonDataAccessInterface {

    APIAccessInterface getAPI();

    EnemyBehaviourInterface getEnemyBehaviour();

    Player getPlayer();

    Enemy getEnemy();

}
