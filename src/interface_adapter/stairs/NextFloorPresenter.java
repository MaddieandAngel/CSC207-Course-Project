package interface_adapter.stairs;

import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreState;
import interface_adapter.explore.ExploreViewModel;
import use_case.stairs.NextFloorOutputBoundary;
import use_case.stairs.NextFloorOutputData;

public class NextFloorPresenter implements NextFloorOutputBoundary {
    private final ExploreViewModel exploreViewModel;

    private ViewManagerModel viewManagerModel;

    public NextFloorPresenter(ViewManagerModel viewManagerModel, ExploreViewModel exploreViewModel){
        this.viewManagerModel = viewManagerModel;
        this.exploreViewModel = exploreViewModel;
    }

    public void prepareStartingRoomView(NextFloorOutputData nextFloorOutputData){
        ExploreState exploreState = exploreViewModel.getState();

        exploreState.setFloorLevel(exploreState.getFloorLevel() + 1);

        exploreState.setNorthVisible(nextFloorOutputData.getDirections().contains("N"));
        exploreState.setEastVisible(nextFloorOutputData.getDirections().contains("E"));
        exploreState.setSouthVisible(nextFloorOutputData.getDirections().contains("S"));
        exploreState.setWestVisible(nextFloorOutputData.getDirections().contains("W"));

        exploreViewModel.setState(exploreState);
        exploreViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(exploreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
