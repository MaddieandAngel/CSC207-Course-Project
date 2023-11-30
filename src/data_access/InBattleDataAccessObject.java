package data_access;

import entity.Deck;
import entity.Enemy;
import entity.Player;
import entity.PlayerFactory;
import interface_adapter.APIAccessInterface;
import interface_adapter.TitleScreen.SaveDeckDataAccessInterface;
import interface_adapter.explore.GenerateEnemyDataAccessInterface;
import use_case.AttackButton.CardButton.CardButtonDataAccessInterface;
import use_case.DrawButton.DrawButtonDataAccessInterface;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;

public class InBattleDataAccessObject implements GenerateEnemyDataAccessInterface, SaveDeckDataAccessInterface, CardButtonDataAccessInterface, BackButtonDataAccessInterface, DrawButtonDataAccessInterface {

    private Player player;
    private Enemy enemy;
    private Deck deck;

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

    @Override
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public EnemyBehaviourInterface getEnemyBehaviour() { return this.enemyBehaviour;}

    public void setEnemyBehaviour(EnemyBehaviourInterface enemyBehaviour) { this.enemyBehaviour = enemyBehaviour;}

    public APIAccessInterface getAPI() { return this.api;}

    public void setAPI(APIAccessInterface api) { this.api = api;}
}
