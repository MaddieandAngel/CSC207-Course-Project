package app;

// TODO: Everything

import data_access.DropItemDataAccessObject;
import data_access.UseItemDataAccessObject;
import entity.BagAndItems.healingPotion10;
import entity.BagAndItems.revivePotion;
import entity.Player;
import interface_adapter.DropItems.DropItemsViewModel;
import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import interface_adapter.ViewManagerModel;
import view.ViewManager;
import view.PackageView;

public class Main {
    public static void main(String[] args) {
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

        Player on = new Player();
        on.getBag().addItem(new healingPotion10());
        on.getBag().addItem(new revivePotion());

        PackageView packageView = UseItemUseCaseFactory.create(viewManagerModel, useItemsViewModel, on, useItemDataAccessObject, dropItemsViewModel, dropItemDataAccessObject);
        views.add(packageView, packageView.viewName);
        viewManagerModel.setActiveView(packageView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);


    }
}
