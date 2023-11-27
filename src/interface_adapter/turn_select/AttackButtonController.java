package interface_adapter.turn_select;

import entity.Player;
import use_case.AttackButton.AttackButtonInputBoundary;
import use_case.AttackButton.AttackButtonInputData;

public class AttackButtonController {

    final AttackButtonInputBoundary attackButtonInteractor;

    public AttackButtonController(AttackButtonInputBoundary attackButtonInteractor) {
        this.attackButtonInteractor = attackButtonInteractor;
    }

    public void execute(Player player) {
        AttackButtonInputData attackButtonInputData = new AttackButtonInputData(player);
        attackButtonInteractor.execute(attackButtonInputData);
    }

}
