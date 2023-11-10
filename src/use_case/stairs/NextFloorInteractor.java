package use_case.stairs;

import entity.Floor;
import interface_adapter.stairs.StairsDataAccessInterface;

import java.util.Random;

public class NextFloorInteractor implements NextFloorInputBoundary {

    final StairsDataAccessInterface stairsDataAccessObject;
    final NextFloorOutputBoundary nextFloorPresenter;

    public NextFloorInteractor(StairsDataAccessInterface stairsDataAccessObject,
                               NextFloorOutputBoundary nextFloorOutputBoundary){
        this.stairsDataAccessObject = stairsDataAccessObject;
        this.nextFloorPresenter = nextFloorOutputBoundary;
    }
    @Override
    public void execute() {
        Random randomizer = new Random();
        int columns = randomizer.nextInt(3,7);
        int rows = randomizer.nextInt(3, 7);
        String directions = stairsDataAccessObject.MoveToNextFloor(columns, rows);
    }
}
