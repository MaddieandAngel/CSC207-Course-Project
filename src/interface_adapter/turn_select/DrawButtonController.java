package interface_adapter.turn_select;

import use_case.DrawButton.DrawButtonInputBoundary;

import java.io.IOException;

public class DrawButtonController {

    DrawButtonInputBoundary drawButtonInteractor;

    public DrawButtonController(DrawButtonInputBoundary drawButtonInteractor) {
        this.drawButtonInteractor = drawButtonInteractor;
    }

    public void execute() throws IOException {
        drawButtonInteractor.execute();
    }
}
