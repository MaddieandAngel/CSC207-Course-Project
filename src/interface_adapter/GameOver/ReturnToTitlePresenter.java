package interface_adapter.GameOver;

import interface_adapter.TitleScreen.TitleScreenViewModel;
import interface_adapter.ViewManagerModel;
import use_case.ReturnToTitleButton.ReturnToTitleOutputBoundary;

public class ReturnToTitlePresenter implements ReturnToTitleOutputBoundary {
    private final TitleScreenViewModel titleScreenViewModel;
    private final ViewManagerModel viewManagerModel;

    public ReturnToTitlePresenter(TitleScreenViewModel titleScreenViewModel, ViewManagerModel viewManagerModel) {
        this.titleScreenViewModel = titleScreenViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(){
        viewManagerModel.setActiveView(titleScreenViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
