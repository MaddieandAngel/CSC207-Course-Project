package use_case.stairs;

import interface_adapter.explore.ExploreDataAccessInterface;

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
        StayOnFloorOutputData stayOnFloorOutputData = new StayOnFloorOutputData(directions);

        stayOnFloorPresenter.prepareEmptyRoomView(stayOnFloorOutputData);
    }
}
