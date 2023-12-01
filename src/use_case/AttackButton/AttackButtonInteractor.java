package use_case.AttackButton;

import entity.Player;

import java.io.IOException;

public class AttackButtonInteractor implements AttackButtonInputBoundary{

    final AttackButtonOutputBoundary attackButtonPresenter;

    final AttackButtonDataAccessInterface attackButtonDataAccessInterface;

    public AttackButtonInteractor(AttackButtonOutputBoundary attackButtonPresenter, AttackButtonDataAccessInterface attackButtonDataAccessInterface) {
        this.attackButtonPresenter = attackButtonPresenter;
        this.attackButtonDataAccessInterface = attackButtonDataAccessInterface;
    }

    @Override
    public void execute() throws IOException {
        AttackButtonOutputData attackButtonOutputData = new AttackButtonOutputData(attackButtonDataAccessInterface.getPlayer().getCurrentHealth(),
                attackButtonDataAccessInterface.getPlayer().getMaxHealth(), attackButtonDataAccessInterface.getAPI().GetCardsInPile("player"));

        attackButtonPresenter.prepareSuccessView(attackButtonOutputData);
    }
}
