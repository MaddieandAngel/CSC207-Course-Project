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

    public ArrayList<Room> buildAll(){
        ArrayList<Room> map = new ArrayList<>(columns * rows);

        buildFirstRow(map);

        for (int row_num = 1; row_num < rows - 1; row_num++){
            buildOtherRows(map, row_num * columns);
        }

        buildFinalRow(map, (rows - 1) * columns);

        // TODO: Assign enemies, stairs, and items to rooms

        return map;
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
}
