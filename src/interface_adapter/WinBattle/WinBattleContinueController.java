package interface_adapter.WinBattle;

import use_case.WinBattleContinueButton.WinBattleContinueInputBoundary;

public class WinBattleContinueController {
    final WinBattleContinueInputBoundary winBattleContinueInputBoundary;

    public WinBattleContinueController( WinBattleContinueInputBoundary winBattleContinueInputBoundary) {
        this.winBattleContinueInputBoundary = winBattleContinueInputBoundary;
    }
    public void execute(){
        winBattleContinueInputBoundary.execute();
    };
}
