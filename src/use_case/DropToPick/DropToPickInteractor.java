package use_case.DropToPick;

import entity.ActivePlayer;

public class DropToPickInteractor implements DropToPickInputBoundary{
    final DropToPickOutputBoundary dropToPickPresenter;

    public DropToPickInteractor(DropToPickOutputBoundary dropToPickPresenter) {
        this.dropToPickPresenter = dropToPickPresenter;
    }
    @Override
    public void execute(ActivePlayer player){
        dropToPickPresenter.prepareSuccessView(player);
    }
}
