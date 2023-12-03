package app;

import interface_adapter.AttackSelect.BackButtonController;
import interface_adapter.AttackSelect.BackButtonPresenter;
import interface_adapter.BattleResult.BattleResultViewModel;
import interface_adapter.ItemSelect.HealButtonController;
import interface_adapter.ItemSelect.HealButtonPresenter;
import interface_adapter.ItemSelect.ItemSelectViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.turn_select.TurnSelectViewModel;
import use_case.AttackButton.BackButton.BackButtonDataAccessInterface;
import use_case.AttackButton.BackButton.BackButtonInputBoundary;
import use_case.AttackButton.BackButton.BackButtonInteractor;
import use_case.AttackButton.BackButton.BackButtonOutputBoundary;
import use_case.ItemsButton.HealButton.HealButtonDataAccessInterface;
import use_case.ItemsButton.HealButton.HealButtonInputBoundary;
import use_case.ItemsButton.HealButton.HealButtonInteractor;
import use_case.ItemsButton.HealButton.HealButtonOutputBoundary;
import view.in_battle.ItemSelectionView;

public class ItemSelectionUseCaseFactory {

    private ItemSelectionUseCaseFactory() {}

    public static ItemSelectionView create(BattleResultViewModel battleResultViewModel, ViewManagerModel viewManagerModel,
                                           HealButtonDataAccessInterface healButtonDataAccessInterface, TurnSelectViewModel turnSelectViewModel,
                                           BackButtonDataAccessInterface backButtonDataAccessInterface, ItemSelectViewModel itemSelectViewModel) {
        HealButtonController healButtonController = createUserHealButtonUseCase(battleResultViewModel, viewManagerModel, healButtonDataAccessInterface);
        BackButtonController backButtonController = createUserBackButtonUseCase(turnSelectViewModel, viewManagerModel, backButtonDataAccessInterface);

        return new ItemSelectionView(itemSelectViewModel, healButtonController, backButtonController);
    }

    private static HealButtonController createUserHealButtonUseCase(BattleResultViewModel battleResultViewModel, ViewManagerModel viewManagerModel,
                                                                    HealButtonDataAccessInterface healButtonDataAccessInterface) {
        HealButtonOutputBoundary healButtonOutputBoundary = new HealButtonPresenter(battleResultViewModel, viewManagerModel);

        HealButtonInputBoundary healButtonInteractor = new HealButtonInteractor(healButtonOutputBoundary, healButtonDataAccessInterface);

        return new HealButtonController(healButtonInteractor);
    }

    // Same implementation/controller used for attack use case
    private static BackButtonController createUserBackButtonUseCase(TurnSelectViewModel turnSelectViewModel, ViewManagerModel viewManagerModel, BackButtonDataAccessInterface backButtonDataAccessInterface) {
        BackButtonOutputBoundary backButtonOutputBoundary = new BackButtonPresenter(turnSelectViewModel, viewManagerModel);

        BackButtonInputBoundary backButtonInteractor = new BackButtonInteractor(backButtonOutputBoundary, backButtonDataAccessInterface);

        return new BackButtonController(backButtonInteractor);
    }
}
