package use_case.ItemsButton.HealButton;

import use_case.EnemyBehaviour.EnemyBehaviourOutputData;

import java.io.IOException;

public class HealButtonInteractor implements HealButtonInputBoundary {

    final HealButtonOutputBoundary healButtonPresenter;

    final HealButtonDataAccessInterface healButtonDataAccessObject;

    public HealButtonInteractor(HealButtonOutputBoundary healButtonPresenter, HealButtonDataAccessInterface healButtonDataAccessObject) {
        this.healButtonPresenter= healButtonPresenter;
        this.healButtonDataAccessObject = healButtonDataAccessObject;
    }

    @Override
    public void execute(HealButtonInputData healButtonInputData) throws IOException {
        // Heal player
        healButtonDataAccessObject.getPlayer().getBag().useItem(healButtonInputData.getItemType(), healButtonDataAccessObject.getPlayer());

        boolean revivePotionUsed = false;

        // Enemy will make their move
        EnemyBehaviourOutputData enemyMove = healButtonDataAccessObject.getEnemyBehaviour().performRandomAction();
        String enemyAction = enemyMove.getAction();
        String enemyCardValue = "";
        char enemyCardSuit = ' ';
        String enemyCardImage = "";

        int damageToPlayer = 0;
        // If enemy attacks, calculate damage to player
        if (enemyAction.equals("attack")) {
            enemyCardValue = enemyMove.getCardCode().substring(0, enemyMove.getCardCode().length() - 1);
            enemyCardSuit = enemyMove.getCardSuit();
            enemyCardImage = healButtonDataAccessObject.getAPI().GetCardImage(enemyMove.getCardCode());

            int cardValue = enemyMove.getCardValue();
            damageToPlayer = healButtonDataAccessObject.getEnemy().getLevel() * cardValue;
            // No damage bonus since player is not attacking

            // Update player's health
            int updatedPlayerHealth = healButtonDataAccessObject.getPlayer().getCurrentHealth() - damageToPlayer;

            // If player's health <= 0, look for revive potion
            if (updatedPlayerHealth <= 0) {
                // Search if player has a revive potion in inventory
                boolean hasRevivePotion = healButtonDataAccessObject.getPlayer().getBag().numOfRevive() > 0;
                if (hasRevivePotion) {
                    healButtonDataAccessObject.getPlayer().getBag().useItem(0, healButtonDataAccessObject.getPlayer());
                    revivePotionUsed = true;
                    updatedPlayerHealth = healButtonDataAccessObject.getPlayer().getCurrentHealth();
                } else {
                    updatedPlayerHealth = 0;
                }
            } // else player's health > 0, nothing changes

            // Set player's updated health
            healButtonDataAccessObject.getPlayer().setHealth(updatedPlayerHealth);
        }

        HealButtonOutputData healButtonOutputData = new HealButtonOutputData(healButtonDataAccessObject.getPlayer().getCurrentHealth(),
                enemyAction, revivePotionUsed, damageToPlayer, enemyCardValue, enemyCardSuit, enemyCardImage, healButtonDataAccessObject.getEnemy().getName());
        healButtonPresenter.prepareSuccessView(healButtonOutputData);
    }
}
