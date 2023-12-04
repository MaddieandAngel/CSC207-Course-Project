package app;

import data_access.DropItemDataAccessObject;
import data_access.InBattleDataAccessObject;
import data_access.UseItemDataAccessObject;
import entity.ActivePlayer;
import interface_adapter.DropItems.DropItemsController;
import interface_adapter.DropItems.DropItemsPresenter;
import interface_adapter.DropItems.DropItemsViewModel;
import interface_adapter.UseItems.UseItemsController;
import interface_adapter.UseItems.UseItemsPresenter;
import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreDataAccessInterface;
import interface_adapter.explore.ExploreViewModel;
import use_case.DropItem.DropItemInputBoundary;
import use_case.DropItem.DropItemInteractor;
import use_case.DropItem.DropItemOutputBoundary;
import use_case.UseItem.UseItemInputBoundary;
import use_case.UseItem.UseItemInteractor;
import use_case.UseItem.UseItemOutputBoundary;
import view.PackageView;

public class UseItemUseCaseFactory {
    private UseItemUseCaseFactory(){}
    public static PackageView create(ViewManagerModel viewManagerModel, UseItemsViewModel useItemsViewModel, InBattleDataAccessObject inBattleDataAccessObject, UseItemDataAccessObject useItemDataAccessObject, DropItemsViewModel dropItemsViewModel, DropItemDataAccessObject dropItemDataAccessObject,
                                     ExploreViewModel exploreViewModel, ExploreDataAccessInterface exploreDataAccessObject){
        UseItemsController useItemsController = createUseItemsUseCase(viewManagerModel, useItemsViewModel, useItemDataAccessObject, inBattleDataAccessObject);
        DropItemsController dropItemsController = createDropItemsUseCase(viewManagerModel, dropItemsViewModel, dropItemDataAccessObject, exploreViewModel, inBattleDataAccessObject, exploreDataAccessObject);
        return new PackageView(useItemsViewModel, useItemsController, dropItemsController, inBattleDataAccessObject, dropItemsViewModel);

    }
    public static UseItemsController createUseItemsUseCase(ViewManagerModel viewManagerModel, UseItemsViewModel useItemsViewModel, UseItemDataAccessObject useItemDataAccessObject, InBattleDataAccessObject inBattleDataAccessObject){
        UseItemOutputBoundary useItemOutputBoundary = new UseItemsPresenter(viewManagerModel, useItemsViewModel);
        UseItemInputBoundary useItemInteracter = new UseItemInteractor(useItemDataAccessObject, useItemOutputBoundary, inBattleDataAccessObject);
        return new UseItemsController(useItemInteracter);
    }
    public static DropItemsController createDropItemsUseCase(ViewManagerModel viewManagerModel, DropItemsViewModel dropItemsViewModel, DropItemDataAccessObject dropItemDataAccessObject, ExploreViewModel exploreViewModel, InBattleDataAccessObject inBattleDataAccessObject, ExploreDataAccessInterface exploreDataAccessObject){
        DropItemOutputBoundary dropItemOutputBoundary = new DropItemsPresenter(viewManagerModel, dropItemsViewModel, exploreViewModel);
        DropItemInputBoundary dropItemInteracter = new DropItemInteractor(dropItemDataAccessObject, dropItemOutputBoundary, inBattleDataAccessObject, exploreDataAccessObject);
        return new DropItemsController(dropItemInteracter);
    }
}
