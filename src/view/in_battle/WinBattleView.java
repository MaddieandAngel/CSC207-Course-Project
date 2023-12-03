package view.in_battle;

import interface_adapter.WinBattle.WinBattleContinueController;
import interface_adapter.WinBattle.WinBattleViewModel;

import javax.swing.*;
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
    private final JLabel expGained;

    public WinBattleView(WinBattleViewModel winBattleViewModel, WinBattleContinueController winBattleContinueController) {
        this.winBattleViewModel = winBattleViewModel;
        this.winBattleContinueController = winBattleContinueController;

        JLabel title = new JLabel(WinBattleViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel buttons = new JPanel();
        Continue = new JButton(WinBattleViewModel.CONTINUE_LABEL);
        buttons.add(Continue);

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

    }
}
