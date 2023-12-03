package interface_adapter.turn_select;

import interface_adapter.ItemSelect.ItemSelectState;
import interface_adapter.ItemSelect.ItemSelectViewModel;
import interface_adapter.ViewManagerModel;
import use_case.ItemsButton.ItemsButtonOutputBoundary;
import use_case.ItemsButton.ItemsButtonOutputData;

public class ItemsButtonPresenter implements ItemsButtonOutputBoundary {

    private final ItemSelectViewModel itemSelectViewModel;

    private final ViewManagerModel viewManagerModel;

    public ItemsButtonPresenter(ItemSelectViewModel itemSelectViewModel, ViewManagerModel viewManagerModel) {
        this.itemSelectViewModel = itemSelectViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ItemsButtonOutputData itemsButtonOutputData) {

        ItemSelectState state = this.itemSelectViewModel.getState();
        state.setNumberOfHeal10(itemsButtonOutputData.getNumberOfHeal10());
        state.setNumberOfHeal20(itemsButtonOutputData.getNumberOfHeal20());
        state.setNumberOfHeal45(itemsButtonOutputData.getNumberOfHeal45());
        this.itemSelectViewModel.setState(state);
        itemSelectViewModel.firePropertyChanged();

        viewManagerModel.setActiveView("Item Select");
        viewManagerModel.firePropertyChanged();
    }
}
