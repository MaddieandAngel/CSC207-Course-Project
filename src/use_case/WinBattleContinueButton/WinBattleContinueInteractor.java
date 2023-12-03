package use_case.WinBattleContinueButton;

public class WinBattleContinueInteractor implements WinBattleContinueInputBoundary{
    final WinBattleContinueOutputBoundary winBattleContinueOutputBoundary;

    public WinBattleContinueInteractor(WinBattleContinueOutputBoundary winBattleContinueOutputBoundary) {
        this.winBattleContinueOutputBoundary = winBattleContinueOutputBoundary;
    }

    @Override
    public void execute() {
        winBattleContinueOutputBoundary.prepareSuccessView();
    }
}
