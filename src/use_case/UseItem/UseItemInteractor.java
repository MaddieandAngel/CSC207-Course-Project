package use_case.UseItem;

import data_access.InBattleDataAccessObject;

public class UseItemInteractor implements UseItemInputBoundary{
    final UseItemDataAccessInterface userItemDataAccessObject;
    final UseItemOutputBoundary useItemPresenter;
    final InBattleDataAccessObject inBattleDataAccessObject;

    public UseItemInteractor(UseItemDataAccessInterface userItemDataAccessObject, UseItemOutputBoundary useItemPresenter, InBattleDataAccessObject inBattleDataAccessObject) {
        this.userItemDataAccessObject = userItemDataAccessObject;
        this.useItemPresenter = useItemPresenter;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
    }

    @Override
    public void execute(UseItemInputData useItemInputData) {
        boolean success = userItemDataAccessObject.useItem(useItemInputData.potionType, inBattleDataAccessObject);
        if (success){
            useItemPresenter.prepareSuccessView();
        }
        else{
        useItemPresenter.prepareFailView();}


    }
}
