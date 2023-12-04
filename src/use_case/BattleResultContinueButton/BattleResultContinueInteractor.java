package use_case.BattleResultContinueButton;


import data_access.InBattleDataAccessObject;
import interface_adapter.APIAccessInterface;

import java.io.IOException;
import java.util.Arrays;

public class BattleResultContinueInteractor implements BattleResultContinueInputBoundary{
    final BattleResultContinueOutputBoundary battleResultContinueOutputBoundary;
    final InBattleDataAccessObject inBattleDataAccessObject;
    public BattleResultContinueInteractor(BattleResultContinueOutputBoundary battleResultContinueOutputBoundary, InBattleDataAccessObject inBattleDataAccessObject){
        this.battleResultContinueOutputBoundary = battleResultContinueOutputBoundary;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
    }
    @Override
    public void execute() throws IOException {
        if (inBattleDataAccessObject.getEnemy().getCurrentHealth() <= 0){
            //Award player with exp and level up when they have collected 100 exp
            int currentExp = inBattleDataAccessObject.getPlayer().getExperiencePoints();
            if ((currentExp + 20) >= 100){
                inBattleDataAccessObject.getPlayer().levelUp();
                inBattleDataAccessObject.getPlayer().setExperiencePoints((currentExp + 20) % 100);
            }
            else{
                inBattleDataAccessObject.getPlayer().setExperiencePoints(currentExp + 20);
            }
            battleResultContinueOutputBoundary.prepareWinBattleView();
        }
        else if (inBattleDataAccessObject.getPlayer().getCurrentHealth() <= 0){
            APIAccessInterface apiAccessInterface = inBattleDataAccessObject.getAPI();
            apiAccessInterface.MovePileToDeck("player");
            apiAccessInterface.MovePileToDeck("enemyHand");
            apiAccessInterface.MovePileToDeck("discard");
            battleResultContinueOutputBoundary.prepareGameOverView();

        }
        else {
            battleResultContinueOutputBoundary.prepareTurnSelectView();
        }
    }
}
