package interface_adapter.explore;

import entity.BagAndItems.Item;
import interface_adapter.PickUpItem.PickUpItemState;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.stairs.StairsViewModel;
import interface_adapter.turn_select.TurnSelectState;
import interface_adapter.turn_select.TurnSelectViewModel;
import use_case.SearchButton.SearchButtonOutputBoundary;
import use_case.movement.EnemyOutputData;
import use_case.movement.MovementOutputData;

import javax.swing.*;

public class SearchButtonPresenter implements SearchButtonOutputBoundary {
    private final ExploreViewModel exploreViewModel;
    private final TurnSelectViewModel turnSelectViewModel;
    private final PickUpItemViewModel pickUpItemViewModel;
    private ViewManagerModel viewManagerModel;

    public SearchButtonPresenter(ExploreViewModel exploreViewModel, TurnSelectViewModel turnSelectViewModel,
                                 PickUpItemViewModel pickUpItemViewModel,
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
        //TODO directly Copy and paste from explorePresenter, not sure if there's anything need to be fixed

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

        JOptionPane.showMessageDialog(null, "You found a" + item.getName()+" !");
        pickUpItemViewModel.setState(pickUpItemState);
        pickUpItemViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(pickUpItemViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
