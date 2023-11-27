package use_case.AttackButton.CardButton;

public class CardButtonInteractor implements CardButtonInputBoundary{

    final CardButtonOutputBoundary cardButtonPresenter;

    public CardButtonInteractor(CardButtonOutputBoundary cardButtonPresenter) {
        this.cardButtonPresenter = cardButtonPresenter;
    }

    @Override
    public void execute(CardButtonInputData cardButtonInputData) {
        boolean revivePotionUsed = false;
        // Enemy will make their move
        EnemyBehaviourOutputData enemyMove = EnemyBehaviour.performRandomAction();
        String enemyAction = enemyMove.getAction();
        if (enemyAction.equals("attack")) {
            int enemyCardValue = enemyMove.getCardValue();
            // Damage done to player will be calculated (card value * player level)
            int damageToPlayer = cardButtonInputData.getEnemyLevel() * enemyCardValue;
        } else {
            // Damage is not done to player
            int damageToPlayer = 0;
        }

        // Calculating the damage done to the enemy (card value * player level)
        if (enemyAction.equals("defend")) {
            int damageToEnemy = (int) Math.ceil(cardButtonInputData.getPlayerLevel() * cardButtonInputData.getCardValue() * 0.5);
        } else {
            int damageToEnemy = cardButtonInputData.getPlayerLevel() * cardButtonInputData.getCardValue();
        }

        // Update health values
        int updatedPlayerHealth = cardButtonInputData.getPlayerCurrentHealth() - damageToPlayer;
        int updatedEnemyHealth = cardButtonInputData.getEnemyHealth() - damageToEnemy;

        // If both enemy and player health are zero, player wins game, health is fully replenished
        if (updatedPlayerHealth <= 0 && updatedEnemyHealth <= 0) {
            updatedPlayerHealth = cardButtonInputData.getPlayerMaxHealth();
            updatedEnemyHealth = 0;
        }
        // If player's health == 0 and enemy's health > 0
        if (updatedPlayerHealth <= 0 && updatedEnemyHealth > 0) {
            // Search if player has a revive potion in inventory
            boolean hasRevivePotion = cardButtonInputData.hasRevivePotion();
            // If player has a revive potion, it is automatically used and player's health is fully resotred
            if (hasRevivePotion) {
                cardButtonInputData.useRevivePotion();
                revivePotionUsed = true;
                updatedPlayerHealth = cardButtonInputData.getPlayerMaxHealth();
            } else {
                // If player does not have a revive potion, player's health remains 0
                updatedPlayerHealth = 0;
            }
        }
        // Else, both player and enemy health > 0, nothing changes

        CardButtonOutputData cardButtonOutputData = new CardButtonOutputData(updatedPlayerHealth, updatedEnemyHealth, revivePotionUsed,
                damageToEnemy, damageToPlayer, enemyAction, cardButtonInputData.getPlayerMaxHealth(), cardButtonInputData.getPlayerLevel());
        cardButtonPresenter.prepareSuccessView(cardButtonOutputData);

    }
}
