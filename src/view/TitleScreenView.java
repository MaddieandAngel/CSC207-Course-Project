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
                            JOptionPane.showMessageDialog(null, "Move through different rooms " +
                                    "by clicking the north, east south or west buttons. In each new room you explore, you " +
                                    "have a chance of encountering an enemy and will then go into Battle Mode if you encounter one. To attack an enemy, " +
                                    "press 'Attack' and place a card from your hand. The higher the card number, the more " +
                                    "damage is done to the enemy. You can also press 'Defend' which will reduce the Enemy's attack by " +
                                    "50%, or you can press 'Flee', but there is a chance that you might not be able to leav the battle. \nIf you lose it's Game Over, but " +
                                    "for every battle you win, you will earn XP which can raise your player level and your max health and will be able to continue exploring." +
                                    "\nYou also may come across items in some rooms, like revive potions," +
                                    "which will help you in battle.\nWhen you find a set of stairs, you can move to the next floor which will have new enemies."
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
