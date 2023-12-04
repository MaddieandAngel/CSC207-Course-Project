package interface_adapter.PickUpItem;

import entity.BagAndItems.Bag;
import interface_adapter.DropToPick.DropToPickState;
import interface_adapter.DropToPickPackage.DropToPickPackageState;
import interface_adapter.DropToPickPackage.DropToPickPackageViewModel;
import interface_adapter.UseItems.UseItemState;
import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreButtonVisibility;
import interface_adapter.explore.ExploreState;
import interface_adapter.explore.ExploreViewModel;
import use_case.PickUpItem.PickUpItemOutputBoundary;
import use_case.PickUpItem.PickUpItemOutputData;
import use_case.movement.MovementOutputData;

import javax.swing.*;

public class PickUpItemPresenter implements PickUpItemOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final PickUpItemViewModel pickUpItemViewModel;
    private final ExploreViewModel exploreViewModel;
    private final UseItemsViewModel useItemsViewModel;
    private final DropToPickPackageViewModel dropToPickPackageViewModel;

    public PickUpItemPresenter(ViewManagerModel viewManagerModel, PickUpItemViewModel pickUpItemViewModel, ExploreViewModel exploreViewModel, UseItemsViewModel useItemsViewModel, DropToPickPackageViewModel dropToPickPackageViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.pickUpItemViewModel = pickUpItemViewModel;
        this.exploreViewModel = exploreViewModel;
        this.useItemsViewModel = useItemsViewModel;
        this.dropToPickPackageViewModel = dropToPickPackageViewModel;
    }

    @Override
    public void prepareSuccessView(PickUpItemOutputData pickUpItemOutputData, MovementOutputData movementOutputData) {
        JOptionPane.showMessageDialog(null, "Successfully picked the item");

        Bag bag = pickUpItemOutputData.getBag();

        DropToPickPackageState dropToPickPackageState = dropToPickPackageViewModel.getState();
        dropToPickPackageState.setBag(bag);
        dropToPickPackageViewModel.setState(dropToPickPackageState);
        dropToPickPackageViewModel.firePropertyChanged();

        UseItemState useItemState = useItemsViewModel.getState();
        useItemState.setBag(bag);
        useItemsViewModel.setState(useItemState);
        useItemsViewModel.firePropertyChanged();

        ExploreState exploreState = exploreViewModel.getState();
        exploreViewModel.setState(ExploreButtonVisibility.setButtonVisibility(exploreState, movementOutputData));
        exploreViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(exploreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView() {
        JOptionPane.showMessageDialog(null, "Bag is full, please drop an item before pick up a new one.");
        viewManagerModel.setActiveView(pickUpItemViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void back(MovementOutputData movementOutputData) {
        ExploreState exploreState = exploreViewModel.getState();
        exploreViewModel.setState(ExploreButtonVisibility.setButtonVisibility(exploreState, movementOutputData));
        exploreViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(exploreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
