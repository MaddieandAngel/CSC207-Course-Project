package use_case.DrawButton;

import entity.Enemy;
import interface_adapter.APIAccessInterface;

public class DrawButtonInputData {

    private APIAccessInterface api;

    private Enemy enemy;

    private DeckInterface deck;

    public DrawButtonInputData(APIAccessInterface api, Enemy enemy, DeckInterface deck) {
        this.api = api;
        this.enemy = enemy;
        this.deck = deck;
    }

    public APIAccessInterface getAPI() { return this.api;}

    public int getEnemyHealth() { return this.enemy.getCurrentHealth();}

    public int getEnemyLevel() { return this.enemy.getLevel();}

    public DeckInterface getDeck() { return this.deck;}
}
