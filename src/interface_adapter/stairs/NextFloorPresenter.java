package interface_adapter.stairs;

import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreButtonVisibility;
import interface_adapter.explore.ExploreState;
import interface_adapter.explore.ExploreViewModel;
import use_case.movement.MovementOutputData;
import use_case.stairs.NextFloorOutputBoundary;

public class NextFloorPresenter implements NextFloorOutputBoundary {
    private final ExploreViewModel exploreViewModel;

    private ViewManagerModel viewManagerModel;

    public NextFloorPresenter(ViewManagerModel viewManagerModel, ExploreViewModel exploreViewModel){
        this.viewManagerModel = viewManagerModel;
        this.exploreViewModel = exploreViewModel;
    }

    public void prepareStartingRoomView(MovementOutputData movementOutputData){
        ExploreState exploreState = exploreViewModel.getState();

        exploreState.setFloorLevel(exploreState.getFloorLevel() + 1);

        exploreViewModel.setState(ExploreButtonVisibility.setButtonVisibility(exploreState, movementOutputData));

        exploreViewModel.setState(exploreState);
        exploreViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(exploreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
