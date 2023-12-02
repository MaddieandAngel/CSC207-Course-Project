package use_case.DefendButton;

import use_case.DrawButton.DrawButtonOutputData;
import use_case.EnemyBehaviour.EnemyBehaviourOutputData;

import java.io.IOException;

public class DefendButtonInteractor implements DefendButtonInputBoundary{
    final DefendButtonOutputBoundary defendPresenter;
    final DefendButtonDataAccessInterface defendButtonDataAccessObject;

    public DefendButtonInteractor(DefendButtonOutputBoundary defendPresenter, DefendButtonDataAccessInterface defendButtonDataAccessObject) {
        this.defendPresenter = defendPresenter;
        this.defendButtonDataAccessObject = defendButtonDataAccessObject;
    }

    public void execute() throws IOException {
        // create an EnemyActions class then call to get enemy's action
        EnemyBehaviourOutputData enemyBehaviour = defendButtonDataAccessObject.getEnemyBehaviour().performRandomAction();
        String enemyAction = enemyBehaviour.getAction();
        String enemyCardValue = "";
        char enemyCardSuit = ' ';
        String enemyCardImage = "";
        int damageToPlayer = 0;
        boolean reviveUsed = false;

        // If the enemy attacked, calculate the damage the enemy has done to the player
        // Keep in mind, defend reduces enemy damage by 50%
        if (enemyAction.equals("attack")) {
            damageToPlayer = defendButtonDataAccessObject.getEnemy().getLevel() * enemyBehaviour.getCardValue() / 2;
            enemyCardValue = enemyBehaviour.getCardCode().substring(0, enemyBehaviour.getCardCode().length() - 1);
            enemyCardSuit = enemyBehaviour.getCardSuit();
            enemyCardImage = defendButtonDataAccessObject.getAPI().GetCardImage(enemyBehaviour.getCardCode());
        }
        // Update health of player
        int updatedPlayerHealth = defendButtonDataAccessObject.getPlayer().getCurrentHealth() - damageToPlayer;
        // If player's health <= 0, check if player has a revive potion, if so restore player to max health
        if (updatedPlayerHealth <= 0){
            boolean hasRevivePotion = defendButtonDataAccessObject.getPlayer().getBag().numOfRevive() > 0;
            if (hasRevivePotion) {
                defendButtonDataAccessObject.getPlayer().getBag().useItem(0, defendButtonDataAccessObject.getPlayer());
                reviveUsed = true;
                updatedPlayerHealth = defendButtonDataAccessObject.getPlayer().getMaxHealth();
            } else {
                updatedPlayerHealth = 0;
            }
        }

        DefendButtonOutputData defendButtonOutputData = new DefendButtonOutputData(updatedPlayerHealth, defendButtonDataAccessObject.getPlayer().getMaxHealth(),
                defendButtonDataAccessObject.getPlayer().getLevel(), enemyAction, reviveUsed, damageToPlayer, enemyCardValue, enemyCardSuit, enemyCardImage,
                defendButtonDataAccessObject.getEnemy().getName());

        //Send player's health and enemy's health to the presenter
        defendPresenter.prepareDefendSuccessView(defendButtonOutputData);
    }
}
