package interface_adapter.AttackSelect;

import use_case.AttackButton.BackButton.BackButtonInputBoundary;

public class BackButtonController {

    final BackButtonInputBoundary backButtonInteractor;

    public BackButtonController(BackButtonInputBoundary backButtonInteractor) {
        this.backButtonInteractor = backButtonInteractor;
    }

    public void execute() {
        backButtonInteractor.execute();
    }
}
