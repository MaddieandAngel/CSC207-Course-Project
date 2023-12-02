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

    public DefendButtonOutputData(int playerCurrentHealth, int playerMaxHealth, int playerLevel, String enemyAction, boolean revivePotionUsed, int damageToPlayer, String enemyCardValue, char enemyCardSuit, String enemyCardImage, String enemyName){

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
    }

    public int getPlayerCurrentHealth() {
        return playerCurrentHealth;
    }

    public void setPlayerCurrentHealth(int playerCurrentHealth) {
        this.playerCurrentHealth = playerCurrentHealth;
    }

    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }

    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public String getEnemyAction() {
        return enemyAction;
    }

    public void setEnemyAction(String enemyAction) {
        this.enemyAction = enemyAction;
    }

    public boolean isRevivePotionUsed() {
        return revivePotionUsed;
    }

    public void setRevivePotionUsed(boolean revivePotionUsed) {
        this.revivePotionUsed = revivePotionUsed;
    }

    public int getDamageToPlayer() {
        return damageToPlayer;
    }

    public void setDamageToPlayer(int damageToPlayer) {
        this.damageToPlayer = damageToPlayer;
    }

    public String getEnemyCardValue() {
        return enemyCardValue;
    }

    public void setEnemyCardValue(String enemyCardValue) {
        this.enemyCardValue = enemyCardValue;
    }

    public char getEnemyCardSuit() {
        return enemyCardSuit;
    }

    public void setEnemyCardSuit(char enemyCardSuit) {
        this.enemyCardSuit = enemyCardSuit;
    }

    public String getEnemyCardImage() {
        return enemyCardImage;
    }

    public void setEnemyCardImage(String enemyCardImage) {
        this.enemyCardImage = enemyCardImage;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }
}
