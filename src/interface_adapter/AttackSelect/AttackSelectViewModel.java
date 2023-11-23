package interface_adapter.AttackSelect;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AttackSelectViewModel extends ViewModel {

    private AttackSelectState state;

    public AttackSelectViewModel(String viewName) {
        super("Attack Select");
    }

    public void setState(AttackSelectState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public void firePropertyChanged() {
        support.firePropertyChange("Attack Select", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
