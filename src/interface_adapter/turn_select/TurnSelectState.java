package interface_adapter.turn_select;

public class TurnSelectState {

    private int playerHealth = 15; // Integer() instead??
    // ^ Also we can change that initial value later if needed
    private int playerLevel = 1; // Integer() instead??
    // ^ Also not sure if these values should be in a different state
    private String playerHand = ""; //May need to change this depending on how the API works
    private String playerInventory = ""; //For other items, if we implement them
    private String drawError = null; // Becomes the pop-up message for when a player tries to draw a card when their hand is full

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

    public void setDrawError(String error) {this.drawError = error;}

    //We can add getter and setter methods for the hand and inventory later, if it turns out we need them.
}
