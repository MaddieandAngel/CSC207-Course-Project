package interface_adapter.BattleResult;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BattleResultViewModel extends ViewModel {
    private BattleResultState state = new BattleResultState();
    public BattleResultViewModel() {
        super("battle result");
    }

    public void setState(BattleResultState state){this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public BattleResultState getState(){return state;}
}
