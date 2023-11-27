package use_case.movement;

import entity.Character;

public class MovementOutputData {

    private String directions;
    private Character enemy = null; //Maybe should be a string with the enemy name instead
    private Item item = null; //Maybe should be a string with the item name instead

    public MovementOutputData(String directions){
        this.directions = directions;
    }

    public String getDirections() {
        return directions;
    }
    public Character getEnemy() {
        return enemy;
    }
    public Item getItem() {
        return item;
    }
}
