package use_case.DrawButton;

public class DrawButtonOutputData {

    private int playerCurrentHealth;

    private int playerMaxHealth;

    private int playerLevel;

    private String enemyAction;

    private int enemyHealth;

    private boolean revivePotionUsed;

    private int damageToPlayer;

    public DrawButtonOutputData(int playerCurrentHealth, int playerMaxHealth, int playerLevel, String enemyAction, int enemyHealth,
                                boolean revivePotionUsed, int damageToPlayer) {
        this.playerCurrentHealth = playerCurrentHealth;
        this.playerMaxHealth = playerMaxHealth;
        this.playerLevel = playerLevel;
        this.enemyAction = enemyAction;
        this.enemyHealth = enemyHealth;
        this.revivePotionUsed = revivePotionUsed;
        this.damageToPlayer = damageToPlayer;
    }

    public int getPlayerCurrentHealth() { return this.playerCurrentHealth;}

    public int getPlayerMaxHealth() { return this.playerMaxHealth;}

    public int getPlayerLevel() { return this.playerLevel;}

    public String getEnemyAction() { return this.enemyAction;}

    public int getEnemyHealth() { return this.enemyHealth;}

    public boolean revivePotionUsed() { return this.revivePotionUsed;}

    public int getDamageToPlayer() { return this.damageToPlayer;}
}
