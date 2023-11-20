package interface_adapter.stairs;

import use_case.stairs.NextFloorInputBoundary;

public class NextFloorController {

    final NextFloorInputBoundary nextFloorUseCaseInteractor;

    public NextFloorController(NextFloorInputBoundary nextFloorUseCaseInteractor){
        this.nextFloorUseCaseInteractor = nextFloorUseCaseInteractor;
    }
    public void execute(){
        nextFloorUseCaseInteractor.execute();
    }
}
