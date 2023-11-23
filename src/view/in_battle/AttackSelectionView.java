package view.in_battle;

import interface_adapter.AttackSelect.AttackSelectViewModel;
import interface_adapter.AttackSelect.BackButtonController;
import interface_adapter.AttackSelect.CardButtonController;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

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

    public AttackSelectionView(AttackSelectViewModel attackSelectViewModel, CardButtonController cardButtonController, BackButtonController backButtonController) {
        this.attackSelectViewModel = attackSelectViewModel;
        this.backButtonController = backButtonController;
        this.cardButtonController = cardButtonController;
        attackSelectViewModel.addPropertyChangeListener(this);

        JPanel cardButtons = new JPanel();
        String card1Image = ;// call APIAccess to get image of card1
        card1 = new JButton();

    }

}
