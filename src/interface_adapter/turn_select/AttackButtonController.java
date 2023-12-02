package interface_adapter.turn_select;

import use_case.AttackButton.AttackButtonInputBoundary;

public class AttackButtonController {

    final AttackButtonInputBoundary attackButtonInteractor;

    public AttackButtonController(AttackButtonInputBoundary attackButtonInteractor) {
        this.attackButtonInteractor = attackButtonInteractor;
    }

    public void execute() {
        attackButtonInteractor.execute();
    }

}
