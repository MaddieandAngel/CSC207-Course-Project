package entity;

import entity.BagAndItems.Bag;
import entity.BagAndItems.Package;

import java.util.ArrayList;

public class ActivePlayer implements Player{

    private int currentHealth;
    private int maxHealth;
    private int level;
    private int experiencePoints;
    private int maxCardHold; //Note: unneeded?
    private Bag bag;
    private String[] hand;

    ActivePlayer(){
        //Creates new player at level 1
        level = 1;
        maxHealth = 15;
        currentHealth = 15;
        experiencePoints = 0;
        maxCardHold = 5;
        bag = new Package();
        hand = new String[5];
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

    public int getMaxCardHold(){
        //Note: unneeded?
        return maxCardHold;
    }
  
    public void setMaxCardHold(int cardHold){
        //Note: unneeded?
        maxCardHold = cardHold;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public String[] getHand() { return this.hand;}

    @Override
    public void setHand(String[] hand) { this.hand = hand;}
}
