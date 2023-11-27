package interface_adapter.turn_select;

import entity.Enemy;
import interface_adapter.APIAccessInterface;
import use_case.DrawButton.DrawButtonInputBoundary;
import use_case.DrawButton.DrawButtonInputData;

public class DrawButtonController {

    DrawButtonInputBoundary drawButtonInteractor;

    public DrawButtonController(DrawButtonInputBoundary drawButtonInteractor) {
        this.drawButtonInteractor = drawButtonInteractor;
    }

    public void execute(APIAccessInterface api, Enemy enemy, DeckInterface deck) {
        DrawButtonInputData drawButtonInputData = new DrawButtonInputData(api, enemy, deck);
        drawButtonInteractor.execute(drawButtonInputData);
    }
}
