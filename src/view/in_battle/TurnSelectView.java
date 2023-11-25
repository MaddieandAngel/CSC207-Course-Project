package view.in_battle;

import entity.ActivePlayer;
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

    private final ActivePlayer player;

    private final JButton attack;
    private final JButton draw;
    private final JButton items;
    private final JButton defend;
    private final JButton flee;

    public TurnSelectView(AttackButtonController atk_control, DrawButtonController draw_control,
                          ItemsButtonController item_control, DefendButtonController defend_control,
                          FleeButtonController flee_control, TurnSelectViewModel turnSelectViewModel, ActivePlayer player){
        this.attackButtonController = atk_control;
        this.drawButtonController = draw_control;
        this.itemsButtonController = item_control;
        this.defendButtonController = defend_control;
        this.fleeButtonController = flee_control;
        this.turnSelectViewModel = turnSelectViewModel;
        this.player = player;
        turnSelectViewModel.addPropertyChangeListener(this);

        JPanel textbox = new JPanel();
        textbox.add(new JLabel(turnSelectViewModel.textbox_text));

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

        attack.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_atk) {
                        if (e_atk.getSource().equals(attack)) {
                            attackButtonController.execute(player);
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

        // TODO: Add UI for the player's health and level in the top right corner

    }
    public void actionPerformed(ActionEvent e) {
        // Does anything even need to be added here? SignUpView just uses it for the unimplemented cancel button
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TurnSelectState state = (TurnSelectState) evt.getNewValue();
        //TODO: Implement this
    }
}
