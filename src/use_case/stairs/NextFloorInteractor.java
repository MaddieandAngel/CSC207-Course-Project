package use_case.stairs;

import interface_adapter.stairs.StairsDataAccessInterface;
import use_case.movement.MovementOutputData;

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
        boolean searchable = !(stairsDataAccessObject.getHasBeenSearched());
        MovementOutputData movementOutputData = new MovementOutputData(directions, searchable);

        nextFloorPresenter.prepareStartingRoomView(movementOutputData);
    }
}
