package use_case.DrawButton;

import use_case.EnemyBehaviour.EnemyBehaviourOutputData;
import use_case.movement.EnemyOutputData;

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
        if (playerHandLength < 5) {
            drawButtonDataAccessObject.getAPI().DrawCard("player");

            // Enemy will make their move
            EnemyBehaviourOutputData enemyBehaviour = drawButtonDataAccessObject.getEnemyBehaviour().performRandomAction();
            String enemyAction = enemyBehaviour.getAction();

            // Calculate damage done to player by enemy
            int damageToPlayer = 0;

            if (enemyAction.equals("attack")) {
                damageToPlayer = drawButtonDataAccessObject.getEnemy().getLevel() * enemyBehaviour.getCardValue();
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

            // Create output data
            DrawButtonOutputData drawButtonOutputData = new DrawButtonOutputData(updatedPlayerHealth, drawButtonDataAccessObject.getPlayer().getMaxHealth(),
                    drawButtonDataAccessObject.getPlayer().getLevel(), enemyAction, drawButtonDataAccessObject.getEnemy().getCurrentHealth(), reviveUsed, damageToPlayer);
            drawButtonPresenter.prepareSuccessView(drawButtonOutputData);

        } else {
            drawButtonPresenter.prepareFailView("Hand full");
        }

    }
}
