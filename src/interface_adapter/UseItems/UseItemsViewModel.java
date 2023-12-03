package interface_adapter.UseItems;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UseItemsViewModel extends ViewModel {

    public static final String USE_HEAL10 = "Use HealPotion(10%)";
    public static final String USE_HEAL20 = "Use HealPotion(20%)";
    public static final String USE_HEAL45 = "Use HealPotion(45%)";
    public static final String DROP_HEAL10 = "Drop HealPotion(10%)";
    public static final String DROP_HEAL20 = "Drop HealPotion(20%)";
    public static final String DROP_HEAL45 = "Drop HealPotion(45%)";
    public static final String DROP_REVIVE = "Drop RevivePotion";
    public static final String BACK = "BACK";

    public static final String TITLE_LABEL = "BAG:";
    private UseItemState state = new UseItemState();
    public UseItemsViewModel(){
        super("Package");
    }

    public void setState(UseItemState useItemState){
        this.state = useItemState;
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
    public UseItemState getState(){
        return state;
    }
}
