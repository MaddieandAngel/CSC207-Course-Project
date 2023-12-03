package view;

import interface_adapter.stairs.NextFloorController;
import interface_adapter.stairs.StairsViewModel;
import interface_adapter.stairs.StayOnFloorController;

import javax.swing.*;
import javax.swing.border.Border;
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

//    private final JLabel playerStats; //Removed for now because the text never gets updated for some reason

    public StairsView(NextFloorController nextFloorControl, StayOnFloorController stayOnFloorControl,
                      StairsViewModel stairsViewModel){
        this.nextFloorController = nextFloorControl;
        this.stayOnFloorController = stayOnFloorControl;
        this.stairsViewModel = stairsViewModel;

        JPanel textBox = new JPanel();
        JLabel textBoxText = new JLabel(stairsViewModel.textbox_text);
        textBox.add(textBoxText);

//        JPanel playerStatsPanel = new JPanel();
//        playerStats = new JLabel("Level: X | Health: X/X | Floor Level: X");
//        playerStatsPanel.add(playerStats);

        JPanel buttons = new JPanel();
        nextFloor = new JButton(stairsViewModel.NEXT_FLOOR_LABEL);
        buttons.add(nextFloor);
        stayOnFloor = new JButton(stairsViewModel.STAY_FLOOR_LABEL);
        buttons.add(stayOnFloor);

        buttons.setLayout(new GridLayout(2, 1, 0, 5));
        textBox.setLayout(new GridBagLayout());

        //Set borders
        Border borders = BorderFactory.createLineBorder(Color.white, 5);
        buttons.setBorder(borders);
        textBox.setBorder(borders);

        Border buttonBorders = BorderFactory.createLineBorder(Color.white, 3);
        nextFloor.setBorder(buttonBorders);
        stayOnFloor.setBorder(buttonBorders);


        //Set background colours
        Color bg = Color.getHSBColor(0, 0, 0.1F);
        this.setBackground(bg);
        buttons.setBackground(bg);
        textBox.setBackground(bg);
        //playerStatsPanel.setBackground(bg);

        nextFloor.setBackground(bg);
        stayOnFloor.setBackground(bg);

        //Set text colours
        Color text = Color.getHSBColor(0, 0, 0.9F);
        textBoxText.setForeground(text);
        //playerStats.setForeground(text);
        nextFloor.setForeground(text);
        stayOnFloor.setForeground(text);

        this.setLayout(new GridBagLayout());
//        this.add(playerStatsPanel, new GridBagConstraints(2, 0, this.getWidth() / 3, this.getHeight() / 5,
//                0.5, 0.5, GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(10, 10, 10 ,10),
//                5, 5));
        this.add(buttons, new GridBagConstraints(2, 1, this.getWidth() / 3, this.getHeight() / 5,
                0.5, 0.5, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(10, 0, 10 ,10),
                50, 20));
        this.add(textBox, new GridBagConstraints(0, 3, this.getWidth() / 3, this.getHeight() / 5,
                0.5, 0.5, GridBagConstraints.PAGE_END, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10 ,10),
                5, 100));

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
//        playerStats.setText("Level: " + stairsViewModel.getState().getPlayerLevel() + " | Health: " +
//                stairsViewModel.getState().getPlayerCurrentHealth() + "/" +
//                stairsViewModel.getState().getPlayerMaxHealth() + " | Floor Level: " +
//                stairsViewModel.getState().getFloorLevel());
    }
}
