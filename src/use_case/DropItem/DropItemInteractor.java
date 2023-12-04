package use_case.DropItem;

import data_access.InBattleDataAccessObject;
import interface_adapter.explore.ExploreDataAccessInterface;
import use_case.UseItem.UseItemDataAccessInterface;
import use_case.UseItem.UseItemInputData;
import use_case.UseItem.UseItemOutputBoundary;
import use_case.movement.MovementOutputData;

public class DropItemInteractor implements DropItemInputBoundary{
    final DropItemDataAccessInterface dropItemDataAccessObject;
    final DropItemOutputBoundary dropItemPresenter;
    final InBattleDataAccessObject inBattleDataAccessObject;
    final ExploreDataAccessInterface exploreDataAccessObject;

    public DropItemInteractor(DropItemDataAccessInterface dropItemDataAccessObject, DropItemOutputBoundary dropItemPresenter, InBattleDataAccessObject inBattleDataAccessObject, ExploreDataAccessInterface exploreDataAccessObject) {
        this.dropItemDataAccessObject = dropItemDataAccessObject;
        this.dropItemPresenter = dropItemPresenter;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
        this.exploreDataAccessObject = exploreDataAccessObject;
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
        String directions = exploreDataAccessObject.getDirections();
        boolean searchable = !(exploreDataAccessObject.getHasBeenSearched());
        MovementOutputData movementOutputData = new MovementOutputData(directions, searchable);
        dropItemPresenter.prepareExploreView(movementOutputData);
    }

}
