package app;

import interface_adapter.APIAccessInterface;
import interface_adapter.TitleScreen.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreViewModel;
import interface_adapter.stairs.StairsDataAccessInterface;
import use_case.PlayButton.PlayButtonInputBoundary;
import use_case.PlayButton.PlayButtonInteractor;
import use_case.PlayButton.PlayButtonOutputBoundary;
import view.TitleScreenView;

public class TitleScreenUseCaseFactory {

    private TitleScreenUseCaseFactory(){}

    public static TitleScreenView create(ViewManagerModel viewManagerModel, TitleScreenViewModel titleScreenViewModel,
                                         ExploreViewModel exploreViewModel, StairsDataAccessInterface exploreDataAccessObject, APIAccessInterface
                                         apiAccess){

        PlayButtonController playButtonController = createPlayButtonUseCase(viewManagerModel, titleScreenViewModel,
                exploreViewModel, exploreDataAccessObject, apiAccess);

        return new TitleScreenView(titleScreenViewModel, playButtonController);
    }

    private static PlayButtonController createPlayButtonUseCase(ViewManagerModel viewManagerModel, TitleScreenViewModel titleScreenViewModel,
                                                                ExploreViewModel exploreViewModel, StairsDataAccessInterface exploreDataAccessObject,
                                                                APIAccessInterface apiAccess){

        PlayButtonOutputBoundary playButtonOutputBoundary = new PlayButtonPresenter(viewManagerModel, titleScreenViewModel, exploreViewModel);

        PlayButtonInputBoundary playButtonUseCaseInteractor = new PlayButtonInteractor(playButtonOutputBoundary, exploreDataAccessObject, apiAccess);

        return new PlayButtonController(playButtonUseCaseInteractor);
    }
}
