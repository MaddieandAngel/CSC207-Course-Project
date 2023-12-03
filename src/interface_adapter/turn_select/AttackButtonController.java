package interface_adapter.turn_select;

import use_case.AttackButton.AttackButtonInputBoundary;

import java.io.IOException;

public class AttackButtonController {

    final AttackButtonInputBoundary attackButtonInteractor;

    public AttackButtonController(AttackButtonInputBoundary attackButtonInteractor) {
        this.attackButtonInteractor = attackButtonInteractor;
    }

    public void execute() throws IOException {
        attackButtonInteractor.execute();
    }

}
