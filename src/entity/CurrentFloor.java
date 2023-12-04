package entity;

import java.util.ArrayList;

public class CurrentFloor implements Floor{

    private final int columns;
    private final int rows;
    private final ArrayList<Room> map;
    private int currentRoom;

    public CurrentFloor(int num_columns, int num_rows, ArrayList<Room> map, int startingRoom){
        this.columns = num_columns;
        this.rows = num_rows;
        this.map = map;
        this.currentRoom = startingRoom;
    }

    public int getColumns(){
        return columns;
    }

    public int getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(int newIndex){
        if (0 <= newIndex && newIndex < (columns * rows)){
            currentRoom = newIndex;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean checkForEnemy(){
        return map.get(currentRoom).isHasEnemy();
    }

    public boolean checkForItem(){
        return map.get(currentRoom).isHasItem();
    }

    public boolean checkForStairs(){
        return map.get(currentRoom).isHasStairs();
    }

    public String getDirections(){
        String directions = "";
        if (map.get(currentRoom).isHasNorth()){
            directions += "N";
        }
        if (map.get(currentRoom).isHasEast()){
            directions += "E";
        }
        if (map.get(currentRoom).isHasSouth()){
            directions += "S";
        }
        if (map.get(currentRoom).isHasWest()){
            directions += "W";
        }
        return directions;
    }

    public void removeEnemyFromRoom(){
        map.get(currentRoom).setHasEnemy(false);
    }

    public void removeItemFromRoom(){
        map.get(currentRoom).setHasItem(false);
    }

    public ArrayList<Room> getMap() { //Exclusively needed for testing
        return map;
    }
}
