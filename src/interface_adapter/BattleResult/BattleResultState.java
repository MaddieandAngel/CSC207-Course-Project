package interface_adapter.BattleResult;

public class BattleResultState {
    //TODO: I was unsure what to put here. Open to modification.
    private boolean continueBattle = true;
    private int currentPlayerHealth = 15;
    private int playerMaxHealth = 15;
    private int playerLevel = 1; // Change if necessary
    private String enemyAction = null; //Change when enemyAction class is made
    private String winner = null;

    //I don't think we need the constructor, will delete later
    public BattleResultState(BattleResultState copy, int currentPlayerHealth, int playerMaxHealth){
        this.currentPlayerHealth = copy.currentPlayerHealth;
        this.playerMaxHealth = copy.playerMaxHealth;
    }
    public BattleResultState(){}

    public int getCurrentPlayerHealth() {
        return currentPlayerHealth;
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

    public boolean getContinueBattle() {
        return continueBattle;
    }

    public String getWinner() {
        return winner;
    }

    public void setCurrentPlayerHealth(int currentPlayerHealth) {
        this.currentPlayerHealth = currentPlayerHealth;
    }

    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public void setEnemyAction(String enemyAction) {
        this.enemyAction = enemyAction;
    }

    public void setContinueBattle(boolean continueBattle) {
        this.continueBattle = continueBattle;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
