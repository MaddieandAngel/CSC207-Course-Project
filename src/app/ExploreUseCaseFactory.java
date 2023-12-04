package app;

import entity.CurrentEnemyFactory;
import entity.EnemyFactory;
import interface_adapter.APIAccessInterface;
import interface_adapter.BagInExplore.ExploreBagController;
import interface_adapter.BagInExplore.ExploreBagPresenter;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.explore.*;
import interface_adapter.stairs.StairsViewModel;
import interface_adapter.turn_select.TurnSelectViewModel;
import use_case.ExploreBag.ExploreBagInputBoundary;
import use_case.ExploreBag.ExploreBagInteractor;
import use_case.ExploreBag.ExploreBagOutputBoundary;
import use_case.SearchButton.SearchButtonIneractor;
import use_case.SearchButton.SearchButtonInputBoundary;
import use_case.SearchButton.SearchButtonOutputBoundary;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;
import use_case.movement.MovementInputBoundary;
import use_case.movement.MovementInteractor;
import use_case.movement.MovementOutputBoundary;
import view.ExploreView;

public class ExploreUseCaseFactory {

    private ExploreUseCaseFactory(){}

    public static ExploreView create(ViewManagerModel viewManagerModel, ExploreViewModel exploreViewModel,
                                     TurnSelectViewModel turnSelectViewModel, StairsViewModel stairsViewModel,
                                     PickUpItemViewModel pickUpItemViewModel, ExploreDataAccessInterface exploreDataAccessObject,
                                     GenerateEnemyDataAccessInterface inBattleDataAccessObject, EnemyBehaviourInterface enemyBehaviour,
                                     APIAccessInterface apiAccessInterface,
                                     UseItemsViewModel useItemsViewModel){

        MovementButtonController movementButtonController = createMovementUseCase(viewManagerModel, exploreViewModel, turnSelectViewModel,
                stairsViewModel, pickUpItemViewModel, exploreDataAccessObject, inBattleDataAccessObject, enemyBehaviour, apiAccessInterface);
        SearchButtonController searchButtonController = createSearchRoomUseCase(exploreViewModel, turnSelectViewModel, viewManagerModel,
                apiAccessInterface, exploreDataAccessObject, inBattleDataAccessObject, pickUpItemViewModel, enemyBehaviour);
        ExploreBagController exploreBagController = createExploreBagUseCase(viewManagerModel, useItemsViewModel);

        return new ExploreView(movementButtonController, searchButtonController, exploreViewModel, exploreBagController);
    }

    private static MovementButtonController createMovementUseCase(ViewManagerModel viewManagerModel, ExploreViewModel exploreViewModel,
                                                                  TurnSelectViewModel turnSelectViewModel, StairsViewModel stairsViewModel,
                                                                  PickUpItemViewModel pickUpItemViewModel,
                                                                  ExploreDataAccessInterface exploreDataAccessObject,
                                                                  GenerateEnemyDataAccessInterface inBattleDataAccessObject,
                                                                  EnemyBehaviourInterface enemyBehaviour,
                                                                  APIAccessInterface apiAccessInterface){

        MovementOutputBoundary movementOutputBoundary = new ExplorePresenter(viewManagerModel, exploreViewModel, turnSelectViewModel,
                stairsViewModel, pickUpItemViewModel);

        EnemyFactory enemyFactory = new CurrentEnemyFactory();

        MovementInputBoundary movementUseCaseInteractor = new MovementInteractor(exploreDataAccessObject, inBattleDataAccessObject,
                movementOutputBoundary, enemyFactory, enemyBehaviour, apiAccessInterface);

        return new MovementButtonController(movementUseCaseInteractor);
    }

    private static SearchButtonController createSearchRoomUseCase( ExploreViewModel exploreViewModel,
                                                                   TurnSelectViewModel turnSelectViewModel,
                                                                   ViewManagerModel viewManagerModel,
                                                                   APIAccessInterface apiAccessInterface,
                                                                   ExploreDataAccessInterface exploreDataAccessObject,
                                                                   GenerateEnemyDataAccessInterface inBattleDataAccessObject,
                                                                   PickUpItemViewModel pickUpItemViewModel,
                                                                   EnemyBehaviourInterface enemyBehaviour){
        EnemyFactory enemyFactory = new CurrentEnemyFactory();
        SearchButtonOutputBoundary searchButtonOutputBoundary = new SearchButtonPresenter(exploreViewModel, turnSelectViewModel, pickUpItemViewModel, viewManagerModel);
        SearchButtonInputBoundary searchButtonInputBoundary = new SearchButtonIneractor(searchButtonOutputBoundary, enemyFactory, apiAccessInterface, exploreDataAccessObject, inBattleDataAccessObject, enemyBehaviour);
        //TODO: implement properly
        return new SearchButtonController(searchButtonInputBoundary);
    }
    private static ExploreBagController createExploreBagUseCase(ViewManagerModel viewManagerModel, UseItemsViewModel useItemsViewModel){
        ExploreBagOutputBoundary exploreBagOutputBoundary = new ExploreBagPresenter(viewManagerModel, useItemsViewModel);
        ExploreBagInputBoundary exploreBagInputBoundary = new ExploreBagInteractor(exploreBagOutputBoundary);
        return new ExploreBagController(exploreBagInputBoundary);
    }
}
