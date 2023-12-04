package entity;

import java.util.ArrayList;
import java.util.Random;

public class MapBuilder implements MapBuilderInterface{

    int columns;
    int rows;
    ArrayList<Room> map;
    Random randomizer;

    public MapBuilder(int columns, int rows){
        this.columns = columns;
        this.rows = rows;
        map = new ArrayList<>(columns * rows);
        randomizer = new Random();
    }

    public int assignAll(){
        int enemyCount = randomizer.nextInt(1, (columns * rows / 3) + 1);
        int itemCount = randomizer.nextInt(0, (columns * rows / 3) + 1);

        int stairLocation = assignStairs();
        assignEnemies(enemyCount);
        assignItems(itemCount);

        return assignStartingRoom(stairLocation);
    }

    public void buildFirstRow(){ // rowIndex = 0
        //First room of first row, always has nothing to the west or north
        map.add(new Room());
        map.get(0).setHasEast(randomizer.nextBoolean());
        map.get(0).setHasSouth(randomizer.nextBoolean());

        for (int c = 1; c < columns - 1; c++){
            map.add(new Room());
            map.get(c).setHasWest(map.get(c - 1).isHasEast());
            map.get(c).setHasEast(randomizer.nextBoolean());
            map.get(c).setHasSouth(randomizer.nextBoolean());
        }

        //Final room of the first row, always has nothing to the east or north
        map.add(new Room());
        map.get(columns - 1).setHasWest(map.get(columns - 2).isHasEast());
        map.get(columns - 1).setHasSouth(randomizer.nextBoolean());
    }

    public void buildOtherRows(int startIndex){
        assert map.size() == startIndex;
        //First room of new row, always has nothing to the west
        map.add(new Room());
        map.get(startIndex).setHasNorth(map.get(startIndex - columns).isHasSouth());
        map.get(startIndex).setHasEast(randomizer.nextBoolean());
        map.get(startIndex).setHasSouth(randomizer.nextBoolean());

        for (int c = startIndex + 1; c < startIndex + columns - 1; c++){
            map.add(new Room());
            map.get(c).setHasNorth(map.get(c - columns).isHasSouth());
            map.get(c).setHasWest(map.get(c - 1).isHasEast());
            map.get(c).setHasEast(randomizer.nextBoolean());
            map.get(c).setHasSouth(randomizer.nextBoolean());
        }

        //Final room of new row, always has nothing to the east
        map.add(new Room());
        map.get(startIndex + columns - 1).setHasNorth(map.get(startIndex - 1).isHasSouth());
        map.get(startIndex + columns - 1).setHasWest(map.get(startIndex + columns - 2).isHasEast());
        map.get(startIndex + columns - 1).setHasSouth(randomizer.nextBoolean());
    }

    public void buildFinalRow(int startIndex){
        assert map.size() == startIndex;
        //First room of final row, always has nothing to the west or south
        map.add(new Room());
        map.get(startIndex).setHasNorth(map.get(startIndex - columns).isHasSouth());
        map.get(startIndex).setHasEast(randomizer.nextBoolean());

        for (int c = startIndex + 1; c < startIndex + columns - 1; c++){
            map.add(new Room());
            map.get(c).setHasNorth(map.get(c - columns).isHasSouth());
            map.get(c).setHasWest(map.get(c - 1).isHasEast());
            map.get(c).setHasEast(randomizer.nextBoolean());
        }

        //Final room of final row, always has nothing to the east or south
        map.add(new Room());
        map.get(startIndex + columns - 1).setHasNorth(map.get(startIndex - 1).isHasSouth());
        map.get(startIndex + columns - 1).setHasWest(map.get(startIndex + columns - 2).isHasEast());
    }

    private int assignStairs(){
        int stairLocation = randomizer.nextInt(0, map.size());
        while (isRoomFilled(stairLocation)){
            stairLocation = randomizer.nextInt(0, map.size());
        }
        map.get(stairLocation).setHasStairs(true);
        return stairLocation;
    }

    private void assignEnemies(int enemyCount){
        for (int numAdded = 0; numAdded < enemyCount; numAdded++){
            int enemyLocation = randomizer.nextInt(0, map.size());
            while (isRoomFilled(enemyLocation)){
                // Re-rolls if selected room is already occupied by something
                enemyLocation = randomizer.nextInt(0, map.size());
            }
            map.get(enemyLocation).setHasEnemy(true);
        }
    }

    private void assignItems(int itemCount){
        for (int numAdded = 0; numAdded < itemCount; numAdded++){
            int itemLocation = randomizer.nextInt(0, map.size());
            while (isRoomFilled(itemLocation)){
                // Re-rolls if selected room is already occupied by something
                itemLocation = randomizer.nextInt(0, map.size());
            }
            map.get(itemLocation).setHasItem(true);
        }
    }

    private int assignStartingRoom(int stairLocation){
        ArrayList<Integer> possibleStartingRooms = getConnectedRooms(map, stairLocation, new ArrayList<>());

        if (possibleStartingRooms.size() < 2){ //Only possible room to start in is the stairs room (bad)
            return -1;
        }
        else {
            return possibleStartingRooms.get(randomizer.nextInt(0, possibleStartingRooms.size()));
        }
    }

    private boolean isRoomFilled(int roomIndex){
        return (map.get(roomIndex).isHasStairs() || map.get(roomIndex).isHasEnemy() || map.get(roomIndex).isHasItem());
    }

    private ArrayList<Integer> getConnectedRooms(ArrayList<Room> map, int roomToCheck,
                                                 ArrayList<Integer> connectedRooms){
        connectedRooms.add(roomToCheck);
        ArrayList<Integer> neighbours = new ArrayList<>();
        if (map.get(roomToCheck).isHasNorth()){
            neighbours.add(roomToCheck - columns);
        }
        if (map.get(roomToCheck).isHasEast()){
            neighbours.add(roomToCheck + 1);
        }
        if (map.get(roomToCheck).isHasSouth()){
            neighbours.add(roomToCheck + columns);
        }
        if (map.get(roomToCheck).isHasWest()){
            neighbours.add(roomToCheck - 1);
        }

        for (Integer neighbour : neighbours) {
            if (!connectedRooms.contains(neighbour)) {
                connectedRooms.addAll(getConnectedRooms(map, neighbour, connectedRooms));
            }
        }
        return connectedRooms;
    }

    public ArrayList<Room> getMap(){
        return map;
    }

}
