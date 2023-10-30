package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AttackSelectViewModel {

    private AttackSelectState state;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public static String getViewName() {
        return "Attack Select";
    }

    public void firePropertyChanged() {
        support.firePropertyChange("Attack Select", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
