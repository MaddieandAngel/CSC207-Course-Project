package view;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import entity.Player;
import interface_adapter.DropToPickPackage.DropToPickPackageController;
import interface_adapter.DropToPickPackage.DropToPickPackageViewModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DropToPickPackageView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Drop to Pick Package";
    private final DropToPickPackageViewModel dropToPickPackageViewModel;
    private final JButton dropHeal10;
    private final JButton dropHeal20;
    private final JButton dropHeal45;
    private final JButton dropRevive;
    private final JButton back;

    private final JLabel heal10;
    private final JLabel heal20;
    private final JLabel heal45;
    private final JLabel revive;

    private final DropToPickPackageController dropToPickPackageController;
    private final Player player;

    public DropToPickPackageView(DropToPickPackageController dropToPickPackageController, InBattleDataAccessObject inBattleDataAccessObject, DropToPickPackageViewModel dropToPickPackageViewModel) {

        this.dropToPickPackageController = dropToPickPackageController;
        this.dropToPickPackageViewModel = dropToPickPackageViewModel;
        this.player = inBattleDataAccessObject.getPlayer();


        JPanel buttons = new JPanel();
        JPanel textBox = new JPanel();
        JButton numOfItems = new JButton("Update");
        this.dropHeal10 = new JButton(dropToPickPackageViewModel.DROP_HEAL10);
        this.dropHeal20 = new JButton(dropToPickPackageViewModel.DROP_HEAL20);
        this.dropHeal45 = new JButton(dropToPickPackageViewModel.DROP_HEAL45);
        this.dropRevive = new JButton(dropToPickPackageViewModel.DROP_REVIVE);
        this.back = new JButton(dropToPickPackageViewModel.BACK);

        buttons.add(dropHeal10);
        buttons.add(dropHeal20);
        buttons.add(dropHeal45);
        buttons.add(dropRevive);
        buttons.add(numOfItems);


        heal10 = new JLabel("" );
        heal20 = new JLabel("");
        heal45 = new JLabel("");
        revive = new JLabel("" );
        JLabel notice = new JLabel("*click Update button to update \n info of items in bag");
        textBox.add(notice);
        textBox.add(heal10);
        textBox.add(heal20);
        textBox.add(heal45);
        textBox.add(revive);

        Border borders = BorderFactory.createLineBorder(Color.white, 5);
        buttons.setBorder(borders);
        textBox.setBorder(borders);

        Border buttonBorders = BorderFactory.createLineBorder(Color.white, 3);
        dropHeal10.setBorder(buttonBorders);
        dropHeal20.setBorder(buttonBorders);
        dropHeal45.setBorder(buttonBorders);
        dropRevive.setBorder(buttonBorders);
        back.setBorder(buttonBorders);
        numOfItems.setBorder(buttonBorders);

        Color bg = Color.getHSBColor(0, 0, 0.1F);
        this.setBackground(bg);
        buttons.setBackground(bg);
        textBox.setBackground(bg);
        dropHeal10.setBackground(bg);
        dropHeal20.setBackground(bg);
        dropHeal45.setBackground(bg);
        dropRevive.setBackground(bg);
        back.setBackground(bg);
        numOfItems.setBackground(bg);



        Color text = Color.getHSBColor(0, 0, 0.9F);
        dropHeal10.setForeground(text);
        dropHeal20.setForeground(text);
        dropHeal45.setForeground(text);
        dropRevive.setForeground(text);
        back.setForeground(text);
        numOfItems.setForeground(text);
        heal10.setForeground(text);
        heal20.setForeground(text);
        heal45.setForeground(text);
        revive.setForeground(text);
        notice.setForeground(text);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(dropToPickPackageViewModel.TITLE_LABEL);
        title.setForeground(text);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttons.setLayout(new GridLayout(6, 1, 0, 5));
        textBox.setLayout(new GridLayout(6, 1, 0, 5));
        this.setLayout(new GridLayout(2, 3, 0, 0));
        this.add(title);
        this.add(textBox);
        this.add(buttons);
        this.add(back);



        numOfItems.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(numOfItems)) {
                    heal10.setText("Heal Potion(10%):" + Integer.toString(player.getBag().numOfHeal10()));
                    heal20.setText("Heal Potion(20%):" + Integer.toString(player.getBag().numOfHeal20()));
                    heal45.setText("Heal Potion(45%):" + Integer.toString(player.getBag().numOfHeal45()));
                    revive.setText("Rerive Potion:" + Integer.toString(player.getBag().numOfRevive()));
                }
            }

        });

        dropHeal10.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(dropHeal10)) {
                            dropToPickPackageController.execute(10);
                        }
                    }

                }
        );
        dropHeal20.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(dropHeal20)) {
                            dropToPickPackageController.execute(20);
                        }
                    }

                }
        );
        dropHeal45.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(dropHeal45)) {
                            dropToPickPackageController.execute(45);
                        }
                    }

                }
        );
        dropRevive.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(dropRevive)) {
                            dropToPickPackageController.execute(0);
                        }
                    }

                }
        );

        back.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            dropToPickPackageController.back();
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
