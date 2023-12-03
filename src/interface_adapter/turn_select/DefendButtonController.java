package interface_adapter.turn_select;

import use_case.DefendButton.DefendButtonInputBoundary;

import java.io.IOException;

public class DefendButtonController {
    final DefendButtonInputBoundary defendButtonInteractor;

    public DefendButtonController(DefendButtonInputBoundary defendButtonInteractor) {
        this.defendButtonInteractor = defendButtonInteractor;
    }
    public void execute() throws IOException {
        defendButtonInteractor.execute();
    }
}

