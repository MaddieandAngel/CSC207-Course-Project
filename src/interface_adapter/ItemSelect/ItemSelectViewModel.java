package interface_adapter.ItemSelect;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ItemSelectViewModel extends ViewModel {

    private ItemSelectState state;

    public ItemSelectViewModel() { super("Item Select");}

    public void setState(ItemSelectState state) { this.state = state;}

    public ItemSelectState getState() { return this.state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() { support.firePropertyChange("Item Select", null, this.state);}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
