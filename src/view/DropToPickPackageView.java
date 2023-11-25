package view;

import interface_adapter.DropToPickPackage.DropToPickPackageController;
import interface_adapter.DropToPickPackage.DropToPickPackageViewModel;

import javax.swing.*;
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

    public DropToPickPackageView(DropToPickPackageController dropToPickPackageController, Player player, DropToPickPackageViewModel dropToPickPackageViewModel) {

        this.dropToPickPackageController = dropToPickPackageController;
        this.dropToPickPackageViewModel = dropToPickPackageViewModel;
        this.player = player;


        JPanel buttons = new JPanel();
        this.dropHeal10 = new JButton(dropToPickPackageViewModel.DROP_HEAL10);
        this.dropHeal20 = new JButton(dropToPickPackageViewModel.DROP_HEAL20);
        this.dropHeal45 = new JButton(dropToPickPackageViewModel.DROP_HEAL45);
        this.dropRevive = new JButton(dropToPickPackageViewModel.DROP_REVIVE);
        this.back = new JButton(dropToPickPackageViewModel.BACK);

        buttons.add(dropHeal10);
        buttons.add(dropHeal20);
        buttons.add(dropHeal45);
        buttons.add(dropRevive);
        buttons.add(back);

        heal10 = new JLabel("Heal Potion(10%):" + Integer.toString(player.getBag().numOfHeal10()));
        heal20 = new JLabel("Heal Potion(20%):" + Integer.toString(player.getBag().numOfHeal20()));
        heal45 = new JLabel("Heal Potion(45%):" + Integer.toString(player.getBag().numOfHeal45()));
        revive = new JLabel("Rerive Potion:" + Integer.toString(player.getBag().numOfRevive()));

        JLabel title = new JLabel(dropToPickPackageViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        dropHeal10.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(dropHeal10)) {
                            dropToPickPackageController.execute(player, 10, 0);
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
                            dropToPickPackageController.execute(player, 20, 0);
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
                            dropToPickPackageController.execute(player, 45, 0);
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
                            dropToPickPackageController.execute(player, 0, 0);
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
                            dropToPickPackageController.back();
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
    }
}
