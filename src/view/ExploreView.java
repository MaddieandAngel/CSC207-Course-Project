package view;

import interface_adapter.explore.MovementButtonController;
import interface_adapter.explore.SearchButtonController;
import interface_adapter.explore.ExploreState;
import interface_adapter.explore.ExploreViewModel;

import javax.swing.*;
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
    public ExploreView(MovementButtonController move_control, SearchButtonController search_control,
                       ExploreViewModel exploreViewModel){
        this.movementButtonController = move_control;
        this.searchButtonController = search_control;
        this.exploreViewModel = exploreViewModel;
        exploreViewModel.addPropertyChangeListener(this);

        JPanel textbox = new JPanel();
        textbox.add(new JLabel(exploreViewModel.textbox_text));

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

        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS)); //Should give the buttons a vertical layout?
        buttons.setAlignmentX(Component.RIGHT_ALIGNMENT); //Should put the buttons on the right side of the screen?
        buttons.setAlignmentY(Component.CENTER_ALIGNMENT); //Should put the buttons in the center (Y-axis) of the screen?
        // TODO: Figure out how to give the buttons JPanel a border

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
    }
}
