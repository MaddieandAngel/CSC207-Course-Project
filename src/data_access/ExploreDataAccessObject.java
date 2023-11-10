package data_access;

import entity.Floor;
import entity.FloorFactory;
import interface_adapter.explore.ExploreDataAccessInterface;
import interface_adapter.stairs.StairsDataAccessInterface;

public class ExploreDataAccessObject implements ExploreDataAccessInterface, StairsDataAccessInterface {

    private int floorLevel;
    private Floor currentFloor;
    private FloorFactory floorFactory;

    public ExploreDataAccessObject(int floorLevel, Floor floor, FloorFactory floorFactory){
        this.floorLevel = floorLevel;
        currentFloor = floor;
        this.floorFactory = floorFactory;
    }

    @Override
    public void moveNorth() {
        currentFloor.setCurrentRoom(currentFloor.getCurrentRoom() - currentFloor.getColumns());
    }

    @Override
    public void moveEast() {
        currentFloor.setCurrentRoom(currentFloor.getCurrentRoom() + 1);
    }

    @Override
    public void moveSouth() {
        currentFloor.setCurrentRoom(currentFloor.getCurrentRoom() + currentFloor.getColumns());
    }

    @Override
    public void moveWest() {
        currentFloor.setCurrentRoom(currentFloor.getCurrentRoom() - 1);
    }

    @Override
    public boolean checkForStairs() {
        return currentFloor.checkForStairs();
    }

    @Override
    public boolean checkForEnemy() {
        return currentFloor.checkForEnemy();
    }

    @Override
    public boolean checkForItem() {
        return currentFloor.checkForItem();
    }

    @Override
    public String getDirections(){
        return currentFloor.getDirections();
    }

    @Override
    public String MoveToNextFloor(int columns, int rows){
        currentFloor = floorFactory.create(columns, rows);
        return getDirections();
    }
}
