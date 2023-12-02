package interface_adapter.explore;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ExploreViewModel extends ViewModel {

    public final String NORTH_MOVE_LABEL = "Go North";
    public final String EAST_MOVE_LABEL = "Go East";
    public final String SOUTH_MOVE_LABEL = "Go South";
    public final String WEST_MOVE_LABEL = "Go West";
    public final String SEARCH_LABEL = "Search Room";
    public final String BAG = "Bag";
    public String textbox_text = "There's nothing here.";

    private ExploreState state = new ExploreState();

    public ExploreViewModel() {
        super("explore");
    }

    public void setState(ExploreState state) {
        this.state = state;
    }

    public ExploreState getState(){
        return state;
    }

    //

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
