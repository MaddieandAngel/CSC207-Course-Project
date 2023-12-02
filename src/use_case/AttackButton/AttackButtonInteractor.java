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

        String[] cardImages = new String[5];
        int i = 0;
        while (i < 5) {
            if (i < playerHand.length) {
                cardImages[i] = attackButtonDataAccessInterface.getAPI().GetCardImage(playerHand[i]);
            } else {
                cardImages[i] = null;
            }
            i++;
        }
        String card1Image = cardImages[0];
        String card2Image = cardImages[1];
        String card3Image = cardImages[2];
        String card4Image = cardImages[3];
        String card5Image = cardImages[4];

        AttackButtonOutputData attackButtonOutputData = new AttackButtonOutputData(playerHand, card1Image, card2Image,
                card3Image, card4Image, card5Image);

        attackButtonPresenter.prepareSuccessView(attackButtonOutputData);
    }
}
