package view.in_battle;

import interface_adapter.AttackSelect.BackButtonController;
import interface_adapter.ItemSelect.HealButtonController;
import interface_adapter.ItemSelect.ItemSelectState;
import interface_adapter.ItemSelect.ItemSelectViewModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class ItemSelectionView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Item Select";

    private final ItemSelectViewModel itemSelectViewModel;

    private final HealButtonController healButtonController;

    private final BackButtonController backButtonController;

    private final JButton heal10;

    private final JButton heal20;

    private final JButton heal45;

    private final JButton back;

    public ItemSelectionView(ItemSelectViewModel itemSelectViewModel, HealButtonController healButtonController,
                             BackButtonController backButtonController) {
        this.itemSelectViewModel = itemSelectViewModel;
        this.healButtonController = healButtonController;
        this.backButtonController = backButtonController;
        itemSelectViewModel.addPropertyChangeListener(this);

        JPanel healButtons = new JPanel();
        // Creating the button for using heal10
        heal10 = new JButton("Heal 10% ");
        healButtons.add(heal10);

        // Creating the button for using heal20
        heal20 = new JButton("Heal 20% ");
        healButtons.add(heal20);

        // Creating the button for using heal45
        heal45 = new JButton("Heal 45% ");
        healButtons.add(heal45);

        // Creating the back button
        back = new JButton("Back");
        healButtons.add(back);

        // Customize View
        Color bg = Color.getHSBColor(0, 0, 0.1F);
        this.setBackground(bg);
        healButtons.setBackground(bg);
        healButtons.setLayout(new FlowLayout());
        heal10.setBackground(bg);
        heal20.setBackground(bg);
        heal45.setBackground(bg);
        back.setBackground(bg);
        Border buttonBorders = BorderFactory.createLineBorder(Color.white, 3);
        heal10.setBorder(buttonBorders);
        heal20.setBorder(buttonBorders);
        heal45.setBorder(buttonBorders);
        back.setBorder(buttonBorders);

        Color text = Color.getHSBColor(0, 0, 0.9F);
        heal10.setForeground(text);
        heal20.setForeground(text);
        heal45.setForeground(text);
        back.setForeground(text);

        heal10.setFont(new Font("Verdana", Font.PLAIN, 18));
        heal20.setFont(new Font("Verdana", Font.PLAIN, 18));
        heal45.setFont(new Font("Verdana", Font.PLAIN, 18));
        back.setFont(new Font("Verdana", Font.PLAIN, 18));

        this.add(healButtons);

        // Creating action listeners for each of the buttons
        heal10.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(heal10)) {
                            try {
                                healButtonController.execute(10);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );

        heal20.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(heal20)) {
                            try {
                                healButtonController.execute(20);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );

        heal45.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(heal45)) {
                            try {
                                healButtonController.execute(45);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );

        back.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            backButtonController.execute();
                        }
                    }
                }
        );

    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        ItemSelectState state = itemSelectViewModel.getState();
        if (state.getItemError() != null) {
            JOptionPane.showMessageDialog(this, state.getItemError());
            state.setItemError(null);
            itemSelectViewModel.setState(state);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}
