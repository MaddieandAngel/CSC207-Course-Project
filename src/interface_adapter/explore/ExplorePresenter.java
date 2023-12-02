package interface_adapter.explore;

import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.turn_select.TurnSelectState;
import interface_adapter.turn_select.TurnSelectViewModel;
import interface_adapter.stairs.StairsViewModel;
import use_case.movement.EnemyOutputData;
import use_case.movement.MovementOutputBoundary;
import use_case.movement.MovementOutputData;

public class ExplorePresenter implements MovementOutputBoundary {

    private final ExploreViewModel exploreViewModel;
    private final TurnSelectViewModel turnSelectViewModel;
    private final StairsViewModel stairsViewModel;
    private final PickUpItemViewModel itemCollectViewModel;

    private ViewManagerModel viewManagerModel;

    public ExplorePresenter(ViewManagerModel viewManagerModel, ExploreViewModel exploreViewModel,
                            TurnSelectViewModel turnSelectViewModel, StairsViewModel stairsViewModel,
                            PickUpItemViewModel itemCollectViewModel){
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
    public void prepareStairsView() {
        stairsViewModel.setState(exploreViewModel.getState());
        stairsViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(stairsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareTurnSelectView(EnemyOutputData enemyOutputData) {
        TurnSelectState turnSelectState = turnSelectViewModel.getState();

        //Updates player output information, if it has changed:
        //TODO

        //Updates enemy output information:
        turnSelectState.setEnemyName(enemyOutputData.getEnemyName());
        turnSelectState.setEnemyLevel(enemyOutputData.getEnemyLevel());

        turnSelectViewModel.setState(turnSelectState);

        viewManagerModel.setActiveView(turnSelectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareItemCollectionView(MovementOutputData movementOutputData) {
        //TODO: Everything related to moving to the item collection view
    }

}
