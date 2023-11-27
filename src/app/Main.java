package app;

import data_access.APIAccess;
import data_access.ExploreDataAccessObject;
import data_access.InBattleDataAccessObject;
import entity.CurrentFloorFactory;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreViewModel;
import interface_adapter.stairs.StairsViewModel;
import interface_adapter.turn_select.TurnSelectViewModel;
import view.ExploreView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
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
        PickUpItemViewModel pickUpItemViewModel = new PickUpItemViewModel();


        //Create the Data Access Objects
        APIAccess apiAccess = new APIAccess();
        ExploreDataAccessObject exploreDataAccessObject = new ExploreDataAccessObject(new CurrentFloorFactory());
        InBattleDataAccessObject inBattleDataAccessObject = new InBattleDataAccessObject();

        //Create the Views using their UseCaseFactories
        ExploreView exploreView = ExploreUseCaseFactory.create(viewManagerModel, exploreViewModel,turnSelectViewModel, stairsViewModel,
                pickUpItemViewModel, exploreDataAccessObject, inBattleDataAccessObject, apiAccess);
        views.add(exploreView, exploreView.viewName);


        viewManagerModel.setActiveView(exploreView.viewName); //TODO: Change this to title screen view later
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
