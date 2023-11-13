package use_case.stairs;

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
        int columns = randomizer.nextInt(4,7);
        int rows = randomizer.nextInt(4, 7);
        String directions = stairsDataAccessObject.MoveToNextFloor(columns, rows);
        NextFloorOutputData nextFloorOutputData = new NextFloorOutputData(directions);

        nextFloorPresenter.prepareStartingRoomView(nextFloorOutputData);
    }
}
