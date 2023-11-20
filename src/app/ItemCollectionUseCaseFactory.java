package app;

import data_access.DropItemDataAccessObject;
import data_access.UseItemDataAccessObject;
import entity.Player;
import interface_adapter.DropItems.DropItemsController;
import interface_adapter.DropItems.DropItemsPresenter;
import interface_adapter.DropItems.DropItemsViewModel;
import interface_adapter.DropToPick.DropToPickController;
import interface_adapter.DropToPick.DropToPickPresenter;
import interface_adapter.DropToPickPackage.DropToPickPackageViewModel;
import interface_adapter.PickUpItem.PickUpItemController;
import interface_adapter.PickUpItem.PickUpItemPresenter;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.UseItems.UseItemsController;
import interface_adapter.UseItems.UseItemsPresenter;
import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.ViewManagerModel;
import use_case.DropItem.DropItemInputBoundary;
import use_case.DropItem.DropItemInteractor;
import use_case.DropItem.DropItemOutputBoundary;
import use_case.DropToPick.DropToPickInputBoundary;
import use_case.DropToPick.DropToPickInteractor;
import use_case.DropToPick.DropToPickOutputBoundary;
import use_case.PickUpItem.PickUpItemDataAccessInterface;
import use_case.PickUpItem.PickUpItemInputBoundary;
import use_case.PickUpItem.PickUpItemInteractor;
import use_case.PickUpItem.PickUpItemOutputBoundary;
import use_case.UseItem.UseItemInputBoundary;
import use_case.UseItem.UseItemInteractor;
import use_case.UseItem.UseItemOutputBoundary;
import view.PackageView;
import view.PickItemView;

public class ItemCollectionUseCaseFactory {
    private ItemCollectionUseCaseFactory(){}
    public static PickItemView create(ViewManagerModel viewManagerModel, Player player, PickUpItemViewModel pickUpItemViewModel, PickUpItemDataAccessInterface pickUpItemDataAccessObject,  DropToPickPackageViewModel dropToPickPackageViewModel){
        PickUpItemController pickUpItemController = createPickUpItemsUseCase(viewManagerModel, pickUpItemViewModel, pickUpItemDataAccessObject);
        DropToPickController dropToPickController = createDropToPickUseCase(viewManagerModel, dropToPickPackageViewModel, pickUpItemViewModel);
        return new PickItemView(pickUpItemViewModel, pickUpItemController, dropToPickController, player);
    }
    public static PickUpItemController createPickUpItemsUseCase(ViewManagerModel viewManagerModel, PickUpItemViewModel pickUpItemViewModel,  PickUpItemDataAccessInterface pickUpItemDataAccessObject){
        PickUpItemOutputBoundary pickUpItemPresenter = new PickUpItemPresenter(viewManagerModel, pickUpItemViewModel);
        PickUpItemInputBoundary pickUpItemInteracter = new PickUpItemInteractor(pickUpItemDataAccessObject, pickUpItemPresenter);
        return new PickUpItemController(pickUpItemInteracter);
    }
    public static DropToPickController createDropToPickUseCase(ViewManagerModel viewManagerModel, DropToPickPackageViewModel dropToPickPackageViewModel, PickUpItemViewModel pickUpItemViewModel){
        DropToPickOutputBoundary dropToPickPresenter = new DropToPickPresenter(viewManagerModel, dropToPickPackageViewModel, pickUpItemViewModel);
        DropToPickInputBoundary dropToPickInteractor = new DropToPickInteractor(dropToPickPresenter);
        return new DropToPickController(dropToPickInteractor);
    }

}
