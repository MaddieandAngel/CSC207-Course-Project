package interface_adapter.explore;

import interface_adapter.ViewManagerModel;
import interface_adapter.turn_select.TurnSelectViewModel;
import interface_adapter.stairs.StairsViewModel;
import use_case.movement.MovementOutputBoundary;
import use_case.movement.MovementOutputData;

public class ExplorePresenter implements MovementOutputBoundary {

    private final ExploreViewModel exploreViewModel;
    private final TurnSelectViewModel turnSelectViewModel;
    private final StairsViewModel stairsViewModel;
    private final ItemCollectViewModel itemCollectViewModel;

    private ViewManagerModel viewManagerModel;

    public ExplorePresenter(ViewManagerModel viewManagerModel, ExploreViewModel exploreViewModel,
                            TurnSelectViewModel turnSelectViewModel, StairsViewModel stairsViewModel,
                            ItemCollectViewModel itemCollectViewModel){
        this.viewManagerModel = viewManagerModel;
        this.exploreViewModel = exploreViewModel;
        this.turnSelectViewModel = turnSelectViewModel;
        this.stairsViewModel = stairsViewModel;
        this.itemCollectViewModel = itemCollectViewModel;
    }

    @Override
    public void prepareEmptyRoomView(MovementOutputData movementOutputData) {
        setButtonVisibility(movementOutputData);
        //No need to change active view
    }

    @Override
    public void prepareStairsView(MovementOutputData movementOutputData) {
        viewManagerModel.setActiveView(stairsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareTurnSelectView(MovementOutputData movementOutputData) {
        //TODO: More here probably

        viewManagerModel.setActiveView(turnSelectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareItemCollectionView(MovementOutputData movementOutputData) {
        //TODO: Everything related to moving to the item collection view
    }

    private void setButtonVisibility(MovementOutputData movementOutputData){
        //Move this to another file? Multiple presenters need this and IntelliJ is screaming at me
        ExploreState exploreState = exploreViewModel.getState();

        exploreState.setNorthVisible(movementOutputData.getDirections().contains("N"));
        exploreState.setEastVisible(movementOutputData.getDirections().contains("E"));
        exploreState.setSouthVisible(movementOutputData.getDirections().contains("S"));
        exploreState.setWestVisible(movementOutputData.getDirections().contains("W"));

        exploreViewModel.setState(exploreState);
        exploreViewModel.firePropertyChanged();
    }
}
