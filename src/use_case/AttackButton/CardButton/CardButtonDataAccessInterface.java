package use_case.AttackButton.CardButton;

import entity.Enemy;
import entity.Player;
import interface_adapter.APIAccessInterface;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;

public interface CardButtonDataAccessInterface {

    EnemyBehaviourInterface getEnemyBehaviour();

    Player getPlayer();

    Enemy getEnemy();

    APIAccessInterface getAPI();

}
