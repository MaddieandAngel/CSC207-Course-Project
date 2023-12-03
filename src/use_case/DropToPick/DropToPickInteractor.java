package use_case.DropToPick;

import entity.ActivePlayer;
import entity.Player;

public class DropToPickInteractor implements DropToPickInputBoundary{
    final DropToPickOutputBoundary dropToPickPresenter;

    public DropToPickInteractor(DropToPickOutputBoundary dropToPickPresenter) {
        this.dropToPickPresenter = dropToPickPresenter;
    }
    @Override
    public void execute(Player player){
        dropToPickPresenter.prepareSuccessView(player);
    }
}
