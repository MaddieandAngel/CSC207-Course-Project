package interface_adapter.stairs;

import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreButtonVisibility;
import interface_adapter.explore.ExploreState;
import interface_adapter.explore.ExploreViewModel;
import use_case.movement.MovementOutputData;
import use_case.stairs.StayOnFloorOutputBoundary;

public class StayOnFloorPresenter implements StayOnFloorOutputBoundary {

    private final ExploreViewModel exploreViewModel;
    private ViewManagerModel viewManagerModel;

    public StayOnFloorPresenter(ViewManagerModel viewManagerModel, ExploreViewModel exploreViewModel){
        this.viewManagerModel = viewManagerModel;
        this.exploreViewModel = exploreViewModel;
    }

    @Override
    public void prepareEmptyRoomView(MovementOutputData movementOutputData) {
        ExploreState exploreState = exploreViewModel.getState();

        exploreViewModel.setState(ExploreButtonVisibility.setButtonVisibility(exploreState, movementOutputData));

        exploreViewModel.setState(exploreState);
        exploreViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(exploreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
