package app;

import data_access.ExploreDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.WinBattle.WinBattleContinueController;
import interface_adapter.WinBattle.WinBattleContinuePresenter;
import interface_adapter.WinBattle.WinBattleViewModel;
import interface_adapter.explore.ExploreViewModel;
import use_case.WinBattleContinueButton.WinBattleContinueInputBoundary;
import use_case.WinBattleContinueButton.WinBattleContinueInteractor;
import use_case.WinBattleContinueButton.WinBattleContinueOutputBoundary;
import view.in_battle.WinBattleView;

public class WinBattleUseCaseFactory {
    private WinBattleUseCaseFactory(){}
    public static WinBattleView create(ViewManagerModel viewManagerModel, WinBattleViewModel winBattleViewModel, ExploreViewModel exploreViewModel, ExploreDataAccessObject exploreDataAccessObject){
        WinBattleContinueController winBattleContinueController = createWinBattleContinueUseCase(viewManagerModel, winBattleViewModel, exploreViewModel, exploreDataAccessObject);
        return new WinBattleView(winBattleViewModel, winBattleContinueController);
    }
    private static WinBattleContinueController createWinBattleContinueUseCase(ViewManagerModel viewManagerModel,
                                                                              WinBattleViewModel winBattleViewModel, ExploreViewModel exploreViewModel, ExploreDataAccessObject exploreDataAccessObject){
        WinBattleContinueOutputBoundary winBattleContinueOutputBoundary = new WinBattleContinuePresenter(exploreViewModel, winBattleViewModel, viewManagerModel);
        WinBattleContinueInputBoundary winBattleContinueInputBoundary = new WinBattleContinueInteractor(winBattleContinueOutputBoundary, exploreDataAccessObject);
        return new WinBattleContinueController(winBattleContinueInputBoundary);
    }
}
