package use_case.AttackButton;

import entity.Player;
import interface_adapter.APIAccessInterface;

public interface AttackButtonDataAccessInterface {

    Player getPlayer();

    APIAccessInterface getAPI();
}
