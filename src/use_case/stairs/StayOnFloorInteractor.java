package use_case.stairs;

import interface_adapter.explore.ExploreDataAccessInterface;
import use_case.movement.MovementOutputData;

public class StayOnFloorInteractor implements StayOnFloorInputBoundary{

    final ExploreDataAccessInterface exploreDataAccessObject; //Note: change to its own specific interface??
    final StayOnFloorOutputBoundary stayOnFloorPresenter;

    public StayOnFloorInteractor(ExploreDataAccessInterface exploreDataAccessObject,
                                 StayOnFloorOutputBoundary stayOnFloorOutputBoundary){
        this.exploreDataAccessObject = exploreDataAccessObject;
        this.stayOnFloorPresenter = stayOnFloorOutputBoundary;
    }
    @Override
    public void execute() {
        String directions = exploreDataAccessObject.getDirections();
        boolean searchable = !(exploreDataAccessObject.getHasBeenSearched());
        MovementOutputData movementOutputData = new MovementOutputData(directions, searchable);

        stayOnFloorPresenter.prepareEmptyRoomView(movementOutputData);
    }
}
