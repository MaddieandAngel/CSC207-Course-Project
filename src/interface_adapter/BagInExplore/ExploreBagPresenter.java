package interface_adapter.BagInExplore;

import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.ViewManagerModel;
import use_case.ExploreBag.ExploreBagOutputBoundary;

public class ExploreBagPresenter implements ExploreBagOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final UseItemsViewModel useItemsViewModel;

    public ExploreBagPresenter(ViewManagerModel viewManagerModel, UseItemsViewModel useItemsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.useItemsViewModel = useItemsViewModel;
    }

    @Override
    public void preparePackageView() {
        viewManagerModel.setActiveView(useItemsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
