package entity;

public class CurrentEnemy implements Enemy{

    private String name;
    private int currentHealth;
    private int level;
    private char suitPreference;
    private int minCardValue;
    private int maxCardValue;
    private String image;
    //private ArrayList<Card> hand;

    public CurrentEnemy(int id, int level){
        this.level = level;
        currentHealth = level * 15;

        if (id == 0){ //Clubs mage
            name = "Clubs Mage";
            suitPreference = 'C';
            minCardValue = 0;
            maxCardValue = 15;
        }
        else if (id == 1){ //Spades mage
            name = "Spades Mage";
            suitPreference = 'S';
            minCardValue = 0;
            maxCardValue = 15;
        }
        else if (id == 2){ //Hearts mage
            name = "Hearts Mage";
            suitPreference = 'H';
            minCardValue = 0;
            maxCardValue = 15;
        }
        else if (id == 3){ //Diamonds mage
            name = "Diamonds Mage";
            suitPreference = 'D';
            minCardValue = 0;
            maxCardValue = 15;
        }
        else if (id == 4){ //Lesser omni mage
            name = "Lesser Omni Mage";
            suitPreference = '\0';
            minCardValue = 1;
            maxCardValue = 7;
        }
        else if (id == 5){ //Greater omni mage
            name = "Greater Omni Mage";
            suitPreference = '\0';
            minCardValue = 7;
            maxCardValue = 15;
        }
        else {
            throw new IndexOutOfBoundsException("No enemy exists with the given id");
        }
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
    public char getPreferredSuit(){
        return suitPreference;
    }
    public int getMinimumPreferredValue(){
        return minCardValue;
    }
    public int getMaximumPreferredValue(){
        return maxCardValue;
    }
}
