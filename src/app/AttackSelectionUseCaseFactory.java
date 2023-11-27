package app;

import entity.Enemy;
import entity.Player;
import interface_adapter.APIAccessInterface;
import interface_adapter.AttackSelect.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.turn_select.TurnSelectViewModel;
import use_case.AttackButton.BackButton.BackButtonInputBoundary;
import use_case.AttackButton.BackButton.BackButtonInteractor;
import use_case.AttackButton.BackButton.BackButtonOutputBoundary;
import use_case.AttackButton.CardButton.CardButtonInputBoundary;
import use_case.AttackButton.CardButton.CardButtonInteractor;
import use_case.AttackButton.CardButton.CardButtonOutputBoundary;
import view.in_battle.AttackSelectionView;
import view.in_battle.BattleResultView;

public class AttackSelectionUseCaseFactory {

    private AttackSelectionUseCaseFactory() {}

    public static AttackSelectionView create(ViewManagerModel viewManagerModel, AttackSelectViewModel attackSelectViewModel,
                                             BattleResultView battleResultView, TurnSelectViewModel turnSelectViewModel,
                                             APIAccessInterface api, Player player, Enemy currentEnemy) {
        CardButtonController cardButtonController = createUserCardButtonUseCase(battleResultView, viewManagerModel);
        BackButtonController backButtonController = createUserBackButtonUseCase(turnSelectViewModel, viewManagerModel);

        return new AttackSelectionView(attackSelectViewModel, cardButtonController, backButtonController, api, player, currentEnemy);
    }

    private static CardButtonController createUserCardButtonUseCase(BattleResultView battleResultView, ViewManagerModel viewManagerModel) {
        CardButtonOutputBoundary cardButtonOutputBoundary = new CardButtonPresenter(battleResultView, viewManagerModel);

        CardButtonInputBoundary cardButtonInteractor = new CardButtonInteractor(cardButtonOutputBoundary);

        return new CardButtonController(cardButtonInteractor);
    }

    private static BackButtonController createUserBackButtonUseCase(TurnSelectViewModel turnSelectViewModel, ViewManagerModel viewManagerModel) {
        BackButtonOutputBoundary backButtonOutputBoundary = new BackButtonPresenter(turnSelectViewModel, viewManagerModel);

        BackButtonInputBoundary backButtonInteractor = new BackButtonInteractor(backButtonOutputBoundary);

        return new BackButtonController(backButtonInteractor);
    }
}
