package use_case.PlayButton;

import interface_adapter.TitleScreen.CreateDeckDataAccessInterface;
import interface_adapter.stairs.StairsDataAccessInterface;
import use_case.movement.MovementOutputData;

import java.io.IOException;

public class PlayButtonInteractor implements PlayButtonInputBoundary{
    final PlayButtonOutputBoundary playPresenter;
    final CreateDeckDataAccessInterface apiAccess;
    final StairsDataAccessInterface exploreDataAccessObject;

    public PlayButtonInteractor(PlayButtonOutputBoundary playPresenter, CreateDeckDataAccessInterface apiAccess,
                                StairsDataAccessInterface exploreDataAccessObject){
        this.playPresenter = playPresenter;
        this.apiAccess = apiAccess;
        this.exploreDataAccessObject = exploreDataAccessObject;
    }

    @Override
    public void execute() {
        //Player has already been created in inBattleDataAccessObject's constructor

        //Generates floor. For simplicity, this first floor's size is always 4x4
        String directions = exploreDataAccessObject.MoveToNextFloor(4,4);

        playPresenter.prepareSuccessView(new MovementOutputData(directions));
    }
}
