package interface_adapter.DropItems;

import interface_adapter.UseItems.UseItemState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DropItemsViewModel extends ViewModel {

    public static final String DROP_HEAL10 = "Drop HealPotion(10%)";
    public static final String DROP_HEAL20 = "Drop HealPotion(20%)";
    public static final String DROP_HEAL45 = "Drop HealPotion(45%)";
    public static final String DROP_REVIVE = "Drop RevivePotion";

    public static final String TITLE_LABEL = "Your Bag";
    private DropItemState state = new DropItemState();
    public DropItemsViewModel(){
        super("Package");
    }

    public void setState(DropItemState dropItemState){
        this.state = dropItemState;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public DropItemState getState(){
        return state;
    }
}
