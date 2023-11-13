package use_case.PlayButton;

public class PlayButtonInteractor implements PlayButtonInputBoundary{
    final PlayButtonInputBoundary playPresenter;

    public PlayButtonInteractor(PlayButtonInputBoundary playPresenter){
        this.playPresenter = playPresenter;
    }

    @Override
    public void execute() {
        playPresenter.prepareFailView();
    }
}
