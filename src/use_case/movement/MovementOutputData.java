package use_case.movement;

import entity.Character;
import entity.Item;

public class MovementOutputData {

    private String directions;
    private Character enemy = null;
    private Item item = null;

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
