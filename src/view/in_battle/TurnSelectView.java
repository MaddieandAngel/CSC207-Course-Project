package view.in_battle;

import interface_adapter.turn_select.AttackButtonController;
import interface_adapter.turn_select.DrawButtonController;
import interface_adapter.turn_select.ItemsButtonController;
import interface_adapter.turn_select.DefendButtonController;
import interface_adapter.turn_select.FleeButtonController;
import interface_adapter.turn_select.TurnSelectState;
import interface_adapter.turn_select.TurnSelectViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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

    private JLabel textboxText;
    private JLabel playerStats; //Holds the player's level, health, AND max health

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

        //Text for the textbox at the bottom of the screen:
        JPanel textbox = new JPanel();
        textboxText = new JLabel("A level " + turnSelectViewModel.getState().getEnemyLevel() + " " +
                turnSelectViewModel.getState().getEnemyName() + " has appeared!");
        textbox.add(textboxText);

        //Text for the player's level and health:
        JPanel playerStatsPanel = new JPanel();
        playerStats = new JLabel("Level: " + turnSelectViewModel.getState().getPlayerLevel() + "\nHealth: " +
                turnSelectViewModel.getState().getPlayerHealth() + "/" +
                turnSelectViewModel.getState().getPlayerMaxHealth());
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

        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS)); //Should give the buttons a vertical layout?
        buttons.setAlignmentX(Component.RIGHT_ALIGNMENT); //Should put the buttons on the right side of the screen?
        buttons.setAlignmentY(Component.CENTER_ALIGNMENT); //Should put the buttons in the center (Y-axis) of the screen?
        // TODO: Figure out how to give the buttons JPanel a border

        textbox.setAlignmentX(Component.LEFT_ALIGNMENT);
        textbox.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        playerStatsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        playerStatsPanel.setAlignmentY(Component.TOP_ALIGNMENT);

        attack.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_atk) {
                        if (e_atk.getSource().equals(attack)) {
                            attackButtonController.execute();
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
                            // TODO: Implement this once the DrawButtonController is written
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
                            // TODO: Implement this once the ItemsButtonController is written
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
                            defendButtonController.execute();
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
                            // TODO: Implement this once the FleeButtonController is written
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
        textboxText.setText("A level " + state.getEnemyLevel() + " " + state.getEnemyName() + " has appeared!");
        // ^ Unnecessary? Not sure
        playerStats.setText("Level: " + state.getPlayerLevel() + "\nHealth: " + state.getPlayerHealth() + "/" +
                state.getPlayerMaxHealth());
    }
}
