package view;

import interface_adapter.explore.MovementButtonController;
import interface_adapter.explore.SearchButtonController;
import interface_adapter.explore.ExploreViewModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ExploreView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "explore";

    private final ExploreViewModel exploreViewModel;

    private final MovementButtonController movementButtonController;
    private final SearchButtonController searchButtonController;

    private final JButton north;
    private final JButton east;
    private final JButton south;
    private final JButton west;
    private final JButton search;

    private final JLabel playerStats;

    public ExploreView(MovementButtonController moveControl, SearchButtonController searchControl,
                       ExploreViewModel exploreViewModel){
        this.movementButtonController = moveControl;
        this.searchButtonController = searchControl;
        this.exploreViewModel = exploreViewModel;
        exploreViewModel.addPropertyChangeListener(this);

        JPanel textBox = new JPanel();
        JLabel textBoxText = new JLabel(exploreViewModel.TEXTBOX_TEXT);
        textBox.add(textBoxText);

        JPanel playerStatsPanel = new JPanel();
        playerStats = new JLabel("Level: " + exploreViewModel.getState().getPlayerLevel() + " | Health: " +
                exploreViewModel.getState().getPlayerCurrentHealth() + "/" +
                exploreViewModel.getState().getPlayerMaxHealth() + " | Floor Level: " +
                exploreViewModel.getState().getFloorLevel());
        playerStatsPanel.add(playerStats);

        JPanel buttons = new JPanel();
        north = new JButton(exploreViewModel.NORTH_MOVE_LABEL);
        buttons.add(north);
        east = new JButton(exploreViewModel.EAST_MOVE_LABEL);
        buttons.add(east);
        south = new JButton(exploreViewModel.SOUTH_MOVE_LABEL);
        buttons.add(south);
        west = new JButton(exploreViewModel.WEST_MOVE_LABEL);
        buttons.add(west);
        search = new JButton(exploreViewModel.SEARCH_LABEL);
        buttons.add(search);

        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

        //Set borders
        Border borders = BorderFactory.createLineBorder(Color.white, 5);
        buttons.setBorder(borders);
        textBox.setBorder(borders);

        Border buttonBorders = BorderFactory.createLineBorder(Color.white, 3);
        north.setBorder(buttonBorders);
        east.setBorder(buttonBorders);
        south.setBorder(buttonBorders);
        west.setBorder(buttonBorders);
        search.setBorder(buttonBorders);

        //Set background colours
        Color bg = Color.getHSBColor(0, 0, 0.1F);
        this.setBackground(bg);
        buttons.setBackground(bg);
        textBox.setBackground(bg);
        playerStatsPanel.setBackground(bg);

        north.setBackground(bg);
        east.setBackground(bg);
        south.setBackground(bg);
        west.setBackground(bg);
        search.setBackground(bg);

        //Set text colours
        Color text = Color.getHSBColor(0, 0, 0.9F);
        textBoxText.setForeground(text);
        playerStats.setForeground(text);
        north.setForeground(text);
        east.setForeground(text);
        south.setForeground(text);
        west.setForeground(text);
        search.setForeground(text);

        this.setLayout(new GridBagLayout());
        this.add(playerStatsPanel, new GridBagConstraints(3, 0, this.getWidth() / 3, this.getHeight() / 5,
                0.5, 0.5, GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(10, 10, 10 ,10),
                5, 5));
        this.add(buttons, new GridBagConstraints(3, 3, this.getWidth() / 3, this.getHeight() / 5,
                0.5, 0.5, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(10, 10, 10 ,10),
                50, 20));
        this.add(textBox, new GridBagConstraints(0, 4, this.getWidth() / 3, this.getHeight() / 5,
                0.5, 0.5, GridBagConstraints.PAGE_END, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10 ,10),
                5, 100));

        north.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_n) {
                        if (e_n.getSource().equals(north)){
                            movementButtonController.execute("N");
                        }
                    }
                }
        );

        east.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_e) {
                        if (e_e.getSource().equals(east)){
                            movementButtonController.execute("E");
                        }
                    }
                }
        );

        south.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_s) {
                        if (e_s.getSource().equals(south)){
                            movementButtonController.execute("S");
                        }
                    }
                }
        );

        west.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_w) {
                        if (e_w.getSource().equals(west)){
                            movementButtonController.execute("W");
                        }
                    }
                }
        );

        search.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e_search) {
                        if (e_search.getSource().equals(search)){
                            searchButtonController.execute();
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
        north.setVisible(exploreViewModel.getState().isNorthVisible());
        east.setVisible(exploreViewModel.getState().isEastVisible());
        south.setVisible(exploreViewModel.getState().isSouthVisible());
        west.setVisible(exploreViewModel.getState().isWestVisible());
        search.setVisible(exploreViewModel.getState().isSearchVisible());

        playerStats.setText("Level: " + exploreViewModel.getState().getPlayerLevel() + " | Health: " +
                exploreViewModel.getState().getPlayerCurrentHealth() + "/" +
                exploreViewModel.getState().getPlayerMaxHealth() + " | Floor Level: " +
                exploreViewModel.getState().getFloorLevel());
    }
}
