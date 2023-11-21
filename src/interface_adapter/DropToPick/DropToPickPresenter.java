package interface_adapter.DropToPick;

import interface_adapter.DropToPickPackage.DropToPickPackageViewModel;
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
        viewManagerModel.setActiveView(dropToPickPackageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
