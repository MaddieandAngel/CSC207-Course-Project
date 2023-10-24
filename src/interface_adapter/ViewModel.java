package interface_adapter;

import java.beans.PropertyChangeListener;

// Just directly copied from the ViewModel.java from the week5ca program. Not sure if we need anything else for it?

public abstract class ViewModel {

    private String viewName;

    public ViewModel(String viewName) {
        this.viewName = viewName;
    }
    public String getViewName() {
        return this.viewName;
    }

    public abstract void firePropertyChanged();
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);


}