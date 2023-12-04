package view.in_battle;

import interface_adapter.turn_select.AttackButtonController;
import interface_adapter.turn_select.DrawButtonController;
import interface_adapter.turn_select.ItemsButtonController;
import interface_adapter.turn_select.DefendButtonController;
import interface_adapter.turn_select.FleeButtonController;
import interface_adapter.turn_select.TurnSelectState;
import interface_adapter.turn_select.TurnSelectViewModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

// TODO: Certain sections in here are waiting for other parts of the code to be implemented

public class TurnSelectView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "turn select";

    private final TurnSelectViewModel turnSelectViewModel;

    private final AttackButtonController attackButtonController;
    private final DrawButtonController drawButtonController;
    private final ItemsButtonController itemsButtonController;
    private final DefendButtonController defendButtonController;
    private final FleeButtonController fleeButtonController;

    private final JButton attack;
    private final JButton draw;
    private final JButton items;
    private final JButton defend;
    private final JButton flee;

    private final JLabel textBoxText;
    private final JLabel playerStats; //Holds the player's level, health, AND max health

    public TurnSelectView(AttackButtonController atk_control, DrawButtonController draw_control,
                          ItemsButtonController item_control, DefendButtonController defend_control,
                          FleeButtonController flee_control, TurnSelectViewModel turnSelectViewModel){
        this.attackButtonController = atk_control;
        this.drawButtonController = draw_control;
        this.itemsButtonController = item_control;
        this.defendButtonController = defend_control;
        this.fleeButtonController = flee_control;
        this.turnSelectViewModel = turnSelectViewModel;
        turnSelectViewModel.addPropertyChangeListener(this);

        //Text for the textBox at the bottom of the screen:
        JPanel textBox = new JPanel();
        textBoxText = new JLabel("A placeholder enemy has appeared!");
        textBox.add(textBoxText);

        //Text for the player's level and health:
        JPanel playerStatsPanel = new JPanel();
        playerStats = new JLabel("Level: X | Health: X/X");
        //TODO: include floor level? Would require some changes to many files, I think. Is it worth it?
        playerStatsPanel.add(playerStats);

        //Buttons for the player's possible actions:
        JPanel buttons = new JPanel();
        attack = new JButton(TurnSelectViewModel.ATTACK_BUTTON_LABEL);
        buttons.add(attack);
        draw = new JButton(TurnSelectViewModel.DRAW_BUTTON_LABEL);
        buttons.add(draw);
        items = new JButton(TurnSelectViewModel.ITEMS_BUTTON_LABEL);
        buttons.add(items);
        defend = new JButton(TurnSelectViewModel.DEFEND_BUTTON_LABEL);
        buttons.add(defend);
        flee = new JButton(TurnSelectViewModel.FLEE_BUTTON_LABEL);
        buttons.add(flee);

        buttons.setLayout(new GridLayout(5, 1));
        textBox.setLayout(new GridBagLayout());

        //Set borders
        Border borders = BorderFactory.createLineBorder(Color.white, 5);
        buttons.setBorder(borders);
        textBox.setBorder(borders);

        Border buttonBorders = BorderFactory.createLineBorder(Color.white, 3);
        attack.setBorder(buttonBorders);
        draw.setBorder(buttonBorders);
        items.setBorder(buttonBorders);
        defend.setBorder(buttonBorders);
        flee.setBorder(buttonBorders);

        //Set background colours
        Color bg = Color.getHSBColor(0, 0, 0.1F);
        this.setBackground(bg);
        buttons.setBackground(bg);
        textBox.setBackground(bg);
        playerStatsPanel.setBackground(bg);

        attack.setBackground(bg);
        draw.setBackground(bg);
        items.setBackground(bg);
        defend.setBackground(bg);
        flee.setBackground(bg);

        //Set text colours
        Color text = Color.getHSBColor(0, 0, 0.9F);
        textBoxText.setForeground(text);
        playerStats.setForeground(text);
        attack.setForeground(text);
        draw.setForeground(text);
        items.setForeground(text);
        defend.setForeground(text);
        flee.setForeground(text);

        this.setLayout(new GridBagLayout());
        this.add(playerStatsPanel, new GridBagConstraints(2, 0, this.getWidth() / 3, this.getHeight() / 5,
                0.5, 0.5, GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(10, 10, 10 ,10),
                5, 5));
        this.add(buttons, new GridBagConstraints(2, 1, this.getWidth() / 3, this.getHeight() / 5,
                0.5, 0.5, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(10, 0, 10 ,10),
                50, 45));
        this.add(textBox, new GridBagConstraints(0, 3, this.getWidth() / 3, this.getHeight() / 5,
                0.5, 0.5, GridBagConstraints.PAGE_END, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10 ,10),
                5, 90));

        attack.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_atk) {
                        if (e_atk.getSource().equals(attack)) {
                            try {
                                attackButtonController.execute();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
        );

        draw.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_draw) {
                        if (e_draw.getSource().equals(draw)) {
                            try {
                                drawButtonController.execute();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
        );

        items.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_items) {
                        if (e_items.getSource().equals(items)) {
                            itemsButtonController.execute();
                        }
                    }
                }
        );

        defend.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_defend) {
                        if (e_defend.getSource().equals(defend)) {
                            try {
                                defendButtonController.execute();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
        );

        flee.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_flee) {
                        if (e_flee.getSource().equals(flee)) {
                            JOptionPane.showConfirmDialog(flee, "Fleeing has not been implemented yet. Fight your battle!");
                        }
                    }
                }
        );

    }
    public void actionPerformed(ActionEvent e) {
        // Does anything even need to be added here? SignUpView just uses it for the unimplemented cancel button
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TurnSelectState state = turnSelectViewModel.getState();
        textBoxText.setText("A level " + state.getEnemyLevel() + " " + state.getEnemyName() + " has appeared!");
        // ^ Unnecessary? Not sure
        playerStats.setText("Level: " + state.getPlayerLevel() + "| Health: " + state.getPlayerHealth() + "/" +
                state.getPlayerMaxHealth());

        if (state.getDrawError() != null) {
            JOptionPane.showMessageDialog(this, state.getDrawError());
            state.setDrawError(null);
        }
    }
}
