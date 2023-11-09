package entity;

public class Room {

    private boolean hasNorth;
    private boolean hasEast;
    private boolean hasSouth;
    private boolean hasWest;
    private boolean hasStairs;
    private boolean hasEnemy;
    private boolean hasItem;
    private boolean hasBeenSearched;

    Room(){
        // Sets everything to false by default
        hasNorth = false;
        hasEast = false;
        hasSouth = false;
        hasWest = false;
        hasStairs = false;
        hasEnemy = false;
        hasItem = false;
        hasBeenSearched = false;
    }

    public boolean isHasNorth(){return hasNorth;}
    public boolean isHasEast(){return hasEast;}
    public boolean isHasSouth(){return hasSouth;}
    public boolean isHasWest(){return hasWest;}
    public boolean isHasStairs(){return hasStairs;}
    public boolean isHasEnemy(){return hasEnemy;}
    public boolean isHasItem(){return hasItem;}
    public boolean isHasBeenSearched() {
        return hasBeenSearched;
    }
    public void setHasNorth(boolean hasNorth){
        this.hasNorth = hasNorth;
    }
    public void setHasEast(boolean hasEast){
        this.hasEast = hasEast;
    }
    public void setHasSouth(boolean hasSouth){this.hasSouth = hasSouth;}
    public void setHasWest(boolean hasWest){
        this.hasWest = hasWest;
    }
    public void setHasStairs(boolean hasStairs){
        this.hasStairs = hasStairs;
    }
    public void setHasEnemy(boolean hasEnemy){
        this.hasEnemy = hasEnemy;
    }
    public void setHasItem(boolean hasItem){
        this.hasItem = hasItem;
    }
    public void setHasBeenSearched(boolean hasBeenSearched) {
        this.hasBeenSearched = hasBeenSearched;
    }
}
