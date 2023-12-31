package interface_adapter.BattleResult;

public class BattleResultState {

    private int playerCurrentHealth;

    private int playerMaxHealth;

    private int playerLevel;

    private String playerAction;

    private String enemyAction;

    private boolean revivePotionUsed;

    private int damageToPlayer;

    private int damageToEnemy;

    private String playerCardValue;

    private char playerCardSuit;

    private String playerCardImage;

    private String enemyCardValue;

    private char enemyCardSuit;

    private String enemyCardImage;

    private String damageBonus;

    private String enemyName;

    private int enemyCurrentHealth;

    public BattleResultState(){}

    public int getPlayerCurrentHealth() { return this.playerCurrentHealth;}

    public void setPlayerCurrentHealth(int updatedHealth) { this.playerCurrentHealth = updatedHealth;}

    public int getPlayerMaxHealth() { return this.playerMaxHealth;}

    public void setPlayerMaxHealth(int maxHealth) { this.playerMaxHealth = maxHealth;}

    public int getPlayerLevel() { return this.playerLevel;}

    public void setPlayerLevel(int level) { this.playerLevel = level;}

    public String getPlayerAction() {return this.playerAction;}

    public void setPlayerAction(String action) {this.playerAction = action;}

    public String getEnemyAction() { return this.enemyAction;}

    public void setEnemyAction(String enemyAction) { this.enemyAction = enemyAction;}

    public boolean getRevivePotionUsed() { return this.revivePotionUsed;}

    public void setRevivePotionUsed(boolean reviveUsed) { this.revivePotionUsed = reviveUsed;}

    public int getDamageToPlayer() { return this.damageToPlayer;}

    public void setDamageToPlayer(int damage) { this.damageToPlayer = damage;}

    public int getDamageToEnemy() { return this.damageToEnemy;}

    public void setDamageToEnemy(int damage) {this.damageToEnemy = damage;}

    public String getPlayerCardValue() { return this.playerCardValue;}

    public void setPlayerCardValue(String value) { this.playerCardValue = value;}

    public char getPlayerCardSuit() { return this.playerCardSuit;}

    public void setPlayerCardSuit(char suit) { this.playerCardSuit = suit;}

    public String getPlayerCardImage() { return this.playerCardImage;}

    public void setPlayerCardImage(String url) { this.playerCardImage = url;}

    public String getEnemyCardValue() { return this.enemyCardValue;}

    public void setEnemyCardValue(String value) { this.enemyCardValue = value;}

    public char getEnemyCardSuit() { return this.enemyCardSuit;}

    public void setEnemyCardSuit(char suit) { this.enemyCardSuit = suit;}

    public String getEnemyCardImage() { return this.enemyCardImage;}

    public void setEnemyCardImage(String url) { this.enemyCardImage = url;}

    public String getDamageBonus() { return this.damageBonus;}

    public void setDamageBonus(String character) { this.damageBonus = character;}

    public String getEnemyName() { return this.enemyName;}

    public void setEnemyName(String name) { this.enemyName = name;}

    public int getEnemyCurrentHealth(){return this.enemyCurrentHealth;}

    public void setEnemyCurrentHealth(int enemyCurrentHealth){this.enemyCurrentHealth = enemyCurrentHealth;}
}
