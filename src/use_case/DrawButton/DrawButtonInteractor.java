package use_case.DrawButton;

import use_case.EnemyBehaviour.EnemyBehaviourOutputData;

import java.io.IOException;

public class DrawButtonInteractor implements DrawButtonInputBoundary{

    final DrawButtonOutputBoundary drawButtonPresenter;

    final DrawButtonDataAccessInterface drawButtonDataAccessObject;

    public DrawButtonInteractor(DrawButtonOutputBoundary drawButtonPresenter, DrawButtonDataAccessInterface drawButtonDataAccessObject) {
        this.drawButtonPresenter = drawButtonPresenter;
        this.drawButtonDataAccessObject = drawButtonDataAccessObject;
    }

    @Override
    public void execute() throws IOException {
        boolean reviveUsed = false;

        // Player will draw card if their hand is < 5
        int playerHandLength = drawButtonDataAccessObject.getAPI().GetCardsInPile("player").length;
        String playerCardCode = "";
        String playerCardValue = "";
        char playerCardSuit = ' ';
        String playerCardImage = "";

        if (playerHandLength < 5) {
            drawButtonDataAccessObject.getAPI().DrawCard("player");
            playerCardCode = drawButtonDataAccessObject.getAPI().GetCardsInPile("player")[playerHandLength];
            playerCardValue = playerCardCode.substring(0, playerCardCode.length() - 1);
            playerCardSuit = drawButtonDataAccessObject.getAPI().GetCardSuit(playerCardCode);
            playerCardImage = drawButtonDataAccessObject.getAPI().GetCardImage(playerCardCode);

            // Enemy will make their move
            EnemyBehaviourOutputData enemyBehaviour = drawButtonDataAccessObject.getEnemyBehaviour().performRandomAction();
            String enemyAction = enemyBehaviour.getAction();
            String enemyCardValue = "";
            char enemyCardSuit = ' ';
            String enemyCardImage = "";

            // Calculate damage done to player by enemy
            int damageToPlayer = 0;

            if (enemyAction.equals("attack")) {
                damageToPlayer = drawButtonDataAccessObject.getEnemy().getLevel() * enemyBehaviour.getCardValue();
                enemyCardValue = enemyBehaviour.getCardCode().substring(0, enemyBehaviour.getCardCode().length() - 1);
                enemyCardSuit = enemyBehaviour.getCardSuit();
                enemyCardImage = drawButtonDataAccessObject.getAPI().GetCardImage(enemyBehaviour.getCardCode());
            }

            // Update health of player
            int updatedPlayerHealth = drawButtonDataAccessObject.getPlayer().getCurrentHealth() - damageToPlayer;

            // If player's health <= 0, check if player has revive potion, if so it's automatically used and player is restored to max health
            if (updatedPlayerHealth <= 0) {
                boolean hasRevivePotion = drawButtonDataAccessObject.getPlayer().getBag().numOfRevive() > 0;
                if (hasRevivePotion) {
                    drawButtonDataAccessObject.getPlayer().getBag().useItem(0, drawButtonDataAccessObject.getPlayer());
                    reviveUsed = true;
                    updatedPlayerHealth = drawButtonDataAccessObject.getPlayer().getMaxHealth();
                } else { // If not player's health remains 0
                    updatedPlayerHealth = 0;
                }
            }

            // Update player's health
            drawButtonDataAccessObject.getPlayer().setHealth(updatedPlayerHealth);

            // Create output data
            DrawButtonOutputData drawButtonOutputData = new DrawButtonOutputData(updatedPlayerHealth, drawButtonDataAccessObject.getPlayer().getMaxHealth(),
                    drawButtonDataAccessObject.getPlayer().getLevel(), enemyAction, reviveUsed, damageToPlayer, playerCardValue,
                    playerCardSuit, playerCardImage, enemyCardValue, enemyCardSuit, enemyCardImage, drawButtonDataAccessObject.getEnemy().getName());
            drawButtonPresenter.prepareSuccessView(drawButtonOutputData);

        } else {
            drawButtonPresenter.prepareFailView("Hand full");
        }

    }
}
