package use_case.DrawButton;

public class DrawButtonInteractor implements DrawButtonInputBoundary{

    final DrawButtonOutputBoundary drawButtonPresenter;

    final DrawButtonData

    public DrawButtonInteractor(DrawButtonOutputBoundary drawButtonPresenter) {
        this.drawButtonPresenter = drawButtonPresenter;
    }

    @Override
    public void execute(DrawButtonInputData drawButtonInputData) {
        // Player will draw card if their hand is < 5
        int playerHandLength = drawButtonInputData.getAPI().GetCardsInPile(drawButtonInputData.getDeck(), "player").length;
        if (playerHandLength < 5) {
            drawButtonInputData.getAPI().DrawCard(drawButtonInputData.getDeck(), "player");
            // Enemy will make their move
            // Calculate damage done to player by enemy
        } else {
            drawButtonPresenter.prepareFailView("Hand full");
        }
    }
}