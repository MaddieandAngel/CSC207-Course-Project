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
    private final String viewName = "title screen";
    private  final TitleScreenViewModel titleScreenViewModel;
    private final PlayButtonController playButtonController;
    private final JButton play;
    private final JButton instructions;
//    private final JButton quit;

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
//        quit = new JButton(TitleScreenViewModel.PLAY_BUTTON_LABEL);
//        buttons.add(play);

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
                            JOptionPane.showMessageDialog(null, "Put Instructions Here!!!");
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
