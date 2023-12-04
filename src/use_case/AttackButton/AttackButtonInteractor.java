package use_case.AttackButton;

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
        String[] playerHand = attackButtonDataAccessInterface.getAPI().GetCardsInPile("player");

        String[] cardCodes = new String[5];
        int i = 0;
        while (i < 5) {
            if (i < playerHand.length) {
                cardCodes[i] = playerHand[i];
            } else {
                cardCodes[i] = null;
            }
            i++;
        }
        String card1Image = cardCodes[0];
        String card2Image = cardCodes[1];
        String card3Image = cardCodes[2];
        String card4Image = cardCodes[3];
        String card5Image = cardCodes[4];

        AttackButtonOutputData attackButtonOutputData = new AttackButtonOutputData(playerHand, card1Image, card2Image,
                card3Image, card4Image, card5Image);

        attackButtonPresenter.prepareSuccessView(attackButtonOutputData);
    }
}
