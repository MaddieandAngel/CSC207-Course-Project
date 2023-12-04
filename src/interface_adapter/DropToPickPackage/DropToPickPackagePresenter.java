package interface_adapter.DropToPickPackage;

import entity.ActivePlayer;
import entity.Player;
import interface_adapter.DropToPick.DropToPickViewModel;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.UseItems.UseItemState;
import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.ViewManagerModel;
import use_case.DropToPickPackage.DropToPickPackageOutputBoundary;
import use_case.DropToPickPackage.DropToPickPackageOutputData;

import javax.swing.*;

public class DropToPickPackagePresenter implements DropToPickPackageOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final DropToPickPackageViewModel dropToPickPackageViewModel;
    private final DropToPickViewModel dropToPickViewModel;
    private final PickUpItemViewModel pickUpItemViewModel;
    private final UseItemsViewModel useItemsViewModel;

    public DropToPickPackagePresenter(ViewManagerModel viewManagerModel, DropToPickPackageViewModel dropToPickPackageViewModel, DropToPickViewModel dropToPickViewModel, PickUpItemViewModel pickUpItemViewModel, UseItemsViewModel useItemsViewModel){
        this.viewManagerModel = viewManagerModel;
        this.dropToPickPackageViewModel = dropToPickPackageViewModel;

        this.dropToPickViewModel = dropToPickViewModel;
        this.pickUpItemViewModel = pickUpItemViewModel;
        this.useItemsViewModel = useItemsViewModel;
    }
    @Override
    public void prepareSuccessView() {
        JOptionPane.showMessageDialog(null, "successfully droped the item");
        //back to package view(maybe).
        viewManagerModel.setActiveView(dropToPickPackageViewModel.getViewName());
        dropToPickViewModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(){
        JOptionPane.showMessageDialog(null, "no item to drop");
    }

    @Override
    public void preparePickItemView(DropToPickPackageOutputData dropToPickPackageOutputData) {
        UseItemState useItemState = useItemsViewModel.getState();
        useItemState.setBag(dropToPickPackageOutputData.getPlayer().getBag());
        useItemsViewModel.setState(useItemState);
        useItemsViewModel.firePropertyChanged();
        pickUpItemViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(pickUpItemViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
