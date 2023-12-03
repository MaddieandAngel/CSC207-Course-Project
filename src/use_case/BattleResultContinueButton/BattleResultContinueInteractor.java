package use_case.BattleResultContinueButton;


public class BattleResultContinueInteractor implements BattleResultContinueInputBoundary{
    final BattleResultContinueOutputBoundary battleResultContinueOutputBoundary;
    public BattleResultContinueInteractor(BattleResultContinueOutputBoundary battleResultContinueOutputBoundary){
        this.battleResultContinueOutputBoundary = battleResultContinueOutputBoundary;
    }
    @Override
    public void execute() {
        battleResultContinueOutputBoundary.prepareSuccessView();
    }
}
