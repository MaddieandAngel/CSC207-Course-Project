package view.in_battle;

import interface_adapter.BattleResult.BattleResultState;
import interface_adapter.BattleResult.BattleResultViewModel;
import interface_adapter.BattleResult.ContinueButtonController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BattleResultView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "battle result";

    private final JLabel action1;
    private final JLabel action2;
    private final JLabel action3;
    private final JLabel revivePotionUsed;
    private final JLabel playerStats;
    private final JLabel playerCard;
    private final JLabel enemyCard;
    private final BattleResultViewModel battleResultViewModel;

    public BattleResultView(BattleResultViewModel battleResultViewModel, ContinueButtonController continueController) {
        this.battleResultViewModel = battleResultViewModel;

        JPanel buttonAndPlayerCard = new JPanel();
        playerCard = new JLabel(new ImageIcon());
        playerCard.add(buttonAndPlayerCard);
        JButton continueButton = new JButton(battleResultViewModel.CONTINUE_LABEL);
        continueButton.add(buttonAndPlayerCard);

        buttonAndPlayerCard.setLayout(new BoxLayout(buttonAndPlayerCard, BoxLayout.Y_AXIS));

        JPanel playerStatsPanel = new JPanel();
        playerStats = new JLabel("Level: X | Health: X/X");
        playerStatsPanel.add(playerStats);

        JPanel textBox = new JPanel();
        action1 = new JLabel("Placeholder text for turn action 1 (if applicable)");
        action1.add(textBox);
        action2 = new JLabel("Placeholder text for turn action 2");
        action2.add(textBox);
        action3 = new JLabel("Placeholder text for turn action 3");
        action3.add(textBox);
        revivePotionUsed = new JLabel("Player's HP fell to 0! Player used Revive Potion!");
        revivePotionUsed.add(textBox);

        textBox.setLayout(new BoxLayout(textBox, BoxLayout.Y_AXIS));

        enemyCard = new JLabel(new ImageIcon());

        //Set borders
        Border borders = BorderFactory.createLineBorder(Color.white, 5);
        buttonAndPlayerCard.setBorder(borders);
        textBox.setBorder(borders);

        Border buttonBorders = BorderFactory.createLineBorder(Color.white, 3);
        continueButton.setBorder(buttonBorders);

        //Set background colours
        Color bg = Color.getHSBColor(0, 0, 0.1F);
        this.setBackground(bg);
        buttonAndPlayerCard.setBackground(bg);
        textBox.setBackground(bg);
        playerStatsPanel.setBackground(bg);
        continueButton.setBackground(bg);

        //Set text colours
        Color text = Color.getHSBColor(0, 0, 0.9F);
        playerStats.setForeground(text);
        action1.setForeground(text);
        action2.setForeground(text);
        action3.setForeground(text);
        revivePotionUsed.setForeground(text);
        continueButton.setForeground(text);

        //Player card is only visible when the player attacks with a card or draws a new card
        playerCard.setVisible(false);
        //Enemy card is only visible when the enemy attacks with a card
        enemyCard.setVisible(false);
        //The line for action1 only appears if bonus damage has been dealt during the turn
        action1.setVisible(false);
        //The line for revivePotionUsed only appears if the player needed to use a revivePotion
        revivePotionUsed.setVisible(false);

        this.setLayout(new GridBagLayout());
        //TODO: pain and suffering with making the grid bag layout work
        this.add(enemyCard);
        this.add(playerStatsPanel);
        this.add(buttonAndPlayerCard);
        this.add(textBox);

        continueButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        continueController.execute();
                    }
                }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        BattleResultState state = battleResultViewModel.getState();

        //Update display for player's health
        playerStats.setText("Level: " + state.getPlayerLevel() + " | Health: " +
                state.getPlayerCurrentHealth() + "/" +
                state.getPlayerMaxHealth());

        String playerCardName = "";
        String enemyCardName = "";

        //Convert the cards the player and enemy attacked with (if they did) to their full names, for nicer output text
        //Also set images for the cards
        if (state.getPlayerAction().equals("attack") || state.getPlayerAction().equals("draw")){
            playerCard.setIcon(new ImageIcon(state.getPlayerCardImage()));
            playerCard.setVisible(true);
            if (state.getPlayerCardSuit() == 'J'){
                playerCardName = "Joker";
            }
            else {
                playerCardName = convertCardValues(state.getPlayerCardValue()) + " of " + convertSuitsToFullName(state.getPlayerCardSuit());
            }
        }
        if (state.getEnemyAction().equals("attack")){
            enemyCard.setIcon(new ImageIcon(state.getEnemyCardImage()));
            enemyCard.setVisible(true);
            if (state.getEnemyCardSuit() == 'J'){
                enemyCardName = "Joker";
            }
            else {
                enemyCardName = convertCardValues(state.getEnemyCardValue()) + " of " + convertSuitsToFullName(state.getEnemyCardSuit());
            }
        }

        //Set action1 label, which is only visible if bonus damage occurred this turn
        if (state.getBonusDamage().equals("player")){ //Player dealt bonus damage this turn
            action1.setText("Player's " + playerCardName + " is super effective against enemy's " + enemyCardName + "!");
            action1.setVisible(true);
        }
        else if (state.getBonusDamage().equals("enemy")){ //Enemy dealt bonus damage this turn
            action1.setText("Enemy's " + enemyCardName + " is super effective against player's " + playerCardName + "!");
            action1.setVisible(true);
        }
        else { //Otherwise, no bonus damage was dealt this turn and the action1 label remains hidden.
            action1.setVisible(false);
        }

        //Set action2 label

        //Set action3 label

        //Set whether revivePotionUsed label should be visible
        revivePotionUsed.setVisible(state.getRevivePotionUsed());
    }

    private String convertSuitsToFullName(char suit){
        if (suit == 'H'){
            return "Hearts";
        }
        else if (suit == 'S'){
            return  "Spades";
        }
        else if (suit == 'C'){
            return "Clubs";
        }
        else if (suit == 'D'){
            return "Diamonds";
        }
        else {
            return "Joker";
        }
    }

    private String convertCardValues(String value){
        return switch (value) {
            case "1" -> "Ace";
            case "11" -> "Jack";
            case "12" -> "Queen";
            case "13" -> "King";
            default -> value;
        };
    }
}
