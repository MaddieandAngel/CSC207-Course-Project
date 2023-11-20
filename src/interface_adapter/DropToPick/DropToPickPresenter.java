package interface_adapter.DropToPick;

import entity.Player;
import interface_adapter.DropItems.DropItemState;
import interface_adapter.DropItems.DropItemsViewModel;
import interface_adapter.DropToPickPackage.DropToPickPackageState;
import interface_adapter.DropToPickPackage.DropToPickPackageViewModel;
import interface_adapter.PickUpItem.PickUpItemState;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.ViewManagerModel;
import use_case.DropToPick.DropToPickOutputBoundary;

public class DropToPickPresenter implements DropToPickOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final DropToPickPackageViewModel dropToPickPackageViewModel;
    private final PickUpItemViewModel pickUpItemViewModel;

    public DropToPickPresenter(ViewManagerModel viewManagerModel, DropToPickPackageViewModel dropToPickPackageViewModel, PickUpItemViewModel pickUpItemViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.dropToPickPackageViewModel = dropToPickPackageViewModel;
        this.pickUpItemViewModel = pickUpItemViewModel;
    }

    @Override
    public void prepareSuccessView(Player player) {
        PickUpItemState pickUpItemState = pickUpItemViewModel.getState();
        DropToPickPackageState dropToPickPackageState = dropToPickPackageViewModel.getState();
        dropToPickPackageState.setBag(pickUpItemState.getBag());
        dropToPickPackageViewModel.setState(dropToPickPackageState);
        dropToPickPackageViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(dropToPickPackageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
