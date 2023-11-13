package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import entity.Player;
import interface_adapter.UseItems.UseItemsController;
import interface_adapter.UseItems.UseItemsViewModel;

public class PackageView extends JPanel implements ActionListener, PropertyChangeListener{
    private final UseItemsViewModel useItemsViewModel;
    private final JButton useHeal10;
    private final JButton useHeal20;
    private final JButton useHeal45;
    private final JButton dropHeal10;
    private final JButton dropHeal20;
    private final JButton dropHeal45;
    private final JButton dropRevive;

    private final UseItemsController useItemsController;

    public PackageView(UseItemsViewModel useItemsViewModel, JButton dropItem, UseItemsController useItemsController, Player player) {

        JPanel buttons = new JPanel();
        this.useItemsController = useItemsController;

        this.useItemsViewModel = useItemsViewModel;

        this.useHeal10 = new JButton(useItemsViewModel.USE_HEAL10);
        this.useHeal20 = new JButton(useItemsViewModel.USE_HEAL20);
        this.useHeal45 = new JButton(useItemsViewModel.USE_HEAL45);


        this.dropHeal10 = new JButton(useItemsViewModel.DROP_HEAL10);
        this.dropHeal20 = new JButton(useItemsViewModel.DROP_HEAL20);
        this.dropHeal45 = new JButton(useItemsViewModel.DROP_HEAL45);
        this.dropRevive = new JButton(useItemsViewModel.DROP_REVIVE);

        buttons.add(useHeal10);
        buttons.add(useHeal20);
        buttons.add(useHeal45);
        buttons.add(dropHeal10);
        buttons.add(dropHeal20);
        buttons.add(dropHeal45);
        buttons.add(dropRevive);

        useHeal10.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(useHeal10)) {
                            useItemsController.execute(player, 10);

                        }
                    }

                }
        );
        useHeal20.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(useHeal20)) {
                            useItemsController.execute(player, 20);

                        }
                    }

                }
        );
        useHeal45.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(useHeal45)) {
                            useItemsController.execute(player, 45);

                        }
                    }

                }
        );



        dropItem.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(dropItem)) {


                        }
                    }

                }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
