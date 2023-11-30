package interface_adapter.BattleResult;

public class BattleResultState {
    //TODO: I was unsure what to put here. Open to modification.
    private int playerCurrentHealth;

    private int playerMaxHealth;

    private int playerLevel;

    private String playerAction;

    private int enemyHealth;

    private String enemyAction;

    private boolean revivePotionUsed;

    private int damageToPlayer;

    private int damageToEnemy;

    public BattleResultState(){}

    public int getPlayerCurrentHealth() { return this.playerCurrentHealth;}

    public void setPlayerCurrentHealth(int updatedHealth) { this.playerCurrentHealth = updatedHealth;}

    public int getPlayerMaxHealth() { return this.playerMaxHealth;}

    public void setPlayerMaxHealth(int maxHealth) { this.playerMaxHealth = maxHealth;}

    public int getPlayerLevel() { return this.playerLevel;}

    public void setPlayerLevel(int level) { this.playerLevel = level;}

    public String getPlayerAction() {return this.playerAction;}

    public void setPlayerAction(String action) {this.playerAction = action;}

    public int getEnemyHealth() { return this.enemyHealth;}

    public void setEnemyHealth(int enemyHealth) { this.enemyHealth = enemyHealth;}

    public String getEnemyAction() { return this.enemyAction;}

    public void setEnemyAction(String enemyAction) { this.enemyAction = enemyAction;}

    public boolean getRevivePotionUsed() { return this.revivePotionUsed;}

    public void setRevivePotionUsed(boolean reviveUsed) { this.revivePotionUsed = reviveUsed;}

    public int getDamageToPlayer() { return this.damageToPlayer;}

    public void setDamageToPlayer(int damage) { this.damageToPlayer = damage;}

    public int getDamageToEnemy() { return this.damageToEnemy;}

    public void setDamageToEnemy(int damage) {this.damageToEnemy = damage;}

    public boolean playerDead() { return playerCurrentHealth == 0;}

    public boolean enemyDead() { return enemyHealth == 0;}


}