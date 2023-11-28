package interface_adapter.explore;

public interface ExploreDataAccessInterface {

    void moveNorth();
    void moveEast();
    void moveSouth();
    void moveWest();
    boolean checkForStairs();
    boolean checkForEnemy();
    boolean checkForItem();
    String getDirections();
    int getFloorLevel();
}
