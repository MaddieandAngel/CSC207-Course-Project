package interface_adapter.WinBattle;

public class WinBattleState {
    private int expGained = 0;
    private boolean didPlayerLevelUp = false;
    private int totalExp = 0;
    private int playerLevel = 1;

    public WinBattleState(){}


    public int getExpGained() {
        return expGained;
    }

    public void setExpGained(int expGained) {
        this.expGained = expGained;
    }

    public boolean isDidPlayerLevelUp() {
        return didPlayerLevelUp;
    }

    public void setDidPlayerLevelUp(boolean didPlayerLevelUp) {
        this.didPlayerLevelUp = didPlayerLevelUp;
    }

    public int getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(int totalExp) {
        this.totalExp = totalExp;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }
}
