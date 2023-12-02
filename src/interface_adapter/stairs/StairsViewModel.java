package interface_adapter.stairs;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class StairsViewModel extends ViewModel {

    public final String NEXT_FLOOR_LABEL = "Yes";
    public final String STAY_FLOOR_LABEL = "No";
    public String textbox_text = "You've found the stairs! Continue to the next floor?";

    private StairsState state = new StairsState();

    public StairsViewModel(){
        super("found_stairs");
    }

    public void setState(StairsState state){
        this.state = state;
    }

    public StairsState getState() {
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
