package use_case.DrawButton;

import entity.Enemy;
import interface_adapter.APIAccessInterface;

public class DrawButtonInputData {

    private APIAccessInterface api;

    private Enemy enemy;

    public DrawButtonInputData(APIAccessInterface api, Enemy enemy) {
        this.api = api;
        this.enemy = enemy;
    }

    public APIAccessInterface getAPI() { return this.api;}

    public int getEnemyHealth() { return this.enemy.getCurrentHealth();}

    public int getEnemyLevel() { return this.enemy.getLevel();}
}
