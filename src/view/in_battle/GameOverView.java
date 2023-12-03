package view.in_battle;

import interface_adapter.GameOver.GameOverViewModel;
import interface_adapter.GameOver.ReturnToTitleController;
import interface_adapter.GameOver.ReturnToTitlePresenter;
import interface_adapter.TitleScreen.PlayButtonController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GameOverView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "game over";
    private final GameOverViewModel gameOverViewModel;
    private final PlayButtonController playButtonController;
    private final ReturnToTitleController returnToTitleController;
    private final JButton playAgain;
    private final JButton returnToTitle;

    public GameOverView(GameOverViewModel gameOverViewModel, PlayButtonController playButtonController, ReturnToTitleController returnToTitleController) {
        this.gameOverViewModel = gameOverViewModel;
        this.playButtonController = playButtonController;
        this.returnToTitleController = returnToTitleController;

        JLabel title = new JLabel(GameOverViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        playAgain = new JButton(GameOverViewModel.PLAY_AGAIN_LABEL);
        buttons.add(playAgain);
        returnToTitle = new JButton(GameOverViewModel.RETURN_TO_TITLE_LABEL);
        buttons.add(returnToTitle);

        playAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(playAgain)){
                    playButtonController.execute();
                }
            }
        });

        returnToTitle.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(returnToTitle)){
                            returnToTitleController.execute();
                        }
                    }
                }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Don't know if we need this
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //Don't know if we need this
    }
}
