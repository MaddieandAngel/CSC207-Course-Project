package use_case.ItemsButton.HealButton;

public class HealButtonOutputData {

    private int playerCurrentHealth;

    private String enemyAction;

    private boolean reviveUsed;

    private int damageToPlayer;

    private String enemyCardValue;

    private char enemyCardSuit;

    private String enemyCardImage;

    private String enemyName;

    public HealButtonOutputData(int playerCurrentHealth, String enemyAction, boolean reviveUsed, int damageToPlayer,
                                String enemyCardValue, char enemyCardSuit, String enemyCardImage, String enemyName) {
        this.playerCurrentHealth = playerCurrentHealth;
        this.enemyAction = enemyAction;
        this.reviveUsed = reviveUsed;
        this.damageToPlayer = damageToPlayer;
        this.enemyCardValue = enemyCardValue;
        this.enemyCardSuit = enemyCardSuit;
        this.enemyCardImage = enemyCardImage;
        this.enemyName = enemyName;
    }

    public int getPlayerCurrentHealth() { return this.playerCurrentHealth;}

    public String getEnemyAction() { return this.enemyAction;}

    public boolean getReviveUsed() { return this.reviveUsed;}

    public int getDamageToPlayer() { return this.damageToPlayer;}

    public String enemyCardValue() { return this.enemyCardValue;}

    public char getEnemyCardSuit() { return this.enemyCardSuit;}

    public String getEnemyCardImage() { return this.enemyCardImage;}

    public String getEnemyName() { return this.enemyName;}
}
