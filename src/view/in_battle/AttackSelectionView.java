package view.in_battle;

import interface_adapter.APIAccessInterface;
import interface_adapter.AttackSelect.AttackSelectViewModel;
import interface_adapter.AttackSelect.BackButtonController;
import interface_adapter.AttackSelect.CardButtonController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class AttackSelectionView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Attack Select";

    private final AttackSelectViewModel attackSelectViewModel;

    private final CardButtonController cardButtonController;

    private final BackButtonController backButtonController;

    private final APIAccessInterface api;

    private final JButton card1;

    private final JButton card2;

    private final JButton card3;

    private final JButton card4;

    private final JButton card5;

    private final JButton back;

    public AttackSelectionView(AttackSelectViewModel attackSelectViewModel, CardButtonController cardButtonController, BackButtonController backButtonController, APIAccessInterface api) {
        this.attackSelectViewModel = attackSelectViewModel;
        this.backButtonController = backButtonController;
        this.cardButtonController = cardButtonController;
        this.api = api;
        attackSelectViewModel.addPropertyChangeListener(this);

        String[] playerHand = attackSelectViewModel.getState().getHand();
        int handSize = attackSelectViewModel.getState().getHand().length;

        JPanel cardButtons = new JPanel();
        // Creating the button for the first card
        if (handSize >= 1) {
            card1 = new JButton(new ImageIcon(api.GetCardImage(playerHand[0])));
        } else {
            card1 = new JButton();
            card1.setEnabled(false);
        }
        cardButtons.add(card1);

        // Creating the button for the second card
        if (handSize >= 2) {
            card2 = new JButton(new ImageIcon(api.GetCardImage(playerHand[1])));
        } else {
            card2 = new JButton();
            card2.setEnabled(false);
        }
        cardButtons.add(card2);

        // Creating the button for the third card
        if (handSize >= 3) {
            card3 = new JButton(new ImageIcon(api.GetCardImage(playerHand[2])));
        } else {
            card3 = new JButton();
            card3.setEnabled(false);
        }
        cardButtons.add(card3);

        // Creating the button for the fourth card
        if (handSize >= 4) {
            card4 = new JButton(new ImageIcon(api.GetCardImage(playerHand[3])));
        } else {
            card4 = new JButton();
            card4.setEnabled(false);
        }
        cardButtons.add(card4);

        // Creating the button for the fifth card
        if (handSize == 5) {
            card5 = new JButton(new ImageIcon(api.GetCardImage(playerHand[4])));
        } else {
            card5 = new JButton();
            card5.setEnabled(false);
        }
        cardButtons.add(card5);

        //Creating the back button
        back = new JButton("Back");
        cardButtons.add(back);

        // Setting the layout for the buttons
        cardButtons.setLayout(new FlowLayout());

        // Creating action listeners for each of the buttons
        card1.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(card1)) {
                            // TODO: implement
                        }
                    }
                }
        );

        card2.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(card2)) {
                            // TODO: implement
                        }
                    }
                }
        );

        card3.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(card3)) {
                            // TODO: implement
                        }
                    }
                }
        );

        card4.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(card4)) {
                            // TODO: implement
                        }
                    }
                }
        );

        card5.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(card5)) {
                            // TODO: implement
                        }
                    }
                }
        );

        back.addActionListener(
                // This creates and anonymous subclass of ActionListener and instantiates it
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            // TODO: implement
                        }
                    }
                }
        );

    }

}
