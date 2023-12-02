package app;

import interface_adapter.BattleResult.BattleResultViewModel;
import interface_adapter.BattleResult.ContinueButtonController;
import interface_adapter.ViewManagerModel;
import view.in_battle.BattleResultView;

public class BattleResultUseCaseFactory {
    private BattleResultUseCaseFactory(){}

    public static BattleResultView create(ViewManagerModel viewManagerModel, BattleResultViewModel battleResultViewModel){

        //TODO: finish implementation
        ContinueButtonController continueButtonController = createContinueButtonUseCase();

        return new BattleResultView(battleResultViewModel, continueButtonController);
    }

    private static ContinueButtonController createContinueButtonUseCase(){
        //TODO: implement properly
        return new ContinueButtonController();
    }
}
