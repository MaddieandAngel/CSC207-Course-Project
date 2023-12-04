package view;

import interface_adapter.TitleScreen.PlayButtonController;
import interface_adapter.TitleScreen.TitleScreenState;
import interface_adapter.TitleScreen.TitleScreenViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TitleScreenView extends JPanel implements ActionListener, PropertyChangeListener{
    public String viewName = "title screen";
    private  final TitleScreenViewModel titleScreenViewModel;
    private final PlayButtonController playButtonController;
    private final JButton play;
    private final JButton instructions;

    public TitleScreenView(TitleScreenViewModel titleScreenViewModel, PlayButtonController playButtonController){
        this.titleScreenViewModel = titleScreenViewModel;
        this.playButtonController = playButtonController;
        titleScreenViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(TitleScreenViewModel.TITLE_LABEL);
        // Places title somewhere on the screen
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        play = new JButton(TitleScreenViewModel.PLAY_BUTTON_LABEL);
        buttons.add(play);
        instructions = new JButton(TitleScreenViewModel.INSTRUCTIONS_BUTTON_LABEL);
        buttons.add(instructions);

        play.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(play)){
                            TitleScreenState currentState = titleScreenViewModel.getState();
                            playButtonController.execute();

                        }
                    }
                }
        );

        instructions.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(instructions)){
                            JOptionPane.showMessageDialog(null, """
                                    Move through different rooms by clicking the north, east south or west buttons.\s
                                    In each new room you explore, you have a chance of encountering an enemy and will\s
                                    then go into Battle Mode if you encounter one. There are four things you can do on your
                                    turn in battle: attack, defend, draw a card, and use a potion. To attack an enemy, press 'Attack'\s
                                    and place a card from your hand. The higher the card number, the more damage is done
                                     to the enemy, you can deal more damage if you place suits that are strong than your enemy's card suit. \s
                                      \n Spades beats Hearts \n Hearts beats Clubs \n Clubs beats Diamonds \n Diamonds beats Spades \s
                                      \n You can also place a Joker, which will take on any value between 0 - 15.
                                      \nTo defend, press 'Defend' which will reduce the Enemy's attack by 50%. To draw a random card and add it to \s
                                     your hand, press 'Draw'. To use a healing item if you have any, press 'Items' and choose one of your items. \s
                                     \nIf you lose it's Game Over, but for every battle you win,
                                      you will earn XP which can raise your player level and your max health and will be\s
                                      able to continue exploring. You also may come across items in some rooms, like revive\s
                                      potions,which will help you in battle. When you find a set of stairs, you can move\s
                                      to the next floor which will have new enemies."""
                            );
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "IDK what this is for.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TitleScreenState state = (TitleScreenState) evt.getNewValue();
        if (state.getPlayError() != null){
            JOptionPane.showMessageDialog(this, state.getPlayError());
        }
    }
}
