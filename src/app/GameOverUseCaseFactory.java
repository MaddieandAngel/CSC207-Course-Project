package app;

import interface_adapter.GameOver.GameOverViewModel;
import interface_adapter.GameOver.ReturnToTitleController;
import interface_adapter.GameOver.ReturnToTitlePresenter;
import interface_adapter.TitleScreen.PlayButtonController;
import interface_adapter.TitleScreen.PlayButtonPresenter;
import interface_adapter.TitleScreen.TitleScreenViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreViewModel;
import interface_adapter.stairs.StairsDataAccessInterface;
import use_case.PlayButton.PlayButtonInputBoundary;
import use_case.PlayButton.PlayButtonInteractor;
import use_case.PlayButton.PlayButtonOutputBoundary;
import use_case.ReturnToTitleButton.ReturnToTitleInputBoundary;
import use_case.ReturnToTitleButton.ReturnToTitleInteractor;
import use_case.ReturnToTitleButton.ReturnToTitleOutputBoundary;
import view.in_battle.GameOverView;

public class GameOverUseCaseFactory {
    private GameOverUseCaseFactory(){}

    public static GameOverView create(ViewManagerModel viewManagerModel, GameOverViewModel gameOverViewModel,
                                      TitleScreenViewModel titleScreenViewModel, ExploreViewModel exploreViewModel, StairsDataAccessInterface dataAccessObject){
        ReturnToTitleController returnToTitleController = createReturnToTitleUseCase(viewManagerModel, gameOverViewModel, titleScreenViewModel);
        PlayButtonController playButtonController = createPlayAgainUseCase(viewManagerModel, titleScreenViewModel, exploreViewModel, dataAccessObject);
        return new GameOverView(gameOverViewModel, playButtonController, returnToTitleController);
    }
    private static ReturnToTitleController createReturnToTitleUseCase(ViewManagerModel viewManagerModel, GameOverViewModel gameOverViewModel,
                                                                      TitleScreenViewModel titleScreenViewModel){
        ReturnToTitleOutputBoundary returnToTitleOutputBoundary = new ReturnToTitlePresenter(titleScreenViewModel, viewManagerModel);
        ReturnToTitleInputBoundary returnToTitleInputBoundary = new ReturnToTitleInteractor(returnToTitleOutputBoundary);
        return new ReturnToTitleController(returnToTitleInputBoundary);
    }
    private static PlayButtonController createPlayAgainUseCase(ViewManagerModel viewManagerModel, TitleScreenViewModel
            titleScreenViewModel, ExploreViewModel exploreViewModel, StairsDataAccessInterface dataAccessObject){
        PlayButtonOutputBoundary playButtonOutputBoundary = new PlayButtonPresenter(viewManagerModel, titleScreenViewModel, exploreViewModel);
        PlayButtonInputBoundary playButtonInputBoundary = new PlayButtonInteractor(playButtonOutputBoundary, dataAccessObject);
        return new PlayButtonController(playButtonInputBoundary);
    }
}
