package data_access;

import entity.Floor;
import entity.FloorFactory;
import interface_adapter.explore.ExploreDataAccessInterface;

public class ExploreDataAccessObject implements ExploreDataAccessInterface {

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

    public String getDirections(){
        return currentFloor.getDirections();
    }

//    public Floor newFloor(){
//        return floorFactory.create();
//    }
}
