package entity;

import entity.BagAndItems.Item;

import java.util.ArrayList;

public class Player implements Character{

    private int currentHealth;
    private int maxHealth;
    //private Card[] hand;
    private int level;
    private int experiencePoints;
    private ArrayList<Item> inventory;
    private int maxCardHold;

    Player(){
        //Creates new player at level 1
        level = 1;
        maxHealth = 15;
        currentHealth = 15;
        experiencePoints = 0;
        maxCardHold = 5;
    }
    public int getLevel(){
        return level;
    }

    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    @Override
    public void setHealth(int health) {
        currentHealth = health;
    }

    public void levelUp() {
        level++;
        maxHealth = level * 15;
        currentHealth = maxHealth;
        experiencePoints = 0;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int exp){
        experiencePoints = exp;
    }

    public void setMaxCardHold(int cardHold){
        maxCardHold = cardHold;
    }

    public int getMaxCardHold(){
        return maxCardHold;
    }
}
