package interface_adapter.AttackSelect;

import entity.ActivePlayer;
import use_case.AttackButton.BackButton.BackButtonInputBoundary;
import use_case.AttackButton.BackButton.BackButtonInputData;

public class BackButtonController {

    final BackButtonInputBoundary backButtonInteractor;

    public BackButtonController(BackButtonInputBoundary backButtonInteractor) {
        this.backButtonInteractor = backButtonInteractor;
    }

    public void execute(ActivePlayer player) {
        BackButtonInputData backButtonInputData = new BackButtonInputData(player);
        backButtonInteractor.execute(backButtonInputData);
    }
}
