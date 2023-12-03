package use_case.DropToPick;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import entity.Player;

public class DropToPickInteractor implements DropToPickInputBoundary{
    final DropToPickOutputBoundary dropToPickPresenter;
    final InBattleDataAccessObject inBattleDataAccessObject;

    public DropToPickInteractor(DropToPickOutputBoundary dropToPickPresenter, InBattleDataAccessObject inBattleDataAccessObject) {
        this.dropToPickPresenter = dropToPickPresenter;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
    }
    @Override
    public void execute(){
        dropToPickPresenter.prepareSuccessView(inBattleDataAccessObject.getPlayer());
    }
}
