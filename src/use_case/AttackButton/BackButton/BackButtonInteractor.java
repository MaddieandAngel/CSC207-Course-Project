package use_case.AttackButton.BackButton;

public class BackButtonInteractor implements BackButtonInputBoundary{

    final BackButtonOutputBoundary backButtonPresenter;

    public BackButtonInteractor(BackButtonOutputBoundary backButtonPresenter) {
        this.backButtonPresenter = backButtonPresenter;
    }

    @Override
    public void execute(BackButtonInputData backButtonInputData) {
        // Will always go back to TurnSelectView
        BackButtonOutputData backButtonOutputData = new BackButtonOutputData(backButtonInputData.player.getCurrentHealth(),backButtonInputData.player.getHand(),
                backButtonInputData.player.getLevel(), backButtonInputData.player.getBag());
        backButtonPresenter.prepareSuccessView(backButtonOutputData);
    }
}
