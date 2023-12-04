package use_case.PlayButton;

import interface_adapter.stairs.StairsDataAccessInterface;
import use_case.movement.MovementOutputData;

public class PlayButtonInteractor implements PlayButtonInputBoundary{
    final PlayButtonOutputBoundary playPresenter;
    final StairsDataAccessInterface exploreDataAccessObject;

    public PlayButtonInteractor(PlayButtonOutputBoundary playPresenter, StairsDataAccessInterface exploreDataAccessObject){
        this.playPresenter = playPresenter;
        this.exploreDataAccessObject = exploreDataAccessObject;
    }

    @Override
    public void execute() {
        //Player has already been created in inBattleDataAccessObject's constructor

        //Generates floor. For simplicity, this first floor's size is always 4x4
        String directions = exploreDataAccessObject.MoveToNextFloor(4,4);

        playPresenter.prepareSuccessView(new MovementOutputData(directions, true));
    }
}
