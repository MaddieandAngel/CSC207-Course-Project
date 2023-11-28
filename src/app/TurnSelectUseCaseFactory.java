package app;

import interface_adapter.AttackSelect.AttackSelectViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.turn_select.*;
import use_case.AttackButton.AttackButtonInputBoundary;
import use_case.AttackButton.AttackButtonInteractor;
import use_case.AttackButton.AttackButtonOutputBoundary;
import use_case.DefendButton.DefendButtonInputBoundary;
import use_case.DefendButton.DefendButtonInteractor;
import use_case.DefendButton.DefendButtonOutputBoundary;
import view.in_battle.TurnSelectView;

public class TurnSelectUseCaseFactory {

    private TurnSelectUseCaseFactory(){}
    //TODO: Commented out for now until the DefendButtonPresenter is implemented
//    public static TurnSelectView create(ViewManagerModel viewManagerModel, AttackSelectViewModel attackSelectViewModel,
//                                        TurnSelectViewModel turnSelectViewModel){
//
//        AttackButtonController attackButtonController = createAttackButtonUseCase(attackSelectViewModel, viewManagerModel);
//        DrawButtonController drawButtonController = createDrawButtonUseCase();
//        ItemsButtonController itemsButtonController = createItemButtonUseCase();
//        DefendButtonController defendButtonController = createDefendButtonUseCase();
//        FleeButtonController fleeButtonController = createFleeButtonUseCase();
//
//        return new TurnSelectView(attackButtonController, drawButtonController, itemsButtonController, defendButtonController,
//                fleeButtonController, turnSelectViewModel);
//    }
//
//    private static AttackButtonController createAttackButtonUseCase(AttackSelectViewModel attackSelectViewModel,
//                                                                    ViewManagerModel viewManagerModel){
//
//        AttackButtonOutputBoundary attackButtonOutputBoundary = new AttackButtonPresenter(attackSelectViewModel, viewManagerModel);
//
//        AttackButtonInputBoundary attackButtonInteractor = new AttackButtonInteractor(attackButtonOutputBoundary);
//
//        return new AttackButtonController(attackButtonInteractor);
//    }
//
//    private static DrawButtonController createDrawButtonUseCase(){
//        //TODO: Implement properly
//        return new DrawButtonController();
//    }
//
//    private static ItemsButtonController createItemButtonUseCase(){
//        //TODO: implement properly
//        return new ItemsButtonController();
//    }
//
//    private static DefendButtonController createDefendButtonUseCase(){
//        //TODO: implement fully
//        DefendButtonOutputBoundary defendButtonOutputBoundary = new DefendButtonPresenter();
//
//        DefendButtonInputBoundary defendButtonInteractor = new DefendButtonInteractor(defendButtonOutputBoundary);
//        return new DefendButtonController(defendButtonInteractor);
//    }
//
//    private static FleeButtonController createFleeButtonUseCase(){
//        //TODO: implement properly or delete once everything related to the flee button is deleted
//        return new FleeButtonController();
//    }
}
