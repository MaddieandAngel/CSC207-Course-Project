package interface_adapter.TitleScreen;

import use_case.PlayButton.PlayButtonInputBoundary;

public class PlayButtonController {
    final PlayButtonInputBoundary playButtonInputBoundary;

    public PlayButtonController(PlayButtonInputBoundary playButtonInputBoundary){
        this.playButtonInputBoundary = playButtonInputBoundary;
    }

    public void execute(){
        playButtonInputBoundary.execute();
    }
}
