package interface_adapter.DropItems;

import interface_adapter.UseItems.UseItemState;
import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.ViewManagerModel;
import use_case.DropItem.DropItemOutputBoundary;

import javax.swing.*;

public class DropItemsPresenter implements DropItemOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final DropItemsViewModel dropItemsViewModel;

    public DropItemsPresenter(ViewManagerModel viewManagerModel, DropItemsViewModel dropItemsViewModel){
        this.viewManagerModel = viewManagerModel;
        this.dropItemsViewModel = dropItemsViewModel;

    }
    @Override
    public void prepareSuccessView() {
        JOptionPane.showMessageDialog(null, "successfully droped the item");
        //back to package view(maybe).
        DropItemState dropItemState = dropItemsViewModel.getState();
        dropItemState.setBag(dropItemState.getBag());
        dropItemsViewModel.setState(dropItemState);
        dropItemsViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(dropItemsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(){
        JOptionPane.showMessageDialog(null, "no item to drop");
    }
}
