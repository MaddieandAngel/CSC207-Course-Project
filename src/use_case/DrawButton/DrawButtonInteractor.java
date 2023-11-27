package use_case.DrawButton;

public class DrawButtonInteractor implements DrawButtonInputBoundary{

    final DrawButtonOutputBoundary drawButtonPresenter;

    public DrawButtonInteractor(DrawButtonOutputBoundary drawButtonPresenter) {
        this.drawButtonPresenter = drawButtonPresenter;
    }

    @Override
    public void execute(DrawButtonInputData drawButtonInputData) {
        // Player will draw card
        drawButtonInputData.getAPI().DrawCard(drawButtonInputData.getDeck(), "player");
        // Enemy will make their move
        // Calculate damage done to player by enemy
    }
}
