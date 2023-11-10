package interface_adapter.stairs;

import use_case.stairs.StayOnFloorInputBoundary;

public class StayOnFloorController {

    final StayOnFloorInputBoundary stayOnFloorUseCaseInteractor;

    public StayOnFloorController(StayOnFloorInputBoundary stayOnFloorUseCaseInteractor){
        this.stayOnFloorUseCaseInteractor = stayOnFloorUseCaseInteractor;
    }

    public void execute(){
        stayOnFloorUseCaseInteractor.execute();
    }
}
