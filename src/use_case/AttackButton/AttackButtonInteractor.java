package use_case.AttackButton;

public class AttackButtonInteractor implements AttackButtonInputBoundary{

    final AttackButtonOutputBoundary attackButtonPresenter;

    AttackButtonInteractor(AttackButtonOutputBoundary attackButtonPresenter) {
        this.attackButtonPresenter = attackButtonPresenter;
    }

    @Override
    public void execute() {

        attackButtonPresenter.prepareSuccessView();
    }
}
