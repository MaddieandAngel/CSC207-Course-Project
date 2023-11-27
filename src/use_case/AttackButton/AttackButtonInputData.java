package use_case.AttackButton;

import entity.Player;

public class AttackButtonInputData {

    private Player player;

    public AttackButtonInputData(Player player) {
        this.player = player;
    }

    public Player getCurrentPlayer() {return this.player;}

}
