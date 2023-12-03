package app;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import entity.Player;
import interface_adapter.DropToPick.DropToPickController;
import interface_adapter.DropToPick.DropToPickPresenter;
import interface_adapter.DropToPickPackage.DropToPickPackageViewModel;
import interface_adapter.PickUpItem.PickUpItemController;
import interface_adapter.PickUpItem.PickUpItemPresenter;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.UseItems.UseItemsViewModel;
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
    public static PickItemView create(ViewManagerModel viewManagerModel, PickUpItemViewModel pickUpItemViewModel, PickUpItemDataAccessInterface pickUpItemDataAccessObject, DropToPickPackageViewModel dropToPickPackageViewModel, ExploreViewModel exploreViewModel, UseItemsViewModel useItemsViewModel, InBattleDataAccessObject inBattleDataAccessObject){
        PickUpItemController pickUpItemController = createPickUpItemsUseCase(viewManagerModel, pickUpItemViewModel, pickUpItemDataAccessObject, exploreViewModel, useItemsViewModel, dropToPickPackageViewModel, inBattleDataAccessObject);
        DropToPickController dropToPickController = createDropToPickUseCase(viewManagerModel, dropToPickPackageViewModel, pickUpItemViewModel, useItemsViewModel, inBattleDataAccessObject);
        return new PickItemView(pickUpItemViewModel, pickUpItemController, dropToPickController,inBattleDataAccessObject);
    }
    public static PickUpItemController createPickUpItemsUseCase(ViewManagerModel viewManagerModel, PickUpItemViewModel pickUpItemViewModel, PickUpItemDataAccessInterface pickUpItemDataAccessObject, ExploreViewModel exploreViewModel, UseItemsViewModel useItemsViewModel, DropToPickPackageViewModel dropToPickPackageViewModel, InBattleDataAccessObject inBattleDataAccessObject){
        PickUpItemOutputBoundary pickUpItemPresenter = new PickUpItemPresenter(viewManagerModel, pickUpItemViewModel, exploreViewModel, useItemsViewModel, dropToPickPackageViewModel);
        PickUpItemInputBoundary pickUpItemInteracter = new PickUpItemInteractor(pickUpItemDataAccessObject, pickUpItemPresenter, inBattleDataAccessObject);
        return new PickUpItemController(pickUpItemInteracter);
    }
    public static DropToPickController createDropToPickUseCase(ViewManagerModel viewManagerModel, DropToPickPackageViewModel dropToPickPackageViewModel, PickUpItemViewModel pickUpItemViewModel, UseItemsViewModel useItemsViewModel, InBattleDataAccessObject inBattleDataAccessObject){
        DropToPickOutputBoundary dropToPickPresenter = new DropToPickPresenter(viewManagerModel, dropToPickPackageViewModel, pickUpItemViewModel, useItemsViewModel);
        DropToPickInputBoundary dropToPickInteractor = new DropToPickInteractor(dropToPickPresenter, inBattleDataAccessObject);
        return new DropToPickController(dropToPickInteractor);
    }

}
