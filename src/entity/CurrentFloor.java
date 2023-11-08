package entity;

import java.util.ArrayList;

public class CurrentFloor implements Floor{

    private int length;
    private int width;
    private ArrayList<Room> map;
    private int currentRoom;

    public CurrentFloor(int length, int width){
        this.length = length;
        this.width = width;

        map = new ArrayList<Room>(length * width);
    }

    public int getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(int newIndex){
        if (0 <= newIndex && newIndex < (length * width)){
            currentRoom = newIndex;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean checkForEnemy(){
        return map.get(currentRoom).hasEnemy;
    }

    public boolean checkForItem(){
        return map.get(currentRoom).hasItem;
    }

    public boolean checkForStairs(){
        return map.get(currentRoom).hasStairs;
    }

    public String getDirections(){
        String directions = "";
        if (map.get(currentRoom).hasNorth){
            directions += "N";
        }
        if (map.get(currentRoom).hasEast){
            directions += "E";
        }
        if (map.get(currentRoom).hasSouth){
            directions += "S";
        }
        if (map.get(currentRoom).hasWest){
            directions += "W";
        }
        return directions;
    }

    private class Room{

        boolean hasNorth;
        boolean hasEast;
        boolean hasSouth;
        boolean hasWest;
        boolean hasStairs;
        boolean hasEnemy;
        boolean hasItem;

        Room(){
        }
    }
}
