package interface_adapter.BattleResult;

public class BattleResultState {
    private String battleResult = "";
    private String battleResultError = null;
    public BattleResultState(BattleResultState copy){
        battleResult = copy.battleResult;
        battleResultError = copy.battleResultError;
    }
    public BattleResultState(){}

}
