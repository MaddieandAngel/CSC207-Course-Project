package app;

import interface_adapter.AttackSelect.AttackSelectViewModel;
import interface_adapter.BattleResult.BattleResultViewModel;
import interface_adapter.ItemSelect.ItemSelectViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.turn_select.*;
import use_case.AttackButton.AttackButtonDataAccessInterface;
import use_case.AttackButton.AttackButtonInputBoundary;
import use_case.AttackButton.AttackButtonInteractor;
import use_case.AttackButton.AttackButtonOutputBoundary;
import use_case.DefendButton.DefendButtonDataAccessInterface;
import use_case.DefendButton.DefendButtonInputBoundary;
import use_case.DefendButton.DefendButtonInteractor;
import use_case.DefendButton.DefendButtonOutputBoundary;
import use_case.DrawButton.DrawButtonDataAccessInterface;
import use_case.DrawButton.DrawButtonInputBoundary;
import use_case.DrawButton.DrawButtonInteractor;
import use_case.DrawButton.DrawButtonOutputBoundary;
import use_case.ItemsButton.ItemsButtonDataAccessInterface;
import use_case.ItemsButton.ItemsButtonInputBoundary;
import use_case.ItemsButton.ItemsButtonInteractor;
import use_case.ItemsButton.ItemsButtonOutputBoundary;
import view.in_battle.TurnSelectView;

public class TurnSelectUseCaseFactory {

    private TurnSelectUseCaseFactory(){}
    public static TurnSelectView create(ViewManagerModel viewManagerModel, AttackSelectViewModel attackSelectViewModel,
                                        TurnSelectViewModel turnSelectViewModel, BattleResultViewModel battleResultViewModel,
                                        ItemSelectViewModel itemSelectViewModel,
                                        AttackButtonDataAccessInterface attackButtonDataAccessInterface,
                                        DrawButtonDataAccessInterface drawButtonDataAccessInterface,
                                        ItemsButtonDataAccessInterface itemsButtonDataAccessInterface,
                                        DefendButtonDataAccessInterface defendButtonDataAccessInterface){

        AttackButtonController attackButtonController = createAttackButtonUseCase(attackSelectViewModel, viewManagerModel,
                attackButtonDataAccessInterface);
        DrawButtonController drawButtonController = createDrawButtonUseCase(battleResultViewModel, turnSelectViewModel,
                viewManagerModel, drawButtonDataAccessInterface);
        ItemsButtonController itemsButtonController = createItemButtonUseCase(itemSelectViewModel, viewManagerModel,
                itemsButtonDataAccessInterface);
        DefendButtonController defendButtonController = createDefendButtonUseCase(battleResultViewModel,viewManagerModel,
                defendButtonDataAccessInterface);
        FleeButtonController fleeButtonController = createFleeButtonUseCase();

        return new TurnSelectView(attackButtonController, drawButtonController, itemsButtonController, defendButtonController,
                fleeButtonController, turnSelectViewModel);
    }

    private static AttackButtonController createAttackButtonUseCase(AttackSelectViewModel attackSelectViewModel,
                                                                    ViewManagerModel viewManagerModel,
                                                                    AttackButtonDataAccessInterface attackButtonDataAccessInterface){

        AttackButtonOutputBoundary attackButtonOutputBoundary = new AttackButtonPresenter(attackSelectViewModel, viewManagerModel);

        AttackButtonInputBoundary attackButtonInteractor = new AttackButtonInteractor(attackButtonOutputBoundary,
                attackButtonDataAccessInterface);

        return new AttackButtonController(attackButtonInteractor);
    }

    private static DrawButtonController createDrawButtonUseCase(BattleResultViewModel battleResultViewModel,
                                                                TurnSelectViewModel turnSelectViewModel,
                                                                ViewManagerModel viewManagerModel,
                                                                DrawButtonDataAccessInterface drawButtonDataAccessInterface){

        DrawButtonOutputBoundary drawButtonOutputBoundary = new DrawButtonPresenter(battleResultViewModel, turnSelectViewModel,
                viewManagerModel);

        DrawButtonInputBoundary drawButtonInteractor = new DrawButtonInteractor(drawButtonOutputBoundary, drawButtonDataAccessInterface);

        return new DrawButtonController(drawButtonInteractor);
    }

    private static ItemsButtonController createItemButtonUseCase(ItemSelectViewModel itemSelectViewModel,
                                                                 ViewManagerModel viewManagerModel,
                                                                 ItemsButtonDataAccessInterface itemsButtonDataAccessInterface){

        ItemsButtonOutputBoundary itemsButtonOutputBoundary = new ItemsButtonPresenter(itemSelectViewModel, viewManagerModel);

        ItemsButtonInputBoundary itemsButtonInteractor = new ItemsButtonInteractor(itemsButtonOutputBoundary,
                itemsButtonDataAccessInterface);

        return new ItemsButtonController(itemsButtonInteractor);
    }

    private static DefendButtonController createDefendButtonUseCase(BattleResultViewModel battleResultViewModel,
                                                                    ViewManagerModel viewManagerModel,
                                                                    DefendButtonDataAccessInterface defendButtonDataAccessInterface){

        DefendButtonOutputBoundary defendButtonOutputBoundary = new DefendButtonPresenter(battleResultViewModel, viewManagerModel);

        DefendButtonInputBoundary defendButtonInteractor = new DefendButtonInteractor(defendButtonOutputBoundary,
                defendButtonDataAccessInterface);

        return new DefendButtonController(defendButtonInteractor);
    }

    private static FleeButtonController createFleeButtonUseCase(){
        //To do: Implement properly or delete once everything related to the flee button is deleted
        return new FleeButtonController();
    }
}
