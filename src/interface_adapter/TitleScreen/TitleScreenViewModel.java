package interface_adapter.TitleScreen;

import interface_adapter.ViewModel;
import view.TitleScreenView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TitleScreenViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Title";
    public static final String PLAY_BUTTON_LABEL = "Play";
    public static final String INSTRUCTIONS_BUTTON_LABEL = "Instructions";
    public static final String QUIT_BUTTON_LABEL = "Quit";

    private TitleScreenState state = new TitleScreenState();

    public TitleScreenViewModel(){
        super("title screen");
    }

    public void setState(TitleScreenState state){
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TitleScreenState getState(){
        return state;
    }
}
