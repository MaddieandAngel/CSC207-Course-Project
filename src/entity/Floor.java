package entity;

import java.util.ArrayList;

public interface Floor {

    int getColumns();
    int getCurrentRoom();
    void setCurrentRoom(int newIndex);
    boolean checkForEnemy();
    boolean checkForItem();
    boolean checkForStairs();
    String getDirections();
    void removeEnemyFromRoom();
    void removeItemFromRoom();

    ArrayList<Room> getMap(); //Exclusively needed for testing
}
