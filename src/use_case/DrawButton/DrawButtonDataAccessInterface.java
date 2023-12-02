package use_case.DrawButton;

import entity.Enemy;
import entity.Player;
import interface_adapter.APIAccessInterface;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;

public interface DrawButtonDataAccessInterface {

    APIAccessInterface getAPI();

    EnemyBehaviourInterface getEnemyBehaviour();

    Player getPlayer();

    Enemy getEnemy();

}
