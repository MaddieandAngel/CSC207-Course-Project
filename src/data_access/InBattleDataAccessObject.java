package data_access;

import entity.Deck;
import entity.Enemy;
import entity.Player;
import entity.PlayerFactory;
import interface_adapter.TitleScreen.SaveDeckDataAccessInterface;
import interface_adapter.explore.GenerateEnemyDataAccessInterface;

public class InBattleDataAccessObject implements GenerateEnemyDataAccessInterface, SaveDeckDataAccessInterface {

    private Player player;
    private Enemy enemy;
    private Deck deck;

    public InBattleDataAccessObject(PlayerFactory playerFactory){
        this.player = playerFactory.create();
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
}
