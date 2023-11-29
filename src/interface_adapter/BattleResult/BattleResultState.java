package interface_adapter.BattleResult;

public class BattleResultState {
    //TODO: I was unsure what to put here. Open to modification.
    private boolean playerHasNoHealth = false;
    private boolean enemyHasNoHealth = false;
    public BattleResultState(BattleResultState copy, boolean playerHasNoHealth, boolean enemyHasNoHealth){
        this.playerHasNoHealth = playerHasNoHealth;
        this.enemyHasNoHealth = enemyHasNoHealth;
    }
    public BattleResultState(){}

    public boolean getPlayerHasNoHealth() {
        return playerHasNoHealth;
    }

    public boolean getEnemyHasNoHealth() {
        return enemyHasNoHealth;
    }

    public void setPlayerHasNoHealth(boolean playerHasNoHealth){
        this.playerHasNoHealth = playerHasNoHealth;
    }

    public void setEnemyHasNoHealth(boolean enemyHasNoHealth){
        this.enemyHasNoHealth = enemyHasNoHealth;
    }
}
