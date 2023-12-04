package entity;

import java.util.ArrayList;

public class CurrentFloorFactory implements FloorFactory{
    @Override
    public Floor create(int columns, int rows, MapBuilderInterface mapBuilder) {
        int currentRoom = -1;

        while (currentRoom == -1) { //Generates random floors until one with at least two viable rooms is created

            mapBuilder.buildFirstRow();

            for (int row_num = 1; row_num < rows - 1; row_num++) {
                mapBuilder.buildOtherRows(row_num * columns);
            }
            mapBuilder.buildFinalRow((rows - 1) * columns);

            currentRoom = mapBuilder.assignAll();
        }
        ArrayList<Room> map = mapBuilder.getMap();
        return new CurrentFloor(columns, rows, map, currentRoom);
    }
}
