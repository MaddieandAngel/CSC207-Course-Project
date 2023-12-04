package interface_adapter.WinBattle;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WinBattleViewModel extends ViewModel {
    public static final String CONTINUE_LABEL = "Continue";
    public static final String TITLE_LABEL = "Battle Results";
    private WinBattleState state = new WinBattleState();

    public WinBattleViewModel() {
        super("win battle");
    }
    public void setState(WinBattleState state){this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public WinBattleState getState(){return state;}
}
