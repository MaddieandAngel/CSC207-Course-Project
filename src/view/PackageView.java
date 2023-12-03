package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import entity.ActivePlayer;
import interface_adapter.DropItems.DropItemsController;
import interface_adapter.UseItems.UseItemsController;
import interface_adapter.UseItems.UseItemsViewModel;
import interface_adapter.DropItems.DropItemsViewModel;

public class PackageView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "Package";
    private final UseItemsViewModel useItemsViewModel;
    private final DropItemsViewModel dropItemsViewModel;
    private final JButton useHeal10;
    private final JButton useHeal20;
    private final JButton useHeal45;
    private final JButton dropHeal10;
    private final JButton dropHeal20;
    private final JButton dropHeal45;
    private final JButton dropRevive;
    private final JButton back;

    private JLabel heal10;
    private JLabel heal20;
    private JLabel heal45;
    private JLabel revive;

    private final UseItemsController useItemsController;
    private final DropItemsController dropItemsController;
    private final ActivePlayer player;

    public PackageView(UseItemsViewModel useItemsViewModel, UseItemsController useItemsController_, DropItemsController dropItemsController_, ActivePlayer player, DropItemsViewModel dropItemsViewModel) {

        this.useItemsController = useItemsController_;
        this.dropItemsController = dropItemsController_;
        this.useItemsViewModel = useItemsViewModel;
        this.dropItemsViewModel = dropItemsViewModel;
        this.player = player;
        useItemsViewModel.addPropertyChangeListener(this);


        JPanel buttons = new JPanel();
        this.useHeal10 = new JButton(useItemsViewModel.USE_HEAL10);
        this.useHeal20 = new JButton(useItemsViewModel.USE_HEAL20);
        this.useHeal45 = new JButton(useItemsViewModel.USE_HEAL45);

        this.dropHeal10 = new JButton(dropItemsViewModel.DROP_HEAL10);
        this.dropHeal20 = new JButton(dropItemsViewModel.DROP_HEAL20);
        this.dropHeal45 = new JButton(dropItemsViewModel.DROP_HEAL45);
        this.dropRevive = new JButton(dropItemsViewModel.DROP_REVIVE);

        this.back = new JButton(useItemsViewModel.BACK);

        buttons.add(useHeal10);
        buttons.add(useHeal20);
        buttons.add(useHeal45);
        buttons.add(dropHeal10);
        buttons.add(dropHeal20);
        buttons.add(dropHeal45);
        buttons.add(dropRevive);
        buttons.add(back);

        heal10 = new JLabel("Heal Potion(10%):" + Integer.toString(player.getBag().numOfHeal10()));
        heal20 = new JLabel("Heal Potion(20%):" + Integer.toString(player.getBag().numOfHeal20()));
        heal45 = new JLabel("Heal Potion(45%):" + Integer.toString(player.getBag().numOfHeal45()));
        revive = new JLabel("Rerive Potion:" + Integer.toString(player.getBag().numOfRevive()));

        JLabel title = new JLabel(useItemsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);



        useHeal10.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(useHeal10)) {
                            useItemsController.execute(player, 10);
                            heal10.setText("Heal Potion(10%):" + Integer.toString(player.getBag().numOfHeal10()));

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
                            heal20.setText("Heal Potion(20%):" + Integer.toString(player.getBag().numOfHeal20()));

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
                            heal45.setText("Heal Potion(45%):" + Integer.toString(player.getBag().numOfHeal45()));

                        }
                    }

                }
        );



        dropHeal10.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(dropHeal10)) {
                            dropItemsController.execute(player, 10);
                            heal10.setText("Heal Potion(10%):" + Integer.toString(player.getBag().numOfHeal10()));

                        }
                    }

                }
        );
        dropHeal20.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(dropHeal20)) {
                            dropItemsController.execute(player, 20);
                            heal20.setText("Heal Potion(20%):" + Integer.toString(player.getBag().numOfHeal20()));

                        }
                    }

                }
        );
        dropHeal45.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(dropHeal45)) {
                            dropItemsController.execute(player, 45);
                            heal45.setText("Heal Potion(45%):" + Integer.toString(player.getBag().numOfHeal45()));
                        }
                    }

                }
        );
        dropRevive.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(dropRevive)) {
                            dropItemsController.execute(player, 0);
                            revive.setText("Rerive Potion:" + Integer.toString(player.getBag().numOfRevive()));
                        }
                    }

                }
        );
        back.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            dropItemsController.back();
                        }
                    }

                }
        );



        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
        this.add(heal10);
        this.add(heal20);
        this.add(heal45);
        this.add(revive);
    }
     @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        heal10.setText("Heal Potion(10%):" + Integer.toString(player.getBag().numOfHeal10()));
        heal20.setText("Heal Potion(20%):" + Integer.toString(player.getBag().numOfHeal20()));
        heal45.setText("Heal Potion(45%):" + Integer.toString(player.getBag().numOfHeal45()));
        revive.setText("Rerive Potion:" + Integer.toString(player.getBag().numOfRevive()));
    }
}
