package interface_adapter.turn_select;

import use_case.DefendButton.DefendButtonInputBoundary;

public class DefendButtonController {
    final DefendButtonInputBoundary defendButtonInteractor;

    public DefendButtonController(DefendButtonInputBoundary defendButtonInteractor) {
        this.defendButtonInteractor = defendButtonInteractor;
    }
    public void execute(){
        defendButtonInteractor.execute();
    }
}

