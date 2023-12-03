package interface_adapter.DropToPick;

import entity.ActivePlayer;
import interface_adapter.DropToPickPackage.DropToPickPackageViewModel;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.UseItems.UseItemState;
import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.ViewManagerModel;
import use_case.DropToPick.DropToPickOutputBoundary;

public class DropToPickPresenter implements DropToPickOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final DropToPickPackageViewModel dropToPickPackageViewModel;
    private final PickUpItemViewModel pickUpItemViewModel;
    private final UseItemsViewModel useItemsViewModel;

    public DropToPickPresenter(ViewManagerModel viewManagerModel, DropToPickPackageViewModel dropToPickPackageViewModel, PickUpItemViewModel pickUpItemViewModel, UseItemsViewModel useItemsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.dropToPickPackageViewModel = dropToPickPackageViewModel;
        this.pickUpItemViewModel = pickUpItemViewModel;
        this.useItemsViewModel = useItemsViewModel;
    }

    @Override
    public void prepareSuccessView(ActivePlayer player) {
        UseItemState useItemState = useItemsViewModel.getState();
        useItemState.setBag(player.getBag());
        useItemsViewModel.setState(useItemState);
        useItemsViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(dropToPickPackageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
