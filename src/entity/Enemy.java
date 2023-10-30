package entity;

public class Enemy implements Character{

    //TODO: add suit and value preferences
    private String name;
    private int currentHealth;
    private int level;

    //private Card[] hand;

    Enemy(int id, int level){
        this.level = level;
        currentHealth = level * 15;

        if (id == 0){
            name = "";
        }
        else if (id == 1){
            name = "";
        }
        //TODO: do more for this. or delete it later and turn Enemy into an abstract class. we'll see

    }

    public int getLevel(){
        return level;
    }

    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public void setHealth(int health) {
        currentHealth = health;
    }

    public String getName(){
        return name;
    }
}
