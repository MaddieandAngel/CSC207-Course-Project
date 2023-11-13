package entity;

import java.util.ArrayList;
import java.util.Random;

public class MapBuilder {

    int columns;
    int rows;
    Random randomizer;

    MapBuilder(int length, int width){
        this.columns = length;
        this.rows = width;
        randomizer = new Random();
    }

    public ArrayList<Room> buildMapLayout(){
        ArrayList<Room> map = new ArrayList<>(columns * rows);

        buildFirstRow(map);

        for (int row_num = 1; row_num < rows - 1; row_num++){
            buildOtherRows(map, row_num * columns);
        }

        buildFinalRow(map, (rows - 1) * columns);

        return map;
    }

    public int assignAll(ArrayList<Room> map){
        int enemyCount = randomizer.nextInt(1, (columns * rows / 3) + 1);
        int itemCount = randomizer.nextInt(0, (columns * rows / 3) + 1);

        int stairLocation = assignStairs(map);
        assignEnemies(map, enemyCount);
        assignItems(map, itemCount);

        return assignStartingRoom(map, stairLocation);
    }

    private void buildFirstRow(ArrayList<Room> map){ // rowIndex = 0
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

    private void buildOtherRows(ArrayList<Room> map, int startIndex){
        assert map.size() == startIndex;
        //First room of new row, always has nothing to the west
        map.add(new Room());
        map.get(startIndex).setHasNorth(map.get(startIndex - columns).isHasSouth());
        map.get(startIndex).setHasEast(randomizer.nextBoolean());
        map.get(startIndex).setHasSouth(randomizer.nextBoolean());

        for (int c = startIndex + 1; c < columns - 1; c++){
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

    private void buildFinalRow(ArrayList<Room> map, int startIndex){
        assert map.size() == startIndex;
        //First room of final row, always has nothing to the west or south
        map.add(new Room());
        map.get(startIndex).setHasNorth(map.get(startIndex - columns).isHasSouth());
        map.get(startIndex).setHasEast(randomizer.nextBoolean());

        for (int c = startIndex + 1; c < columns - 1; c++){
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

    private int assignStairs(ArrayList<Room> map){
        int stairLocation = randomizer.nextInt(0, map.size());
        while (isRoomFilled(map, stairLocation)){
            stairLocation = randomizer.nextInt(0, map.size());
        }
        map.get(stairLocation).setHasStairs(true);
        return stairLocation;
    }

    private void assignEnemies(ArrayList<Room> map, int enemyCount){
        for (int numAdded = 0; numAdded < enemyCount; numAdded++){
            int enemyLocation = randomizer.nextInt(0, map.size());
            while (isRoomFilled(map, enemyLocation)){
                // Re-rolls if selected room is already occupied by something
                enemyLocation = randomizer.nextInt(0, map.size());
            }
            map.get(enemyLocation).setHasEnemy(true);
        }
    }

    private void assignItems(ArrayList<Room> map, int itemCount){
        for (int numAdded = 0; numAdded < itemCount; numAdded++){
            int itemLocation = randomizer.nextInt(0, map.size());
            while (isRoomFilled(map, itemLocation)){
                // Re-rolls if selected room is already occupied by something
                itemLocation = randomizer.nextInt(0, map.size());
            }
            map.get(itemLocation).setHasItem(true);
        }
    }

    private int assignStartingRoom(ArrayList<Room> map, int stairLocation){
        ArrayList<Integer> possibleStartingRooms = getConnectedRooms(map, stairLocation, new ArrayList<>());

        if (possibleStartingRooms.size() < 2){ //Only possible room to start in is the stairs room (bad)
            return -1;
        }
        else {
            return possibleStartingRooms.get(randomizer.nextInt(0, possibleStartingRooms.size()));
        }
    }

    private boolean isRoomFilled(ArrayList<Room> map, int roomIndex){
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

}
