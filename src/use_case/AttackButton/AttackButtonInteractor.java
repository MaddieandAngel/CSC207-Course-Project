package use_case.AttackButton;

import entity.Player;

public class AttackButtonInteractor implements AttackButtonInputBoundary{

    final AttackButtonOutputBoundary attackButtonPresenter;

    AttackButtonInteractor(AttackButtonOutputBoundary attackButtonPresenter) {
        this.attackButtonPresenter = attackButtonPresenter;
    }

    @Override
    public void execute(AttackButtonInputData attackButtonInputData) {
        Player player = attackButtonInputData.getCurrentPlayer();
        AttackButtonOutputData attackButtonOutputData = new AttackButtonOutputData(player.getCurrentHealth(), player.getMaxHealth(), player.getHand());

        attackButtonPresenter.prepareSuccessView(attackButtonOutputData);
    }
}
