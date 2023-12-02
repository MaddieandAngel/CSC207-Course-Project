package use_case.DrawButton;

public class DrawButtonOutputData {

    private int playerCurrentHealth;

    private int playerMaxHealth;

    private int playerLevel;

    private String enemyAction;

    private boolean revivePotionUsed;

    private int damageToPlayer;

    private String playerCardValue;

    private char playerCardSuit;

    private String playerCardImage;

    private String enemyCardValue;

    private char enemyCardSuit;

    private String enemyCardImage;

    private String enemyName;

    public DrawButtonOutputData(int playerCurrentHealth, int playerMaxHealth, int playerLevel, String enemyAction,
                                boolean revivePotionUsed, int damageToPlayer, String playerCardValue, char playerCardSuit,
                                String playerCardImage, String enemyCardValue, char enemyCardSuit, String enemyCardImage,
                                String enemyName) {
        this.playerCurrentHealth = playerCurrentHealth;
        this.playerMaxHealth = playerMaxHealth;
        this.playerLevel = playerLevel;
        this.enemyAction = enemyAction;
        this.revivePotionUsed = revivePotionUsed;
        this.damageToPlayer = damageToPlayer;
        this.playerCardValue = playerCardValue;
        this.playerCardSuit = playerCardSuit;
        this.playerCardImage = playerCardImage;
        this.enemyCardValue = enemyCardValue;
        this.enemyCardSuit = enemyCardSuit;
        this.enemyCardImage = enemyCardImage;
        this.enemyName = enemyName;
    }

    public int getPlayerCurrentHealth() { return this.playerCurrentHealth;}

    public int getPlayerMaxHealth() { return this.playerMaxHealth;}

    public int getPlayerLevel() { return this.playerLevel;}

    public String getEnemyAction() { return this.enemyAction;}

    public boolean revivePotionUsed() { return this.revivePotionUsed;}

    public int getDamageToPlayer() { return this.damageToPlayer;}

    public String getPlayerCardValue() { return this.playerCardValue;}

    public char getPlayerCardSuit() { return this.playerCardSuit;}

    public String getPlayerCardImage() { return this.playerCardImage;}

    public String enemyCardValue() { return this.enemyCardValue;}

    public char getEnemyCardSuit() { return this.enemyCardSuit;}

    public String getEnemyImage() { return this.enemyCardImage;}

    public String getEnemyName() { return this.enemyName;}
}
