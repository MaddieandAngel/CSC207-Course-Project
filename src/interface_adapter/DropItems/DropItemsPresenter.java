package interface_adapter.DropItems;

import interface_adapter.UseItems.UseItemState;
import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreViewModel;
import use_case.DropItem.DropItemOutputBoundary;

import javax.swing.*;

public class DropItemsPresenter implements DropItemOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final DropItemsViewModel dropItemsViewModel;
    private final ExploreViewModel exploreViewModel;

    public DropItemsPresenter(ViewManagerModel viewManagerModel, DropItemsViewModel dropItemsViewModel, ExploreViewModel exploreViewModel){
        this.viewManagerModel = viewManagerModel;
        this.dropItemsViewModel = dropItemsViewModel;
        this.exploreViewModel = exploreViewModel;

    }
    @Override
    public void prepareSuccessView() {
        JOptionPane.showMessageDialog(null, "successfully droped the item");

        viewManagerModel.setActiveView(dropItemsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(){
        JOptionPane.showMessageDialog(null, "no item to drop");
    }

    @Override
    public void prepareExploreView() {
        viewManagerModel.setActiveView(exploreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
