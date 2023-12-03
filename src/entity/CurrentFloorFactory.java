package entity;

import java.util.ArrayList;

public class CurrentFloorFactory implements FloorFactory{
    @Override
    public Floor create(int columns, int rows, MapBuilderInterface mapBuilder) {
        ArrayList<Room> map = new ArrayList<>(columns * rows);
        int currentRoom = -1;

        while (currentRoom == -1) { //Generates random floors until one with at least two viable rooms is created

            mapBuilder.buildFirstRow(map);

            for (int row_num = 1; row_num < rows - 1; row_num++) {
                mapBuilder.buildOtherRows(map, row_num * columns);
            }
            mapBuilder.buildFinalRow(map, (rows - 1) * columns);

            currentRoom = mapBuilder.assignAll(map);
        }
        return new CurrentFloor(columns, rows, map, currentRoom);
    }
}
