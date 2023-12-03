package view;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import entity.Player;
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
    private final Player player;

    public PackageView(UseItemsViewModel useItemsViewModel, UseItemsController useItemsController_, DropItemsController dropItemsController_, InBattleDataAccessObject inBattleDataAccessObject, DropItemsViewModel dropItemsViewModel) {

        this.useItemsController = useItemsController_;
        this.dropItemsController = dropItemsController_;
        this.useItemsViewModel = useItemsViewModel;
        this.dropItemsViewModel = dropItemsViewModel;
        this.player = inBattleDataAccessObject.getPlayer();
        useItemsViewModel.addPropertyChangeListener(this);


        JPanel buttons = new JPanel();
        JPanel textBox = new JPanel();
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


        heal10 = new JLabel("Heal Potion(10%):" + Integer.toString(player.getBag().numOfHeal10()));
        heal20 = new JLabel("Heal Potion(20%):" + Integer.toString(player.getBag().numOfHeal20()));
        heal45 = new JLabel("Heal Potion(45%):" + Integer.toString(player.getBag().numOfHeal45()));
        revive = new JLabel("Rerive Potion:" + Integer.toString(player.getBag().numOfRevive()));
        JLabel title = new JLabel(useItemsViewModel.TITLE_LABEL);
        title.setFont(new Font("Verdana", Font.PLAIN, 18));

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        textBox.add(title);
        textBox.add(heal45);
        textBox.add(heal20);
        textBox.add(heal10);
        textBox.add(revive);



        Border buttonBorders = BorderFactory.createLineBorder(Color.white, 3);
        useHeal10.setBorder(buttonBorders);
        useHeal20.setBorder(buttonBorders);
        useHeal45.setBorder(buttonBorders);
        dropHeal10.setBorder(buttonBorders);
        dropHeal20.setBorder(buttonBorders);
        dropHeal45.setBorder(buttonBorders);
        dropRevive.setBorder(buttonBorders);
        back.setBorder(buttonBorders);



        Color bg = Color.getHSBColor(0, 0, 0.1F);
        this.setBackground(bg);
        buttons.setBackground(bg);
        textBox.setBackground(bg);
        useHeal10.setBackground(bg);
        useHeal20.setBackground(bg);
        useHeal45.setBackground(bg);
        revive.setBackground(bg);
        dropHeal10.setBackground(bg);
        dropHeal20.setBackground(bg);
        dropHeal45.setBackground(bg);
        dropRevive.setBackground(bg);
        back.setBackground(bg);

        Color text = Color.getHSBColor(0, 0, 0.9F);
        useHeal10.setForeground(text);
        useHeal20.setForeground(text);
        useHeal45.setForeground(text);
        revive.setForeground(text);
        heal45.setForeground(text);
        heal20.setForeground(text);
        heal10.setForeground(text);
        title.setForeground(text);
        dropHeal10.setForeground(text);
        dropHeal20.setForeground(text);
        dropHeal45.setForeground(text);
        dropRevive.setForeground(text);
        back.setForeground(text);

        buttons.setLayout(new GridLayout(6, 2, 0, 5));
        textBox.setLayout(new GridLayout(6, 1, 0, 5));
        this.setLayout(new GridLayout(1, 3, 0, 0));
        this.add(textBox);
        this.add(buttons);

        this.add(back);





        useHeal10.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(useHeal10)) {
                            useItemsController.execute(10);
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
                            useItemsController.execute(20);
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
                            useItemsController.execute( 45);
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
                            dropItemsController.execute( 10);
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
                            dropItemsController.execute(20);
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
                            dropItemsController.execute(45);
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
                            dropItemsController.execute(0);
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
