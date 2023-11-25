package interface_adapter.PickUpItem;

import interface_adapter.DropItems.DropItemState;
import interface_adapter.ViewManagerModel;
import use_case.PickUpItem.PickUpItemOutputBoundary;

import javax.swing.*;

public class PickUpItemPresenter implements PickUpItemOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final PickUpItemViewModel pickUpItemViewModel;

    public PickUpItemPresenter(ViewManagerModel viewManagerModel, PickUpItemViewModel pickUpItemViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.pickUpItemViewModel = pickUpItemViewModel;
    }

    @Override
    public void prepareSuccessView() {
        JOptionPane.showMessageDialog(null, "Successfully picked the item");
        // back to explore view

    }

    @Override
    public void prepareFailView() {
        JOptionPane.showMessageDialog(null, "Bag is full, please drop an item before pick up a new one.");
        viewManagerModel.setActiveView(pickUpItemViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
