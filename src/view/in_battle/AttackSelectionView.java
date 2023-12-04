package view.in_battle;

import interface_adapter.AttackSelect.AttackSelectViewModel;
import interface_adapter.AttackSelect.BackButtonController;
import interface_adapter.AttackSelect.CardButtonController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class AttackSelectionView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Attack Select";

    private final AttackSelectViewModel attackSelectViewModel;

    private final CardButtonController cardButtonController;

    private final BackButtonController backButtonController;

    private final JButton card1;

    private final JButton card2;

    private final JButton card3;

    private final JButton card4;

    private final JButton card5;

    private final JButton back;

    public AttackSelectionView(AttackSelectViewModel attackSelectViewModel, CardButtonController cardButtonController,
                               BackButtonController backButtonController) {
        this.attackSelectViewModel = attackSelectViewModel;
        this.backButtonController = backButtonController;
        this.cardButtonController = cardButtonController;
        attackSelectViewModel.addPropertyChangeListener(this);

        String[] playerHand = attackSelectViewModel.getState().getHand();
        int handSize = playerHand.length;

        JPanel cardButtons = new JPanel();
        // Creating the button for the first card
        if (handSize >= 1) {
            card1 = new JButton(new ImageIcon(attackSelectViewModel.getState().getCard1Image()));
        } else {
            card1 = new JButton();
            card1.setEnabled(false);
        }
        cardButtons.add(card1);

        // Creating the button for the second card
        if (handSize >= 2) {
            card2 = new JButton(new ImageIcon(attackSelectViewModel.getState().getCard2Image()));
        } else {
            card2 = new JButton();
            card2.setEnabled(false);
        }
        cardButtons.add(card2);

        // Creating the button for the third card
        if (handSize >= 3) {
            card3 = new JButton(new ImageIcon(attackSelectViewModel.getState().getCard3Image()));
        } else {
            card3 = new JButton();
            card3.setEnabled(false);
        }
        cardButtons.add(card3);

        // Creating the button for the fourth card
        if (handSize >= 4) {
            card4 = new JButton(new ImageIcon(attackSelectViewModel.getState().getCard4Image()));
        } else {
            card4 = new JButton();
            card4.setEnabled(false);
        }
        cardButtons.add(card4);

        // Creating the button for the fifth card
        if (handSize == 5) {
            card5 = new JButton(new ImageIcon(attackSelectViewModel.getState().getCard5Image()));
        } else {
            card5 = new JButton();
            card5.setEnabled(false);
        }
        cardButtons.add(card5);

        //Creating the back button
        back = new JButton("Back");
        cardButtons.add(back);

        // Customize View
        Color bg = Color.getHSBColor(0, 0, 0.1F);
        this.setBackground(bg);
        cardButtons.setBackground(bg);
        cardButtons.setLayout(new FlowLayout());
        card1.setBackground(bg);
        card2.setBackground(bg);
        card3.setBackground(bg);
        card4.setBackground(bg);
        card5.setBackground(bg);
        back.setBackground(bg);
        Border buttonBorders = BorderFactory.createLineBorder(Color.white, 3);
        card1.setBorder(buttonBorders);
        card2.setBorder(buttonBorders);
        card3.setBorder(buttonBorders);
        card4.setBorder(buttonBorders);
        card5.setBorder(buttonBorders);
        back.setBorder(buttonBorders);

        Color text = Color.getHSBColor(0, 0, 0.9F);
        back.setForeground(text);

        back.setFont(new Font("Verdana", Font.PLAIN, 18));

        this.add(cardButtons);

        // Creating action listeners for each of the buttons
        card1.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(card1)) {
                            try {
                                cardButtonController.execute(playerHand[0]);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
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
                            try {
                                cardButtonController.execute(playerHand[1]);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
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
                            try {
                                cardButtonController.execute(playerHand[2]);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
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
                            try {
                                cardButtonController.execute(playerHand[3]);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
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
                            try {
                                cardButtonController.execute(playerHand[4]);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
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
                            backButtonController.execute();
                        }
                    }
                }
        );

    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        // Don't think anything needs to be implemented here
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Don't think anything needs to be implemented here
    }
}
