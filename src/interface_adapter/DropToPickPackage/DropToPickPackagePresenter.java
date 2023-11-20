package interface_adapter.DropToPickPackage;

import interface_adapter.DropToPick.DropToPickViewModel;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.ViewManagerModel;
import use_case.DropToPickPackage.DropToPickPackageOutputBoundary;

import javax.swing.*;

public class DropToPickPackagePresenter implements DropToPickPackageOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final DropToPickPackageViewModel dropToPickPackageViewModel;
    private final DropToPickViewModel dropToPickViewModel;
    private final PickUpItemViewModel pickUpItemViewModel;

    public DropToPickPackagePresenter(ViewManagerModel viewManagerModel, DropToPickPackageViewModel dropToPickPackageViewModel, DropToPickViewModel dropToPickViewModel, PickUpItemViewModel pickUpItemViewModel){
        this.viewManagerModel = viewManagerModel;
        this.dropToPickPackageViewModel = dropToPickPackageViewModel;

        this.dropToPickViewModel = dropToPickViewModel;
        this.pickUpItemViewModel = pickUpItemViewModel;
    }
    @Override
    public void prepareSuccessView() {
        JOptionPane.showMessageDialog(null, "successfully droped the item");
        //back to package view(maybe).
        DropToPickPackageState dropToPickPackageState = dropToPickPackageViewModel.getState();
        dropToPickPackageState.setBag(dropToPickPackageState.getBag());
        dropToPickPackageViewModel.setState(dropToPickPackageState);
        viewManagerModel.setActiveView(dropToPickPackageViewModel.getViewName());
        dropToPickViewModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(){
        JOptionPane.showMessageDialog(null, "no item to drop");
    }

    @Override
    public void preparePickItemView() {
        pickUpItemViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(pickUpItemViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
