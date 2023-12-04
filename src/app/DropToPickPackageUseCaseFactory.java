package app;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import interface_adapter.DropToPick.DropToPickViewModel;
import interface_adapter.DropToPickPackage.DropToPickPackageController;
import interface_adapter.DropToPickPackage.DropToPickPackagePresenter;
import interface_adapter.DropToPickPackage.DropToPickPackageViewModel;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.ViewManagerModel;
import use_case.DropToPickPackage.DropToPickPackageDataAccessInterface;
import use_case.DropToPickPackage.DropToPickPackageInputBoundary;
import use_case.DropToPickPackage.DropToPickPackageInteractor;
import use_case.DropToPickPackage.DropToPickPackageOutputBoundary;
import view.DropToPickPackageView;


public class DropToPickPackageUseCaseFactory {
    private DropToPickPackageUseCaseFactory(){}
    public static DropToPickPackageView create(ViewManagerModel viewManagerModel,
                                               DropToPickPackageViewModel dropToPickPackageViewModel,
                                               DropToPickViewModel dropToPickViewModel,
                                               PickUpItemViewModel pickUpItemViewModel,
                                               DropToPickPackageDataAccessInterface dropToPickPackageDataAccessObject,
                                               UseItemsViewModel useItemsViewModel, InBattleDataAccessObject inBattleDataAccessObject){
        DropToPickPackageController dropToPickPackageController = createDropToPickPackageController(viewManagerModel,dropToPickPackageViewModel,dropToPickViewModel, pickUpItemViewModel, dropToPickPackageDataAccessObject, useItemsViewModel, inBattleDataAccessObject);
        return new DropToPickPackageView(dropToPickPackageController, inBattleDataAccessObject, dropToPickPackageViewModel);

    }
    public static DropToPickPackageController createDropToPickPackageController(ViewManagerModel viewManagerModel, DropToPickPackageViewModel dropToPickPackageViewModel, DropToPickViewModel dropToPickViewModel, PickUpItemViewModel pickUpItemViewModel, DropToPickPackageDataAccessInterface dropToPickPackageDataAccessObject, UseItemsViewModel useItemsViewModel, InBattleDataAccessObject inBattleDataAccessObject){
        DropToPickPackageOutputBoundary dropToPickPackageOutputBoundary = new DropToPickPackagePresenter(viewManagerModel, dropToPickPackageViewModel, dropToPickViewModel, pickUpItemViewModel, useItemsViewModel);
        DropToPickPackageInputBoundary dropToPickPackageInteractor = new DropToPickPackageInteractor(dropToPickPackageDataAccessObject, dropToPickPackageOutputBoundary, inBattleDataAccessObject);
        return new DropToPickPackageController(dropToPickPackageInteractor);
    }
}
