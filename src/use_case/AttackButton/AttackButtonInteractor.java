package use_case.AttackButton;

public class AttackButtonInteractor implements AttackButtonInputBoundary{

    final AttackButtonOutputBoundary attackButtonPresenter;

    AttackButtonInteractor(AttackButtonOutputBoundary attackButtonPresenter) {
        this.attackButtonPresenter = attackButtonPresenter;
    }

    @Override
    public void execute() {
        // Check if the Player's hand is empty (has 0 cards)
        // If Player.getHand().size() > 0, will call success view (ActionSelectView)
        // Else, will call fail view, (TurnSelectView)

        attackButtonPresenter.prepareSuccessView();
    }
}
