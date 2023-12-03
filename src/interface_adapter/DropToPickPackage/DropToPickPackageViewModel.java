package interface_adapter.DropToPickPackage;

import interface_adapter.DropItems.DropItemState;
import interface_adapter.PickUpItem.PickUpItemState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DropToPickPackageViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Drop An Item!";
    public static final String DROP_HEAL10 = "Drop HealPotion(10%)";
    public static final String DROP_HEAL20 = "Drop HealPotion(20%)";
    public static final String DROP_HEAL45 = "Drop HealPotion(45%)";
    public static final String DROP_REVIVE = "Drop RevivePotion";
    public static final String BACK = "Back";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private DropToPickPackageState state = new DropToPickPackageState();

    public DropToPickPackageViewModel() {
        super("Drop to Pick Package");
    }
    public void setState(DropToPickPackageState dropToPickPackageState){
        this.state = dropToPickPackageState;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public DropToPickPackageState getState(){
        return state;
    }
}
