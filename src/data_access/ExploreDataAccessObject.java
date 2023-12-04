package data_access;

import entity.Floor;
import entity.FloorFactory;
import entity.MapBuilderInterface;
import entity.MapBuilderInterfaceFactory;
import interface_adapter.explore.ExploreDataAccessInterface;
import interface_adapter.stairs.StairsDataAccessInterface;

public class ExploreDataAccessObject implements ExploreDataAccessInterface, StairsDataAccessInterface {

    private int floorLevel = 0;
    private Floor currentFloor;
    private final FloorFactory floorFactory;
    private final MapBuilderInterfaceFactory mapBuilderFactory;

    public ExploreDataAccessObject(FloorFactory floorFactory, MapBuilderInterfaceFactory mapBuilderFactory){
        this.floorFactory = floorFactory;
        this.mapBuilderFactory = mapBuilderFactory;
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
        MapBuilderInterface mapBuilder = mapBuilderFactory.create(columns, rows);
        currentFloor = floorFactory.create(columns, rows, mapBuilder);
        floorLevel++;
        return getDirections();
    }

    @Override
    public int getFloorLevel(){
        return floorLevel;
    }

    @Override
    public void removeEnemyFromRoom(){
        currentFloor.removeEnemyFromRoom();
    }

    @Override
    public void removeItemFromRoom(){
        currentFloor.removeItemFromRoom();
    }

    public void setHasBeenSearched(){
        currentFloor.setHasBeenSearched();
    }

    public boolean getHasBeenSearched(){
        return currentFloor.getHasBeenSearched();
    }
}
