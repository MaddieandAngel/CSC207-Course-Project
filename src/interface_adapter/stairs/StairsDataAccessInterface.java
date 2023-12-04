package interface_adapter.stairs;

import entity.Floor;

public interface StairsDataAccessInterface {

    String MoveToNextFloor(int columns, int rows);
    boolean getHasBeenSearched();
}
