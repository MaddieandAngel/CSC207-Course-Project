package interface_adapter.explore;

import entity.BagAndItems.Item;
import interface_adapter.PickUpItem.PickUpItemState;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.turn_select.TurnSelectState;
import interface_adapter.turn_select.TurnSelectViewModel;
import use_case.SearchButton.SearchButtonOutputBoundary;
import use_case.movement.EnemyOutputData;
import use_case.movement.MovementOutputData;

public class SearchButtonPresenter implements SearchButtonOutputBoundary {
    private final ExploreViewModel exploreViewModel;
    private final TurnSelectViewModel turnSelectViewModel;
    private final PickUpItemViewModel pickUpItemViewModel;
    private final ViewManagerModel viewManagerModel;

    public SearchButtonPresenter(ExploreViewModel exploreViewModel, TurnSelectViewModel turnSelectViewModel, PickUpItemViewModel pickUpItemViewModel,
                                 ViewManagerModel viewManagerModel) {
        this.exploreViewModel = exploreViewModel;
        this.turnSelectViewModel = turnSelectViewModel;
        this.pickUpItemViewModel = pickUpItemViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareEmptyRoomView(MovementOutputData movementOutputData) {
        ExploreState exploreState = exploreViewModel.getState();
        exploreViewModel.setState(ExploreButtonVisibility.setButtonVisibility(exploreState, movementOutputData));
        exploreViewModel.firePropertyChanged();
    }

    @Override
    public void prepareTurnSelectView(EnemyOutputData enemyOutputData) {
        TurnSelectState turnSelectState = turnSelectViewModel.getState();

        //Updates player output information, if it has changed:

        //Updates enemy output information:
        turnSelectState.setEnemyName(enemyOutputData.getEnemyName());
        turnSelectState.setEnemyLevel(enemyOutputData.getEnemyLevel());

        turnSelectViewModel.setState(turnSelectState);

        viewManagerModel.setActiveView(turnSelectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareItemCollectionView(Item item) {
        PickUpItemState pickUpItemState = pickUpItemViewModel.getState();
        pickUpItemState.setItem(item);
        pickUpItemViewModel.setState(pickUpItemState);
        viewManagerModel.setActiveView(pickUpItemViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
