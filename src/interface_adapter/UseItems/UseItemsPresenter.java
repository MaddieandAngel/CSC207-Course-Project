package interface_adapter.UseItems;
import interface_adapter.ViewManagerModel;
import use_case.UseItem.UseItemOutputBoundary;

import javax.swing.*;

public class UseItemsPresenter implements UseItemOutputBoundary{
    private final ViewManagerModel viewManagerModel;
    private final UseItemsViewModel useItemsViewModel;

    public UseItemsPresenter(ViewManagerModel viewManagerModel, UseItemsViewModel useItemsViewModel){
        this.viewManagerModel = viewManagerModel;
        this.useItemsViewModel = useItemsViewModel;

    }
    @Override
    public void prepareSuccessView() {
        JOptionPane.showMessageDialog(null, "successfully used the item");
        //back to package view(maybe).
        UseItemState useItemState = useItemsViewModel.getState();
        useItemState.setBag(useItemState.getBag());
        useItemsViewModel.setState(useItemState);
        useItemsViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(useItemsViewModel.getViewName());
        System.out.println(useItemsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(){
        JOptionPane.showMessageDialog(null, "no item to use");
    }
}
