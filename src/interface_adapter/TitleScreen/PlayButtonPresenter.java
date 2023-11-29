package interface_adapter.TitleScreen;

import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreButtonVisibility;
import interface_adapter.explore.ExploreState;
import interface_adapter.explore.ExploreViewModel;
import use_case.PlayButton.PlayButtonOutputBoundary;
import use_case.movement.MovementOutputData;

public class PlayButtonPresenter implements PlayButtonOutputBoundary {
    private final TitleScreenViewModel titleScreenViewModel;
    private final ExploreViewModel exploreViewModel;
    private ViewManagerModel viewManagerModel;

    public PlayButtonPresenter(ViewManagerModel viewManagerModel, TitleScreenViewModel playButtonViewModel, ExploreViewModel exploreViewModel){
        this.viewManagerModel = viewManagerModel;
        this.titleScreenViewModel = playButtonViewModel;
        this.exploreViewModel = exploreViewModel;
    }

    @Override
    public void prepareSuccessView(MovementOutputData movementOutputData){
        ExploreState exploreState = exploreViewModel.getState();
        exploreViewModel.setState(ExploreButtonVisibility.setButtonVisibility(exploreState, movementOutputData));

        exploreViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(exploreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}
