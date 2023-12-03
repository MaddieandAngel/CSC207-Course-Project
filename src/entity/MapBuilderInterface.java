package entity;

import java.util.ArrayList;

public interface MapBuilderInterface {

    int assignAll(ArrayList<Room> map);
    void buildFirstRow(ArrayList<Room> map);
    void buildOtherRows(ArrayList<Room> map, int startIndex);
    void buildFinalRow(ArrayList<Room> map, int startIndex);
}
