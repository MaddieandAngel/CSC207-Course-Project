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

    public StairsView(NextFloorController nextFloorController, StayOnFloorController stayOnFloorController,
                      StairsViewModel stairsViewModel){
        this.nextFloorController = nextFloorController;
        this.stayOnFloorController = stayOnFloorController;
        this.stairsViewModel = stairsViewModel;

        JPanel textbox = new JPanel();
        textbox.add(new JLabel(stairsViewModel.textbox_text));

        JPanel buttons = new JPanel();
        nextFloor = new JButton(stairsViewModel.NEXT_FLOOR_LABEL);
        buttons.add(nextFloor);
        stayOnFloor = new JButton(stairsViewModel.STAY_FLOOR_LABEL);
        buttons.add(stayOnFloor);

        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS)); //Should give the buttons a vertical layout?
        buttons.setAlignmentX(Component.RIGHT_ALIGNMENT); //Should put the buttons on the right side of the screen?
        buttons.setAlignmentY(Component.CENTER_ALIGNMENT); //Should put the buttons in the center (Y-axis) of the screen?
        // TODO: Figure out how to give the buttons JPanel a border

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

    }
}
