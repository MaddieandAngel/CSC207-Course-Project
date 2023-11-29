package interface_adapter.turn_select;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TurnSelectViewModel extends ViewModel {

    public static final String ATTACK_BUTTON_LABEL = "Attack";
    public static final String DRAW_BUTTON_LABEL = "Draw";
    public static final String ITEMS_BUTTON_LABEL = "Items"; // Can be removed if we can't implement this
    public static final String DEFEND_BUTTON_LABEL = "Defend";
    public static final String FLEE_BUTTON_LABEL = "Flee";

    private TurnSelectState state = new TurnSelectState();

    public TurnSelectViewModel() {
        super("turn select");
    }

    public void setState(TurnSelectState state) {
        this.state = state;
    }
    public TurnSelectState getState() {
        return state;
    }

    // Copied the below from week5ca:

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
