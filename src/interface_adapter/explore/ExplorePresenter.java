package interface_adapter.explore;

import entity.BagAndItems.Item;
import interface_adapter.PickUpItem.PickUpItemState;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.stairs.StairsState;
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
        StairsState stairsState = stairsViewModel.getState();
        ExploreState exploreState = exploreViewModel.getState();

        stairsState.setPlayerLevel(exploreState.getPlayerLevel());
        stairsState.setFloorLevel(exploreState.getFloorLevel());
        stairsState.setPlayerCurrentHealth(exploreState.getPlayerCurrentHealth());
        stairsState.setPlayerMaxHealth(exploreState.getPlayerMaxHealth());

        stairsViewModel.setState(stairsState);
        stairsViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(stairsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareTurnSelectView(EnemyOutputData enemyOutputData) {
        TurnSelectState turnSelectState = turnSelectViewModel.getState();
        ExploreState exploreState = exploreViewModel.getState();

        //Updates player output information, if it has changed:
        turnSelectState.setPlayerLevel(exploreState.getPlayerLevel());
        turnSelectState.setPlayerHealth(exploreState.getPlayerCurrentHealth());
        turnSelectState.setPlayerMaxHealth(exploreState.getPlayerMaxHealth());

        //Updates enemy output information:
        turnSelectState.setEnemyName(enemyOutputData.getEnemyName());
        turnSelectState.setEnemyLevel(enemyOutputData.getEnemyLevel());

        turnSelectViewModel.setState(turnSelectState);

        viewManagerModel.setActiveView(turnSelectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareItemCollectionView(Item item) {
        //TODO: Everything related to moving to the item collection view
        PickUpItemState pickUpItemState = itemCollectViewModel.getState();
        pickUpItemState.setItem(item);
        itemCollectViewModel.setState(pickUpItemState);
        viewManagerModel.setActiveView(itemCollectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
