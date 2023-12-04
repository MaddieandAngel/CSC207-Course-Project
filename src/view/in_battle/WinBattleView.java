package view.in_battle;

import interface_adapter.WinBattle.WinBattleContinueController;
import interface_adapter.WinBattle.WinBattleState;
import interface_adapter.WinBattle.WinBattleViewModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WinBattleView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "win battle";
    private final WinBattleViewModel winBattleViewModel;
    private final WinBattleContinueController winBattleContinueController;

    private final JButton Continue;
    private final JLabel playerStats;
    private final JLabel levelUp;

    public WinBattleView(WinBattleViewModel winBattleViewModel, WinBattleContinueController winBattleContinueController) {
        this.winBattleViewModel = winBattleViewModel;
        this.winBattleContinueController = winBattleContinueController;

        JLabel title = new JLabel(WinBattleViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Tell player how much exp they gained
        JPanel textBox = new JPanel();
        playerStats = new JLabel("You won! You gained 20 exp!");
        textBox.add(playerStats);

        levelUp = new JLabel("You levelled up!");
        textBox.add(levelUp);
        textBox.setLayout(new BoxLayout(textBox, BoxLayout.Y_AXIS));

        // Create Continue button
        JPanel buttons = new JPanel();
        Continue = new JButton(WinBattleViewModel.CONTINUE_LABEL);
        buttons.add(Continue);

        //Set borders
        Border borders = BorderFactory.createLineBorder(Color.white, 5);
        textBox.setBorder(borders);

        Border buttonBorders = BorderFactory.createLineBorder(Color.white, 3);
        Continue.setBorder(buttonBorders);

        //Set background colours
        Color bg = Color.getHSBColor(0, 0, 0.1F);
        this.setBackground(bg);
        textBox.setBackground(bg);
        Continue.setBackground(bg);

        //Set text colours
        Color text = Color.getHSBColor(0, 0, 0.9F);
        playerStats.setForeground(text);
        Continue.setForeground(text);

        // Only appears when player levels up
        levelUp.setVisible(false);

        Continue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(Continue)){
                    winBattleContinueController.execute();
                }
            }
        });
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        WinBattleState state = winBattleViewModel.getState();

        if (state.isDidPlayerLevelUp()) {
            //Update display for player levelling up
            levelUp.setVisible(true);
        }

    }
}
