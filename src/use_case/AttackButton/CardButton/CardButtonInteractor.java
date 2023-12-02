package use_case.AttackButton.CardButton;

import use_case.EnemyBehaviour.EnemyBehaviourOutputData;

import java.io.IOException;

public class CardButtonInteractor implements CardButtonInputBoundary{

    final CardButtonOutputBoundary cardButtonPresenter;

    final CardButtonDataAccessInterface cardButtonDataAccessObject;

    public CardButtonInteractor(CardButtonOutputBoundary cardButtonPresenter, CardButtonDataAccessInterface cardButtonDataAccessObject) {
        this.cardButtonPresenter = cardButtonPresenter;
        this.cardButtonDataAccessObject = cardButtonDataAccessObject;
    }

    @Override
    public void execute(CardButtonInputData cardButtonInputData) throws IOException {
        // Play the card
        cardButtonDataAccessObject.getAPI().CardPlayed("player", cardButtonInputData.getCardCode());

        boolean revivePotionUsed = false;
        int playerCardValue = cardButtonDataAccessObject.getAPI().GetCardValue(cardButtonInputData.getCardCode());
        char playerCardSuit = cardButtonDataAccessObject.getAPI().GetCardSuit(cardButtonInputData.getCardCode());

        // Enemy will make their move
        EnemyBehaviourOutputData enemyMove = cardButtonDataAccessObject.getEnemyBehaviour().performRandomAction();
        String enemyAction = enemyMove.getAction();

        // Calculating the damage done to the enemy (card value * player level)
        int damageToEnemy = cardButtonDataAccessObject.getPlayer().getLevel() * playerCardValue;
        if (enemyAction.equals("defend")) {
            damageToEnemy = (int) Math.ceil(cardButtonDataAccessObject.getPlayer().getLevel() * playerCardValue * 0.5);
        }

        String damageBonus = "";
        // Calculating damage done to player
        int damageToPlayer = 0;
        if (enemyAction.equals("attack")) {
            int enemyCardValue = enemyMove.getCardValue();
            // Damage done to player will be calculated
            damageToPlayer = cardButtonDataAccessObject.getEnemy().getLevel() * enemyCardValue;

            // Determining if there is any damage bonus
            // If enemy suit is weak to player suit, player gets damage bonus
            if (enemyMove.getSuitEnemyIsWeakTo() == playerCardSuit) {
                damageToEnemy = damageToEnemy * 2;
                damageBonus = "player";
            } else if (enemyMove.getSuitEnemyBeats() == playerCardSuit) { // enemy gets damage bonus when player suit is weak to enemy suit
                damageToPlayer = damageToPlayer * 2;
                damageBonus = "enemy";
            }
        }

        // Update health values
        int updatedPlayerHealth = cardButtonDataAccessObject.getPlayer().getCurrentHealth() - damageToPlayer;
        int updatedEnemyHealth = cardButtonDataAccessObject.getEnemy().getCurrentHealth() - damageToEnemy;

        // If both enemy and player health are zero, player wins game, health is fully replenished
        if (updatedPlayerHealth <= 0 && updatedEnemyHealth <= 0) {
            updatedPlayerHealth = cardButtonDataAccessObject.getPlayer().getMaxHealth();
            updatedEnemyHealth = 0;
        }
        // If player's health <= 0 and enemy's health > 0
        if (updatedPlayerHealth <= 0 && updatedEnemyHealth > 0) {
            // Search if player has a revive potion in inventory
            boolean hasRevivePotion = cardButtonDataAccessObject.getPlayer().getBag().numOfRevive() > 0;
            // If player has a revive potion, it is automatically used and player's health is fully restored
            if (hasRevivePotion) {
                cardButtonDataAccessObject.getPlayer().getBag().useItem(0, cardButtonDataAccessObject.getPlayer());
                revivePotionUsed = true;
                updatedPlayerHealth = cardButtonDataAccessObject.getPlayer().getMaxHealth();
            } else {
                // If player does not have a revive potion, player's health remains 0
                updatedPlayerHealth = 0;
            }
        }
        // Else, both player and enemy health > 0, nothing changes

        cardButtonDataAccessObject.getPlayer().setHealth(updatedPlayerHealth);
        cardButtonDataAccessObject.getEnemy().setHealth(updatedEnemyHealth);

        CardButtonOutputData cardButtonOutputData = new CardButtonOutputData(updatedPlayerHealth, revivePotionUsed,
                damageToEnemy, damageToPlayer, enemyAction, cardButtonDataAccessObject.getPlayer().getMaxHealth(),
                cardButtonDataAccessObject.getPlayer().getLevel(), cardButtonInputData.getCardCode().substring(0,
                cardButtonInputData.getCardCode().length() - 1), playerCardSuit,
                cardButtonDataAccessObject.getAPI().GetCardImage(cardButtonInputData.getCardCode()),
                enemyMove.getCardCode().substring(0, enemyMove.getCardCode().length() - 1), enemyMove.getCardSuit(),
                cardButtonDataAccessObject.getAPI().GetCardImage(enemyMove.getCardCode()), damageBonus);
        cardButtonPresenter.prepareSuccessView(cardButtonOutputData);

    }
}
