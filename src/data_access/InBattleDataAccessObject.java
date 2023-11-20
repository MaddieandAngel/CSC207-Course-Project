package data_access;

import entity.Deck;
import entity.Enemy;
import entity.Player;
import interface_adapter.explore.GenerateEnemyDataAccessInterface;

public class InBattleDataAccessObject implements GenerateEnemyDataAccessInterface {

    private Player player;
    private Enemy enemy;
    private Deck deck;

    public InBattleDataAccessObject(){}

    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
    }

    @Override
    public void generateInitialEnemyHand() {
        //TODO
    }
}
