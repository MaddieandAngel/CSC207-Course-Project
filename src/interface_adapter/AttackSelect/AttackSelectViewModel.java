package interface_adapter.AttackSelect;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AttackSelectViewModel extends ViewModel {

    private AttackSelectState state = new AttackSelectState();

    public AttackSelectViewModel() {
        super("Attack Select");
    }

    public void setState(AttackSelectState state) {
        this.state = state;
    }

    public AttackSelectState getState() {return this.state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public void firePropertyChanged() {
        support.firePropertyChange("Attack Select", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
