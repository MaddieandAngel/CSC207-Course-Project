package use_case.DropItem;

import use_case.UseItem.UseItemDataAccessInterface;
import use_case.UseItem.UseItemInputData;
import use_case.UseItem.UseItemOutputBoundary;

public class DropItemInteractor implements DropItemInputBoundary{
    final DropItemDataAccessInterface dropItemDataAccessObject;
    final DropItemOutputBoundary dropItemPresenter;

    public DropItemInteractor(DropItemDataAccessInterface dropItemDataAccessObject, DropItemOutputBoundary dropItemPresenter) {
        this.dropItemDataAccessObject = dropItemDataAccessObject;
        this.dropItemPresenter = dropItemPresenter;
    }

    @Override
    public void execute(DropItemInputData dropItemInputData) {
        boolean success = dropItemDataAccessObject.dropItem(dropItemInputData.potionType, dropItemInputData.player);
        if (success){
            dropItemPresenter.prepareSuccessView();
            System.out.println("drop:"+Integer.toString(dropItemInputData.player.getCurrentHealth()));

        }
        else{
            dropItemPresenter.prepareFailView();}


    }
}
