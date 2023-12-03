package app;

import interface_adapter.BattleResult.BattleResultViewModel;
import interface_adapter.BattleResult.ContinueButtonController;
import interface_adapter.BattleResult.ContinueButtonPresenter;
import interface_adapter.GameOver.GameOverViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.WinBattle.WinBattleViewModel;
import interface_adapter.turn_select.TurnSelectViewModel;
import use_case.BattleResultContinueButton.BattleResultContinueInputBoundary;
import use_case.BattleResultContinueButton.BattleResultContinueInteractor;
import use_case.BattleResultContinueButton.BattleResultContinueOutputBoundary;
import view.in_battle.BattleResultView;

public class BattleResultUseCaseFactory {
    private BattleResultUseCaseFactory(){}

    public static BattleResultView create(ViewManagerModel viewManagerModel, BattleResultViewModel battleResultViewModel,
                                          TurnSelectViewModel turnSelectViewModel, GameOverViewModel gameOverViewModel,
                                          WinBattleViewModel winBattleViewModel){

        ContinueButtonController continueButtonController = createContinueButtonUseCase(viewManagerModel, battleResultViewModel,
                turnSelectViewModel, gameOverViewModel, winBattleViewModel);

        return new BattleResultView(battleResultViewModel, continueButtonController);
    }

    private static ContinueButtonController createContinueButtonUseCase(ViewManagerModel viewManagerModel, BattleResultViewModel battleResultViewModel,
                                                                        TurnSelectViewModel turnSelectViewModel, GameOverViewModel gameOverViewModel,
                                                                        WinBattleViewModel winBattleViewModel){

        BattleResultContinueOutputBoundary battleResultContinueOutputBoundary = new ContinueButtonPresenter(turnSelectViewModel,
                battleResultViewModel, gameOverViewModel, winBattleViewModel, viewManagerModel);
        BattleResultContinueInputBoundary battleResultContinueInteractor = new BattleResultContinueInteractor(battleResultContinueOutputBoundary);
        return new ContinueButtonController(battleResultContinueInteractor);
    }
}
