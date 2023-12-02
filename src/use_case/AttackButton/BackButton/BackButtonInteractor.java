package use_case.AttackButton.BackButton;

public class BackButtonInteractor implements BackButtonInputBoundary{

    final BackButtonOutputBoundary backButtonPresenter;

    final BackButtonDataAccessInterface backButtonDataAccessObject;

    public BackButtonInteractor(BackButtonOutputBoundary backButtonPresenter, BackButtonDataAccessInterface backButtonDataAccessObject) {
        this.backButtonPresenter = backButtonPresenter;
        this.backButtonDataAccessObject = backButtonDataAccessObject;
    }

    @Override
    public void execute() {
        // Will always go back to TurnSelectView
        BackButtonOutputData backButtonOutputData = new BackButtonOutputData(backButtonDataAccessObject.getPlayer().getCurrentHealth(),
                backButtonDataAccessObject.getPlayer().getMaxHealth(),
                backButtonDataAccessObject.getPlayer().getLevel());
        backButtonPresenter.prepareSuccessView(backButtonOutputData);
    }
}
