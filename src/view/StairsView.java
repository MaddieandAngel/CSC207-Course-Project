package view;

import interface_adapter.stairs.NextFloorController;
import interface_adapter.stairs.StairsViewModel;
import interface_adapter.stairs.StayOnFloorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class StairsView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "found_stairs";

    private final StairsViewModel stairsViewModel;

    private final NextFloorController nextFloorController;
    private final StayOnFloorController stayOnFloorController;

    private final JButton nextFloor;
    private final JButton stayOnFloor;

    private final JLabel playerStats;

    public StairsView(NextFloorController nextFloorControl, StayOnFloorController stayOnFloorControl,
                      StairsViewModel stairsViewModel){
        this.nextFloorController = nextFloorControl;
        this.stayOnFloorController = stayOnFloorControl;
        this.stairsViewModel = stairsViewModel;

        JPanel textBox = new JPanel();
        textBox.add(new JLabel(stairsViewModel.textbox_text));

        JPanel playerStatsPanel = new JPanel();
        playerStats = new JLabel("Level: X | Health: X/X | Floor Level: X");
        playerStatsPanel.add(playerStats);

        JPanel buttons = new JPanel();
        nextFloor = new JButton(stairsViewModel.NEXT_FLOOR_LABEL);
        buttons.add(nextFloor);
        stayOnFloor = new JButton(stairsViewModel.STAY_FLOOR_LABEL);
        buttons.add(stayOnFloor);

        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS)); //Should give the buttons a vertical layout?
        // TODO: Figure out how to give the buttons JPanel a border

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(playerStatsPanel);
        this.add(textBox);
        this.add(buttons);

        nextFloor.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_yes) {
                        if (e_yes.getSource().equals(nextFloor)){
                            nextFloorController.execute();
                        }
                    }
                }
        );

        stayOnFloor.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_stay) {
                        if (e_stay.getSource().equals(stayOnFloor)){
                            stayOnFloorController.execute();
                        }
                    }
                }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Unneeded?
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        playerStats.setText("Level: " + stairsViewModel.getState().getPlayerLevel() + " | Health: " +
                stairsViewModel.getState().getPlayerCurrentHealth() + "/" +
                stairsViewModel.getState().getPlayerMaxHealth() + " | Floor Level: " +
                stairsViewModel.getState().getFloorLevel());
    }
}
