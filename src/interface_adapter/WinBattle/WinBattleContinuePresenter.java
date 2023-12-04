package interface_adapter.WinBattle;

import interface_adapter.ViewManagerModel;
import interface_adapter.explore.ExploreButtonVisibility;
import interface_adapter.explore.ExploreState;
import interface_adapter.explore.ExploreViewModel;
import use_case.WinBattleContinueButton.WinBattleContinueOutputBoundary;
import use_case.movement.MovementOutputData;

public class WinBattleContinuePresenter implements WinBattleContinueOutputBoundary {
    private final ExploreViewModel exploreViewModel;
    private final WinBattleViewModel winBattleViewModel;
    private final ViewManagerModel viewManagerModel;

    public WinBattleContinuePresenter(ExploreViewModel exploreViewModel, WinBattleViewModel winBattleViewModel, ViewManagerModel viewManagerModel) {
        this.exploreViewModel = exploreViewModel;
        this.winBattleViewModel = winBattleViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(MovementOutputData movementOutputData) {
        ExploreState state = exploreViewModel.getState();
        exploreViewModel.setState(ExploreButtonVisibility.setButtonVisibility(state, movementOutputData));
        viewManagerModel.setActiveView(exploreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
