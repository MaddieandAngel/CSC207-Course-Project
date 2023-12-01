package data_access;

import entity.Deck;
import entity.Enemy;
import entity.Player;
import entity.PlayerFactory;
import interface_adapter.APIAccessInterface;
import interface_adapter.TitleScreen.SaveDeckDataAccessInterface;
import interface_adapter.explore.GenerateEnemyDataAccessInterface;
import use_case.AttackButton.AttackButtonDataAccessInterface;
import use_case.AttackButton.BackButton.BackButtonDataAccessInterface;
import use_case.AttackButton.CardButton.CardButtonDataAccessInterface;
import use_case.EnemyBehaviour.EnemyBehaviour;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;

import java.io.IOException;

public class InBattleDataAccessObject implements GenerateEnemyDataAccessInterface, SaveDeckDataAccessInterface, CardButtonDataAccessInterface, BackButtonDataAccessInterface, AttackButtonDataAccessInterface {

    private Player player;
    private Enemy enemy;

    private EnemyBehaviourInterface enemyBehaviour;

    private APIAccessInterface api;

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

    public void setEnemyBehaviourInterface(EnemyBehaviourInterface enemyBehaviour) { this.enemyBehaviour = enemyBehaviour;}

    public EnemyBehaviourInterface getEnemyBehaviour() { return this.enemyBehaviour;}

    public APIAccessInterface getAPI() { return this.api;}
}
