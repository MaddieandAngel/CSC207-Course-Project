package use_case.AttackButton.CardButton;

public class CardButtonOutputData {

    private int updatedPlayerHealth;

    private int updatedEnemyHealth;

    private boolean revivePotionUsed;

    private int damageToEnemy;

    private int damageToPlayer;

    private String enemyAction;

    private int playerMaxHealth;

    private int playerLevel;

    public CardButtonOutputData(int updatedPlayerHealth, int updatedEnemyHealth, boolean revivePotionUsed, int damageToEnemy,
                                int damageToPlayer, String enemyAction, int playerMaxHealth, int playerLevel) {
        this.updatedPlayerHealth = updatedPlayerHealth;
        this.updatedEnemyHealth = updatedEnemyHealth;
        this.revivePotionUsed = revivePotionUsed;
        this.damageToEnemy = damageToEnemy;
        this.damageToPlayer = damageToPlayer;
        this.enemyAction = enemyAction;
        this.playerMaxHealth = playerMaxHealth;
        this.playerLevel = playerLevel;
    }
}
