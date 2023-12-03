package interface_adapter.BattleResult;

import use_case.BattleResultContinueButton.BattleResultContinueInputBoundary;
import use_case.BattleResultContinueButton.BattleResultContinueOutputBoundary;

public class ContinueButtonController {
    final BattleResultContinueInputBoundary battleResultContinueInputBoundary;
    public ContinueButtonController(BattleResultContinueInputBoundary battleResultContinueInputBoundary){
        this.battleResultContinueInputBoundary = battleResultContinueInputBoundary;
    }
    public void execute(){
        battleResultContinueInputBoundary.execute();
    }
}
