package entity;

import java.util.ArrayList;

public interface MapBuilderInterface {

    int assignAll();
    void buildFirstRow();
    void buildOtherRows(int startIndex);
    void buildFinalRow(int startIndex);
    ArrayList<Room> getMap();
}
