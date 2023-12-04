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
import java.io.IOException;

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
        buttonAndPlayerCard.add(playerCard);
        JButton continueButton = new JButton(battleResultViewModel.CONTINUE_LABEL);
        buttonAndPlayerCard.add(continueButton);

        buttonAndPlayerCard.setLayout(new BoxLayout(buttonAndPlayerCard, BoxLayout.Y_AXIS));

        JPanel playerStatsPanel = new JPanel();
        playerStats = new JLabel("Level: X | Health: X/X");
        playerStatsPanel.add(playerStats);

        JPanel textBox = new JPanel();
        action1 = new JLabel("Placeholder text for turn action 1 (if applicable)");
        textBox.add(action1);
        action2 = new JLabel("Placeholder text for turn action 2");
        textBox.add(action2);
        action3 = new JLabel("Placeholder text for turn action 3");
        textBox.add(action3);
        revivePotionUsed = new JLabel("Player's HP fell to 0! Player used Revive Potion!");
        textBox.add(revivePotionUsed);

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
        this.add(enemyCard, new GridBagConstraints(0, 1, this.getWidth() / 3, this.getHeight() / 5,
                0.5, 0.5, GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(10, 10, 10 ,10), 5, 5));
        this.add(playerStatsPanel, new GridBagConstraints(2, 0, this.getWidth() / 3, this.getHeight() / 5,
                0.5, 0.5, GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(10, 10, 10 ,10),
                5, 5));
        this.add(buttonAndPlayerCard, new GridBagConstraints(2, 1, this.getWidth() / 3, this.getHeight() / 5,
                0.5, 0.5, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(10, 0, 10 ,10),
                50, 45));
        this.add(textBox, new GridBagConstraints(0, 3, this.getWidth() / 3, this.getHeight() / 5,
                0.5, 0.5, GridBagConstraints.PAGE_END, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10 ,10),
                5, 90));
        JButton update = new JButton("Update");
        buttonAndPlayerCard.add(update);

        update.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BattleResultState state = battleResultViewModel.getState();

                        //Update display for player's health
                        playerStats.setText("Level: " + state.getPlayerLevel() + " | Health: " +
                                state.getPlayerCurrentHealth() + "/" +
                                state.getPlayerMaxHealth());

                        System.out.println(state.getPlayerMaxHealth());

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
                        if (state.getDamageBonus().equals("player")){ //Player dealt bonus damage this turn
                            action1.setText("Player's " + playerCardName + " is super effective against enemy's " + enemyCardName + "!");
                            action1.setVisible(true);
                        }
                        else if (state.getDamageBonus().equals("enemy")){ //Enemy dealt bonus damage this turn
                            action1.setText("Enemy's " + enemyCardName + " is super effective against player's " + playerCardName + "!");
                            action1.setVisible(true);
                        }
                        else { //Otherwise, no bonus damage was dealt this turn and the action1 label remains hidden.
                            action1.setVisible(false);
                        }

                        //Set the action2 and action3 labels:

                        //The player attacking has the second lowest textbox priority. Unless the enemy also attacks, it will be shown in the action3 label.
                        //If the enemy attacks, the text for the player's attack will be shown in the action2 label instead.
                        //The player's non-attacking actions have the highest priority and will always be shown in the action2 label
                        if (state.getPlayerAction().equals("attack") && !(state.getEnemyAction().equals("attack"))){
                            setTextForPlayerAction(state, action3, playerCardName);
                        }
                        else{
                            setTextForPlayerAction(state, action2, playerCardName);
                        }

                        //The enemy attacking always has the lowest priority. It will always be shown in the action3 label
                        //Enemy actions that are not attacking will be shown in the action2 label if the player attacked, otherwise in the action3 label
                        if (state.getEnemyAction().equals("attack") || !(state.getPlayerAction().equals("attack"))){
                            setTextForEnemyAction(state, action3, enemyCardName);
                        }
                        else{
                            setTextForEnemyAction(state, action2, enemyCardName);
                        }

                        //Set whether revivePotionUsed label should be visible
                        revivePotionUsed.setVisible(state.getRevivePotionUsed());
                    }

                    private String convertSuitsToFullName(char suit){
                        return switch (suit) {
                            case 'H' -> "Hearts";
                            case 'S' -> "Spades";
                            case 'C' -> "Clubs";
                            case 'D' -> "Diamonds";
                            default -> "Joker";
                        };
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

                    private void setTextForPlayerAction(BattleResultState state, JLabel textBoxLine, String playerCardName){
                        switch (state.getPlayerAction()) {
                            case "attack" -> textBoxLine.setText("Player attacks with " + playerCardName + "! Deals " +
                                    state.getDamageToEnemy() + " damage!");
                            case "draw" -> textBoxLine.setText("Player drew the " + playerCardName + "!");
                            case "defend" -> textBoxLine.setText("Player defended!");
                            default ->  //Player used an item
                                //TODO: edit this text to include the specific name of the item that was used
                                    textBoxLine.setText("Player used a Healing Potion!");
                        }
                    }

                    private void setTextForEnemyAction(BattleResultState state, JLabel textBoxLine, String enemyCardName){
                        switch (state.getEnemyAction()){
                            case "attack" -> textBoxLine.setText(state.getEnemyName() + " attacks with " + enemyCardName + "! Deals " +
                                    state.getDamageToPlayer() + " damage!");
                            case "draw" -> textBoxLine.setText(state.getEnemyName() + " drew a card!");
                            case "defend" -> textBoxLine.setText(state.getEnemyName() + " defended!");
                        }

                    }
                }
        );


        continueButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            continueController.execute();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
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
        if (state.getDamageBonus().equals("player")){ //Player dealt bonus damage this turn
            action1.setText("Player's " + playerCardName + " is super effective against enemy's " + enemyCardName + "!");
            action1.setVisible(true);
        }
        else if (state.getDamageBonus().equals("enemy")){ //Enemy dealt bonus damage this turn
            action1.setText("Enemy's " + enemyCardName + " is super effective against player's " + playerCardName + "!");
            action1.setVisible(true);
        }
        else { //Otherwise, no bonus damage was dealt this turn and the action1 label remains hidden.
            action1.setVisible(false);
        }

        //Set the action2 and action3 labels:

        //The player attacking has the second lowest textbox priority. Unless the enemy also attacks, it will be shown in the action3 label.
        //If the enemy attacks, the text for the player's attack will be shown in the action2 label instead.
        //The player's non-attacking actions have the highest priority and will always be shown in the action2 label
        if (state.getPlayerAction().equals("attack") && !(state.getEnemyAction().equals("attack"))){
            setTextForPlayerAction(state, action3, playerCardName);
        }
        else{
            setTextForPlayerAction(state, action2, playerCardName);
        }

        //The enemy attacking always has the lowest priority. It will always be shown in the action3 label
        //Enemy actions that are not attacking will be shown in the action2 label if the player attacked, otherwise in the action3 label
        if (state.getEnemyAction().equals("attack") || !(state.getPlayerAction().equals("attack"))){
            setTextForEnemyAction(state, action3, enemyCardName);
        }
        else{
            setTextForEnemyAction(state, action2, enemyCardName);
        }

        //Set whether revivePotionUsed label should be visible
        revivePotionUsed.setVisible(state.getRevivePotionUsed());
    }

    private String convertSuitsToFullName(char suit){
        return switch (suit) {
            case 'H' -> "Hearts";
            case 'S' -> "Spades";
            case 'C' -> "Clubs";
            case 'D' -> "Diamonds";
            default -> "Joker";
        };
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

    private void setTextForPlayerAction(BattleResultState state, JLabel textBoxLine, String playerCardName){
        switch (state.getPlayerAction()) {
            case "attack" -> textBoxLine.setText("Player attacks with " + playerCardName + "! Deals " +
                    state.getDamageToEnemy() + " damage!");
            case "draw" -> textBoxLine.setText("Player drew the " + playerCardName + "!");
            case "defend" -> textBoxLine.setText("Player defended!");
            default ->  //Player used an item
                //TODO: edit this text to include the specific name of the item that was used
                    textBoxLine.setText("Player used a Healing Potion!");
        }
    }

    private void setTextForEnemyAction(BattleResultState state, JLabel textBoxLine, String enemyCardName){
        switch (state.getEnemyAction()){
            case "attack" -> textBoxLine.setText(state.getEnemyName() + " attacks with " + enemyCardName + "! Deals " +
                    state.getDamageToPlayer() + " damage!");
            case "draw" -> textBoxLine.setText(state.getEnemyName() + " drew a card!");
            case "defend" -> textBoxLine.setText(state.getEnemyName() + " defended!");
        }

    }
}
