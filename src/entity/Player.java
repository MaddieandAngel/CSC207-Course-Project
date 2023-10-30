package entity;

import java.util.ArrayList;

public class Player implements Character{

    private int currentHealth;
    private int maxHealth;
    //private Card[] hand;
    private int level;
    private int experiencePoints;
    private ArrayList<Item> inventory;

    Player(int currentHealth, int maxHealth, int level, int experiencePoints, ArrayList<Item> inventory){
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.level = level;
        this.experiencePoints = experiencePoints;
        this.inventory = inventory;
    }



    @Override
    public int getHealth() {
        return currentHealth;
    }

    @Override
    public void setHealth() {

    }
}
