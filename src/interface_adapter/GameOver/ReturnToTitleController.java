package interface_adapter.GameOver;

import use_case.ReturnToTitleButton.ReturnToTitleInputBoundary;

public class ReturnToTitleController {
    final ReturnToTitleInputBoundary returnToTitleInputBoundary;

    public ReturnToTitleController(ReturnToTitleInputBoundary returnToTitleInputBoundary) {
        this.returnToTitleInputBoundary = returnToTitleInputBoundary;
    }
    public void execute(){
        returnToTitleInputBoundary.execute();
    }
}
