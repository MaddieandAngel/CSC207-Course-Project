package interface_adapter.stairs;

import interface_adapter.ViewModel;
import interface_adapter.explore.ExploreState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class StairsViewModel extends ViewModel {

    public final String NEXT_FLOOR_LABEL = "Yes";
    public final String STAY_FLOOR_LABEL = "No";
    public String textbox_text = "You've found the stairs! Continue to the next floor?";

    private ExploreState state = new ExploreState();

    public StairsViewModel(){
        super("found_stairs");
    }

    public void setState(ExploreState state){
        this.state = state;
    }

    public ExploreState getState() {
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
