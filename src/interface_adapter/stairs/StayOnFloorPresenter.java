package interface_adapter.stairs;

import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreState;
import interface_adapter.explore.ExploreViewModel;
import use_case.stairs.StayOnFloorOutputBoundary;
import use_case.stairs.StayOnFloorOutputData;

public class StayOnFloorPresenter implements StayOnFloorOutputBoundary {

    private final ExploreViewModel exploreViewModel;
    private ViewManagerModel viewManagerModel;

    public StayOnFloorPresenter(ViewManagerModel viewManagerModel, ExploreViewModel exploreViewModel){
        this.viewManagerModel = viewManagerModel;
        this.exploreViewModel = exploreViewModel;
    }

    @Override
    public void prepareEmptyRoomView(StayOnFloorOutputData stayOnFloorOutputData) {
        ExploreState exploreState = exploreViewModel.getState();

        // TODO: change StayOnFloorOutputData to MovementOutputData so ExploreButtonVisibility can be called
        exploreState.setNorthVisible(stayOnFloorOutputData.getDirections().contains("N"));
        exploreState.setEastVisible(stayOnFloorOutputData.getDirections().contains("E"));
        exploreState.setSouthVisible(stayOnFloorOutputData.getDirections().contains("S"));
        exploreState.setWestVisible(stayOnFloorOutputData.getDirections().contains("W"));

        exploreViewModel.setState(exploreState);
        exploreViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(exploreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
