package interface_adapter.PickUpItem;

import interface_adapter.UseItems.UseItemState;
import interface_adapter.ViewModel;

import javax.swing.text.View;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PickUpItemViewModel extends ViewModel {
    public final String PICK = "Pick Up";
    public final String DROP_FROM_BAG = "Drop From Bag";
    public final String DROP = "Drop";
    public final String TITLE_LABEL = "Pick Up Item";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private PickUpItemState state = new PickUpItemState();

    public PickUpItemViewModel() {
        super("Pick up item");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public PickUpItemState getState(){
        return state;
    }
    public void setState(PickUpItemState pickUpItemState){this.state = state;}
}
