package use_case.PlayButton;

import interface_adapter.TitleScreen.CreateDeckDataAccessInterface;
import interface_adapter.TitleScreen.SaveDeckDataAccessInterface;
import interface_adapter.stairs.StairsDataAccessInterface;
import use_case.movement.MovementOutputData;

import java.io.IOException;

public class PlayButtonInteractor implements PlayButtonInputBoundary{
    final PlayButtonOutputBoundary playPresenter;
    final SaveDeckDataAccessInterface inBattleDataAccessObject;
    final CreateDeckDataAccessInterface apiAccess;
    final StairsDataAccessInterface exploreDataAccessObject;

    public PlayButtonInteractor(PlayButtonOutputBoundary playPresenter, SaveDeckDataAccessInterface inBattleDataAccessObject,
                                CreateDeckDataAccessInterface apiAccess, StairsDataAccessInterface exploreDataAccessObject){
        this.playPresenter = playPresenter;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
        this.apiAccess = apiAccess;
        this.exploreDataAccessObject = exploreDataAccessObject;
    }

    @Override
    public void execute() {
        //Creates Deck
        try {
            inBattleDataAccessObject.setDeck(apiAccess.NewDeck());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Player has already been created in inBattleDataAccessObject's constructor

        //Generates floor. For simplicity, this first floor's size is always 4x4
        String directions = exploreDataAccessObject.MoveToNextFloor(4,4);

        playPresenter.prepareSuccessView(new MovementOutputData(directions));
    }
}
