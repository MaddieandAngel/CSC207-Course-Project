package use_case.PlayButton;

import view.ExploreView;

public class PlayButtonInteractor implements PlayButtonInputBoundary{
    final PlayButtonOutputBoundary playPresenter;
    final ExploreView exploreView;

    public PlayButtonInteractor(PlayButtonOutputBoundary playPresenter, ExploreView exploreView){
        this.playPresenter = playPresenter;
        this.exploreView = exploreView;
    }

    @Override
    public void execute() {
        // TODO: Call ExploreView

        playPresenter.prepareSuccessView();
    }
}
