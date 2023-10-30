package entity;

public class Enemy implements Character{
    private int currentHealth;
    //private Card[] hand;

    Enemy(int currentHealth){
        this.currentHealth = currentHealth;
    }

    @Override
    public int getHealth() {
        return currentHealth;
    }

    @Override
    public void setHealth() {

    }
}
