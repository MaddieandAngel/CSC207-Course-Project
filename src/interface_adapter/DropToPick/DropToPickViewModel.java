package interface_adapter.DropToPick;

import interface_adapter.PickUpItem.PickUpItemState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DropToPickViewModel extends ViewModel {
    public DropToPickViewModel() {
        super("Pick up item");
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private DropToPickState state = new DropToPickState();

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
