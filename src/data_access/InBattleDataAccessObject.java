package data_access;

import entity.Enemy;
import entity.Player;
import entity.PlayerFactory;
import interface_adapter.APIAccessInterface;
import interface_adapter.explore.GenerateEnemyDataAccessInterface;
import use_case.AttackButton.AttackButtonDataAccessInterface;
import use_case.AttackButton.BackButton.BackButtonDataAccessInterface;
import use_case.AttackButton.CardButton.CardButtonDataAccessInterface;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;
import use_case.DefendButton.DefendButtonDataAccessInterface;
import use_case.DrawButton.DrawButtonDataAccessInterface;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;
import use_case.ItemsButton.HealButton.HealButtonDataAccessInterface;
import use_case.ItemsButton.ItemsButtonDataAccessInterface;

public class InBattleDataAccessObject implements GenerateEnemyDataAccessInterface, CardButtonDataAccessInterface, BackButtonDataAccessInterface,
        AttackButtonDataAccessInterface, DrawButtonDataAccessInterface, ItemsButtonDataAccessInterface, HealButtonDataAccessInterface,
        DefendButtonDataAccessInterface {

    private Player player;
    private Enemy enemy;

    private APIAccessInterface api;

    private EnemyBehaviourInterface enemyBehaviour;

    public InBattleDataAccessObject(PlayerFactory playerFactory, APIAccessInterface api, EnemyBehaviourInterface enemyBehaviour){
        this.player = playerFactory.create();
        this.api = api;
        this.enemyBehaviour = enemyBehaviour;
    }

    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public Enemy getEnemy() {
        return enemy;
    }

    public EnemyBehaviourInterface getEnemyBehaviour() { return this.enemyBehaviour;}

    public void setEnemyBehaviour(EnemyBehaviourInterface enemyBehaviour) { this.enemyBehaviour = enemyBehaviour;}

    public APIAccessInterface getAPI() { return this.api;}

    public void setAPI(APIAccessInterface api) { this.api = api;}
}
