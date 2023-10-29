package interface_adapter.turn_select;

import use_case.DefendButtonInputBoundary;

// TODO: To be implemented
public class DefendButtonController {
    final DefendButtonInputBoundary defendButtonInteractor;

    public DefendButtonController(DefendButtonInputBoundary defendButtonInteractor) {
        this.defendButtonInteractor = defendButtonInteractor;
    }
    public void execute(){
        defendButtonInteractor.execute();
    }
}

