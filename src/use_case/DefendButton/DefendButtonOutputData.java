package use_case.DefendButton;

public class DefendButtonOutputData {
    private int playerCurrentHealth;
    private int playerMaxHealth;
    private int playerLevel;
    private String enemyAction;
    private boolean revivePotionUsed;
    private int damageToPlayer;
    private String enemyCardValue;
    private char enemyCardSuit;
    private String enemyCardImage;
    private String enemyName;
    private int enemyCardValueInt;

    public DefendButtonOutputData(int playerCurrentHealth, int playerMaxHealth, int playerLevel, String enemyAction,
                                  boolean revivePotionUsed, int damageToPlayer, String enemyCardValue, char enemyCardSuit,
                                  String enemyCardImage, String enemyName, int enemyCardValueInt){

        this.playerCurrentHealth = playerCurrentHealth;
        this.playerMaxHealth = playerMaxHealth;
        this.playerLevel = playerLevel;
        this.enemyAction = enemyAction;
        this.revivePotionUsed = revivePotionUsed;
        this.damageToPlayer = damageToPlayer;
        this.enemyCardValue = enemyCardValue;
        this.enemyCardSuit = enemyCardSuit;
        this.enemyCardImage = enemyCardImage;
        this.enemyName = enemyName;
        this.enemyCardValueInt = enemyCardValueInt;
    }

    public int getPlayerCurrentHealth() {
        return playerCurrentHealth;
    }
    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public String getEnemyAction() {
        return enemyAction;
    }

    public boolean isRevivePotionUsed() {
        return revivePotionUsed;
    }

    public int getDamageToPlayer() {
        return damageToPlayer;
    }

    public String getEnemyCardValue() {
        return enemyCardValue;
    }

    public char getEnemyCardSuit() {
        return enemyCardSuit;
    }

    public String getEnemyCardImage() {
        return enemyCardImage;
    }
    public String getEnemyName() {
        return enemyName;
    }

    public int getEnemyCardValueInt() {
        return enemyCardValueInt;
    }
}
