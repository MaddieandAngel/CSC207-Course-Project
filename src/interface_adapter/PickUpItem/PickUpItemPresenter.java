package interface_adapter.PickUpItem;

import interface_adapter.DropItems.DropItemState;
import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreViewModel;
import use_case.PickUpItem.PickUpItemOutputBoundary;
import view.ExploreView;

import javax.swing.*;

public class PickUpItemPresenter implements PickUpItemOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final PickUpItemViewModel pickUpItemViewModel;
    private final ExploreViewModel exploreViewModel;

    public PickUpItemPresenter(ViewManagerModel viewManagerModel, PickUpItemViewModel pickUpItemViewModel, ExploreViewModel exploreViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.pickUpItemViewModel = pickUpItemViewModel;
        this.exploreViewModel = exploreViewModel;
    }

    @Override
    public void prepareSuccessView() {
        JOptionPane.showMessageDialog(null, "Successfully picked the item");
        viewManagerModel.setActiveView(exploreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView() {
        JOptionPane.showMessageDialog(null, "Bag is full, please drop an item before pick up a new one.");
        viewManagerModel.setActiveView(pickUpItemViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
