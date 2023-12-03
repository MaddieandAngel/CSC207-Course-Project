package app;

import data_access.*;
import entity.ActivePlayerFactory;
import entity.CurrentFloorFactory;
import interface_adapter.AttackSelect.AttackSelectViewModel;
import interface_adapter.BattleResult.BattleResultViewModel;
import interface_adapter.DropItems.DropItemsViewModel;
import interface_adapter.DropToPick.DropToPickViewModel;
import interface_adapter.DropToPickPackage.DropToPickPackageViewModel;
import interface_adapter.GameOver.GameOverViewModel;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.TitleScreen.TitleScreenViewModel;
import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.WinBattle.WinBattleViewModel;
import interface_adapter.explore.ExploreViewModel;
import interface_adapter.stairs.StairsViewModel;
import interface_adapter.turn_select.TurnSelectViewModel;
import use_case.EnemyBehaviour.EnemyBehaviour;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;
import view.*;
import view.in_battle.BattleResultView;
import view.in_battle.GameOverView;
import view.in_battle.TurnSelectView;
import view.in_battle.WinBattleView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Copied from CACoding:

        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("CSC207 Project - Group 4");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        //Not copied from CACoding:

        //Create the ViewModels
        //TODO: add more view models here once they're created
        ExploreViewModel exploreViewModel = new ExploreViewModel();
        TurnSelectViewModel turnSelectViewModel = new TurnSelectViewModel();
        StairsViewModel stairsViewModel = new StairsViewModel();
        TitleScreenViewModel titleScreenViewModel = new TitleScreenViewModel();
        AttackSelectViewModel attackSelectViewModel = new AttackSelectViewModel();
        BattleResultViewModel battleResultViewModel = new BattleResultViewModel();
        DropItemsViewModel dropItemsViewModel = new DropItemsViewModel();
        DropToPickViewModel dropToPickViewModel = new DropToPickViewModel();
        DropToPickPackageViewModel dropToPickPackageViewModel = new DropToPickPackageViewModel();
        PickUpItemViewModel pickUpItemViewModel = new PickUpItemViewModel();
        UseItemsViewModel useItemsViewModel = new UseItemsViewModel();
        GameOverViewModel gameOverViewModel = new GameOverViewModel();
        WinBattleViewModel winBattleViewModel = new WinBattleViewModel();

        //Create the Data Access Objects
        APIAccess apiAccess = new APIAccess();
        EnemyBehaviourInterface enemyBehaviour = new EnemyBehaviour(apiAccess);
        ExploreDataAccessObject exploreDataAccessObject = new ExploreDataAccessObject(new CurrentFloorFactory());
        InBattleDataAccessObject inBattleDataAccessObject = new InBattleDataAccessObject(new ActivePlayerFactory(), apiAccess, enemyBehaviour);
        DropItemDataAccessObject dropItemDataAccessObject = new DropItemDataAccessObject();
        DropToPickPackageDataAccessObject dropToPickPackageDataAccessObject = new DropToPickPackageDataAccessObject();
        PickUpItemDataAccessObject pickUpItemDataAccessObject = new PickUpItemDataAccessObject();
        UseItemDataAccessObject useItemDataAccessObject = new UseItemDataAccessObject();

        //Create the Views using their UseCaseFactories
        TitleScreenView titleScreenView = TitleScreenUseCaseFactory.create(viewManagerModel, titleScreenViewModel,
                exploreViewModel, exploreDataAccessObject);
        views.add(titleScreenView, titleScreenView.viewName);
        ExploreView exploreView = ExploreUseCaseFactory.create(viewManagerModel, exploreViewModel,turnSelectViewModel, stairsViewModel,
                pickUpItemViewModel, exploreDataAccessObject, inBattleDataAccessObject, enemyBehaviour, apiAccess);
        views.add(exploreView, exploreView.viewName);
        StairsView stairsView = StairsUseCaseFactory.create(viewManagerModel, exploreViewModel, stairsViewModel, exploreDataAccessObject,
                exploreDataAccessObject);
        views.add(stairsView, stairsView.viewName);
        //Commented out for now because the TurnSelectUseCaseFactory doesn't fully work yet
//        TurnSelectView turnSelectView = TurnSelectUseCaseFactory.create(viewManagerModel, attackSelectViewModel, turnSelectViewModel);
//        views.add(turnSelectView, turnSelectView.viewName);
        BattleResultView battleResultView = BattleResultUseCaseFactory.create(viewManagerModel, battleResultViewModel,
                turnSelectViewModel, gameOverViewModel, winBattleViewModel, inBattleDataAccessObject);
        views.add(battleResultView, battleResultView.viewName);
        GameOverView gameOverView = GameOverUseCaseFactory.create(viewManagerModel, gameOverViewModel, titleScreenViewModel,
                exploreViewModel, exploreDataAccessObject);
        views.add(gameOverView, gameOverView.viewName);
        WinBattleView winBattleView = WinBattleUseCaseFactory.create(viewManagerModel, winBattleViewModel, exploreViewModel, exploreDataAccessObject);
        views.add(winBattleView, winBattleView.viewName);

        viewManagerModel.setActiveView(titleScreenView.viewName);
        viewManagerModel.firePropertyChanged();

        application.setSize(800,500);
        application.setVisible(true);
    }
}
