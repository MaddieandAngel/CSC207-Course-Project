package entity;

public interface Floor {

    int getCurrentRoom();
    void setCurrentRoom(int newIndex);
    boolean checkForEnemy();
    boolean checkForItem();
    boolean checkForStairs();
    String getDirections();
}
