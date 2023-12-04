package use_case.DropItem;

import data_access.InBattleDataAccessObject;
import use_case.UseItem.UseItemDataAccessInterface;
import use_case.UseItem.UseItemInputData;
import use_case.UseItem.UseItemOutputBoundary;

public class DropItemInteractor implements DropItemInputBoundary{
    final DropItemDataAccessInterface dropItemDataAccessObject;
    final DropItemOutputBoundary dropItemPresenter;
    final InBattleDataAccessObject inBattleDataAccessObject;

    public DropItemInteractor(DropItemDataAccessInterface dropItemDataAccessObject, DropItemOutputBoundary dropItemPresenter, InBattleDataAccessObject inBattleDataAccessObject) {
        this.dropItemDataAccessObject = dropItemDataAccessObject;
        this.dropItemPresenter = dropItemPresenter;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
    }

    @Override
    public void execute(DropItemInputData dropItemInputData) {
        boolean success = dropItemDataAccessObject.dropItem(dropItemInputData.potionType, inBattleDataAccessObject);
        if (success){
            dropItemPresenter.prepareSuccessView();

        }
        else{
            dropItemPresenter.prepareFailView();}


    }

    @Override
    public void back() {
        dropItemPresenter.prepareExploreView();
    }

}
