package entity;

import java.util.ArrayList;

public class CurrentFloor implements Floor{

    private final int columns;
    private final int rows;
    private ArrayList<Room> map;
    private int currentRoom = -1;

    public CurrentFloor(int num_columns, int num_rows){
        this.columns = num_columns;
        this.rows = num_rows;

        MapBuilder mapBuilder = new MapBuilder(columns, rows);

        while (currentRoom == -1) { //Generates random floors until one with at least two viable rooms is created
            map = mapBuilder.buildMapLayout();
            currentRoom = mapBuilder.assignAll(map);
        }
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
}
