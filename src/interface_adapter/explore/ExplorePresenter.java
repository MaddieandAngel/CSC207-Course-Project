package interface_adapter.explore;

import interface_adapter.ViewManagerModel;
import interface_adapter.turn_select.TurnSelectState;
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
        ExploreState exploreState = exploreViewModel.getState();
        exploreViewModel.setState(ExploreButtonVisibility.setButtonVisibility(exploreState, movementOutputData));
        exploreViewModel.firePropertyChanged();
        //No need to change active view
    }

    @Override
    public void prepareStairsView(MovementOutputData movementOutputData) {
        viewManagerModel.setActiveView(stairsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareTurnSelectView(MovementOutputData movementOutputData) {
        //TODO: More here
        TurnSelectState turnSelectState = turnSelectViewModel.getState();

        //TODO: Update textbox text for TurnSelectView with the enemy's name and level (ie "Level [EnemyLevel] [EnemyName] appeared!")

        viewManagerModel.setActiveView(turnSelectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareItemCollectionView(MovementOutputData movementOutputData) {
        //TODO: Everything related to moving to the item collection view
    }

}
