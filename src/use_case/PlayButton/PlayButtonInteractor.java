package use_case.PlayButton;

import interface_adapter.APIAccessInterface;
import interface_adapter.stairs.StairsDataAccessInterface;
import use_case.movement.MovementOutputData;

import java.io.IOException;

public class PlayButtonInteractor implements PlayButtonInputBoundary{
    final PlayButtonOutputBoundary playPresenter;
    final StairsDataAccessInterface exploreDataAccessObject;
    final APIAccessInterface apiAccess;

    public PlayButtonInteractor(PlayButtonOutputBoundary playPresenter, StairsDataAccessInterface exploreDataAccessObject,
                                APIAccessInterface apiAccess){
        this.playPresenter = playPresenter;
        this.exploreDataAccessObject = exploreDataAccessObject;
        this.apiAccess = apiAccess;
    }

    @Override
    public void execute() {
        //Player has already been created in inBattleDataAccessObject's constructor

        //Generates floor. For simplicity, this first floor's size is always 4x4
        String directions = exploreDataAccessObject.MoveToNextFloor(4,4);

        //Draw player hand
        for (int i =0; i <5; i++){
            try {
                apiAccess.DrawCard("player");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        playPresenter.prepareSuccessView(new MovementOutputData(directions, true));
    }
}
