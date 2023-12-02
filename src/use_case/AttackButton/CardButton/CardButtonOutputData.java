package use_case.AttackButton.CardButton;

public class CardButtonOutputData {

    private int updatedPlayerHealth;

    private boolean revivePotionUsed;

    private int damageToEnemy;

    private int damageToPlayer;

    private String enemyAction;

    private int playerMaxHealth;

    private int playerLevel;

    private String playerCardValue;

    private char playerCardSuit;

    private String playerCardImage;

    private String enemyCardValue;

    private char enemyCardSuit;

    private String enemyCardImage;

    private String damageBonus;

    private String enemyName;

    public CardButtonOutputData(int updatedPlayerHealth, boolean revivePotionUsed, int damageToEnemy,
                                int damageToPlayer, String enemyAction, int playerMaxHealth, int playerLevel, String playerCardValue,
                                char playerCardSuit, String playerCardImage, String enemyCardValue, char enemyCardSuit,
                                String enemyCardImage, String damageBonus, String enemyName) {
        this.updatedPlayerHealth = updatedPlayerHealth;
        this.revivePotionUsed = revivePotionUsed;
        this.damageToEnemy = damageToEnemy;
        this.damageToPlayer = damageToPlayer;
        this.enemyAction = enemyAction;
        this.playerMaxHealth = playerMaxHealth;
        this.playerLevel = playerLevel;
        this.playerCardValue = playerCardValue;
        this.playerCardSuit = playerCardSuit;
        this.playerCardImage = playerCardImage;
        this.enemyCardValue = enemyCardValue;
        this.enemyCardSuit = enemyCardSuit;
        this.enemyCardImage = enemyCardImage;
        this.damageBonus = damageBonus;
        this.enemyName = enemyName;
    }

    public int getPlayerCurrentHealth() { return this.updatedPlayerHealth;}

    public int getPlayerMaxHealth() { return this.playerMaxHealth;}

    public int getPlayerLevel() { return this.playerLevel;}

    public String getEnemyAction() {return this.enemyAction;}

    public boolean getRevivePotionUsed() { return this.revivePotionUsed;}

    public int getDamageToPlayer() { return this.damageToPlayer;}

    public int getDamageToEnemy() { return this.damageToEnemy;}

    public String getPlayerCardValue() { return this.playerCardValue;}

    public char getPlayerCardSuit() { return this.playerCardSuit;}

    public String getPlayerCardImage() { return this.playerCardImage;}

    public String getEnemyCardValue() { return this.enemyCardValue;}

    public char getEnemyCardSuit() { return this.enemyCardSuit;}

    public String getEnemyCardImage() { return this.enemyCardImage;}

    public String getDamageBonus() { return this.damageBonus;}

    public String getEnemyName() { return this.enemyName;}
}
