package interface_adapter.turn_select;

import entity.BagAndItems.Bag;

public class TurnSelectState {

    private int playerHealth = 15; // Integer() instead??
    // ^ Also we can change that initial value later if needed
    private int playerLevel = 1; // Integer() instead??
    // ^ Also not sure if these values should be in a different state
    private String[] playerHand = new String[5]; //May need to change this depending on how the API works
    private Bag playerInventory; //For other items, if we implement them

    /*
    I know a value for the player's current health should be stored in here, since we'll be displaying
    that in the view.

    Maybe we should display the player's level as well. So that can be here too.

    playerHand and playerInventory might not be necessary for this specific state though. I'm not sure.
     */

    // I'm not implementing that "copy" constructor right now, it seems useless in week5ca

    public TurnSelectState(){}

    public int getPlayerHealth(){
        return playerHealth;
    }
    public int getPlayerLevel(){
        return playerLevel;
    }
    public void setPlayerHealth(int current_health){
        this.playerHealth = current_health;
    }
    public void setPlayerLevel(int level){
        this.playerLevel = level;
    }

    public void setPlayerHand(String[] hand) { this.playerHand = hand;}

    public void setPlayerInventory(Bag inventory) {this.playerInventory = inventory;}

    //We can add getter and setter methods for the hand and inventory later, if it turns out we need them.
}
