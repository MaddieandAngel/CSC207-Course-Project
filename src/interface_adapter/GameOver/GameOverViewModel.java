package interface_adapter.GameOver;

import interface_adapter.ViewModel;

import javax.swing.text.View;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GameOverViewModel extends ViewModel{
    public static final String PLAY_AGAIN_LABEL = "Play Again";
    public static final String RETURN_TO_TITLE_LABEL = "Return to Title Screen";
    public static final String TITLE_LABEL = "GAME OVER!";
    private GameOverState state = new GameOverState();

    public GameOverViewModel() {
        super("game over");
    }
    public void setState(GameOverState state){this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public GameOverState getState(){return state;}
}
