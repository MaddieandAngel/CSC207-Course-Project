package app;

import entity.ActivePlayer;
import interface_adapter.DropToPick.DropToPickController;
import interface_adapter.DropToPick.DropToPickPresenter;
import interface_adapter.DropToPickPackage.DropToPickPackageViewModel;
import interface_adapter.PickUpItem.PickUpItemController;
import interface_adapter.PickUpItem.PickUpItemPresenter;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreViewModel;
import use_case.DropToPick.DropToPickInputBoundary;
import use_case.DropToPick.DropToPickInteractor;
import use_case.DropToPick.DropToPickOutputBoundary;
import use_case.PickUpItem.PickUpItemDataAccessInterface;
import use_case.PickUpItem.PickUpItemInputBoundary;
import use_case.PickUpItem.PickUpItemInteractor;
import use_case.PickUpItem.PickUpItemOutputBoundary;
import view.PickItemView;

public class ItemCollectionUseCaseFactory {
    private ItemCollectionUseCaseFactory(){}
    public static PickItemView create(ViewManagerModel viewManagerModel, ActivePlayer player, PickUpItemViewModel pickUpItemViewModel, PickUpItemDataAccessInterface pickUpItemDataAccessObject, DropToPickPackageViewModel dropToPickPackageViewModel, ExploreViewModel exploreViewModel){
        PickUpItemController pickUpItemController = createPickUpItemsUseCase(viewManagerModel, pickUpItemViewModel, pickUpItemDataAccessObject, exploreViewModel);
        DropToPickController dropToPickController = createDropToPickUseCase(viewManagerModel, dropToPickPackageViewModel, pickUpItemViewModel);
        return new PickItemView(pickUpItemViewModel, pickUpItemController, dropToPickController, player);
    }
    public static PickUpItemController createPickUpItemsUseCase(ViewManagerModel viewManagerModel, PickUpItemViewModel pickUpItemViewModel,  PickUpItemDataAccessInterface pickUpItemDataAccessObject, ExploreViewModel exploreViewModel){
        PickUpItemOutputBoundary pickUpItemPresenter = new PickUpItemPresenter(viewManagerModel, pickUpItemViewModel, exploreViewModel);
        PickUpItemInputBoundary pickUpItemInteracter = new PickUpItemInteractor(pickUpItemDataAccessObject, pickUpItemPresenter);
        return new PickUpItemController(pickUpItemInteracter);
    }
    public static DropToPickController createDropToPickUseCase(ViewManagerModel viewManagerModel, DropToPickPackageViewModel dropToPickPackageViewModel, PickUpItemViewModel pickUpItemViewModel){
        DropToPickOutputBoundary dropToPickPresenter = new DropToPickPresenter(viewManagerModel, dropToPickPackageViewModel, pickUpItemViewModel);
        DropToPickInputBoundary dropToPickInteractor = new DropToPickInteractor(dropToPickPresenter);
        return new DropToPickController(dropToPickInteractor);
    }

}
