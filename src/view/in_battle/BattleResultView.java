package view.in_battle;

import interface_adapter.BattleResult.BattleResultViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//TODO: Finish implementing

public class BattleResultView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "battle result";
    private final BattleResultViewModel battleResultViewModel;

    public BattleResultView(BattleResultViewModel battleResultViewModel) {
        this.battleResultViewModel = battleResultViewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
