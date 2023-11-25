package use_case.AttackButton;

import entity.ActivePlayer;

public class AttackButtonInputData {

    private ActivePlayer player;

    public AttackButtonInputData(ActivePlayer player) {
        this.player = player;
    }

    public ActivePlayer getActivePlayer() {return this.player;}

}
