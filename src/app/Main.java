package app;

// TODO: Everything

import data_access.DropItemDataAccessObject;
import data_access.DropToPickPackageDataAccessObject;
import data_access.PickUpItemDataAccessObject;
import data_access.UseItemDataAccessObject;
import entity.BagAndItems.healingPotion10;
import entity.BagAndItems.revivePotion;
import entity.Player;
import interface_adapter.DropItems.DropItemsViewModel;
import interface_adapter.DropToPick.DropToPickViewModel;
import interface_adapter.DropToPickPackage.DropToPickPackageViewModel;
import interface_adapter.PickUpItem.PickUpItemViewModel;
import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import interface_adapter.ViewManagerModel;
import use_case.DropToPickPackage.DropToPickPackageDataAccessInterface;
import use_case.PickUpItem.PickUpItemDataAccessInterface;
import view.DropToPickPackageView;
import view.PickItemView;
import view.ViewManager;
import view.PackageView;

public class Main {
    public static <DropToPickPackageDataAccessObject> void main(String[] args) {

        JFrame application = new JFrame("Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);
        UseItemsViewModel useItemsViewModel = new UseItemsViewModel();
        UseItemDataAccessObject useItemDataAccessObject = new UseItemDataAccessObject();
        DropItemsViewModel dropItemsViewModel = new DropItemsViewModel();
        DropItemDataAccessObject dropItemDataAccessObject = new DropItemDataAccessObject();
        PickUpItemViewModel pickUpItemViewModel = new PickUpItemViewModel();
        PickUpItemDataAccessInterface pickUpItemDataAccessObject = new PickUpItemDataAccessObject();

        DropToPickPackageViewModel dropToPickPackageViewModel = new DropToPickPackageViewModel();


        Player on = new Player();
        on.getBag().addItem(new healingPotion10());
        on.getBag().addItem(new revivePotion());
        on.getBag().addItem(new revivePotion());
        on.getBag().addItem(new revivePotion());
        on.getBag().addItem(new revivePotion());
        on.setHealth(on.getMaxHealth()/2);


        PickItemView pickItemView = ItemCollectionUseCaseFactory.create(viewManagerModel, on, pickUpItemViewModel, pickUpItemDataAccessObject, dropToPickPackageViewModel);
        views.add(pickItemView, pickItemView.viewName);
        viewManagerModel.setActiveView(pickItemView.viewName);
        viewManagerModel.firePropertyChanged();

        DropToPickViewModel dropToPickViewModel = new DropToPickViewModel();
        DropToPickPackageDataAccessInterface dropToPickPackageDataAccessObject = new data_access.DropToPickPackageDataAccessObject();

        DropToPickPackageView dropToPickPackageView = DropToPickPackageUseCaseFactory.create(viewManagerModel,
                dropToPickPackageViewModel,
                dropToPickViewModel,
                pickUpItemViewModel,
                dropToPickPackageDataAccessObject,
                on);
        views.add(dropToPickPackageView, dropToPickPackageView.viewName);



//
        PackageView packageView = UseItemUseCaseFactory.create(viewManagerModel, useItemsViewModel, on, useItemDataAccessObject, dropItemsViewModel, dropItemDataAccessObject);
        views.add(packageView, packageView.viewName);
//        viewManagerModel.setActiveView(packageView.viewName);
//        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);


    }
}
