package use_case.DropToPickPackage;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import entity.Player;
import use_case.DropToPickPackage.DropToPickPackageInputBoundary;
import use_case.DropToPickPackage.DropToPickPackageDataAccessInterface;
import use_case.DropToPickPackage.DropToPickPackageOutputBoundary;

public class DropToPickPackageInteractor implements DropToPickPackageInputBoundary{
    final DropToPickPackageDataAccessInterface dropToPickPackageDataAccessObject;
    final DropToPickPackageOutputBoundary dropToPickPackagePresenter;
    final InBattleDataAccessObject inBattleDataAccessObject;

    public DropToPickPackageInteractor(DropToPickPackageDataAccessInterface dropToPickPackageDataAccessObject, DropToPickPackageOutputBoundary dropToPickPackagePresenter, InBattleDataAccessObject inBattleDataAccessObject) {
        this.dropToPickPackageDataAccessObject = dropToPickPackageDataAccessObject;
        this.dropToPickPackagePresenter = dropToPickPackagePresenter;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
    }

    @Override
    public void execute(DropToPickPackageInputData dropToPickPackageInputData) {
        boolean success = dropToPickPackageDataAccessObject.dropItem(dropToPickPackageInputData.potionType, inBattleDataAccessObject.getPlayer());
        if (success){
            dropToPickPackagePresenter.prepareSuccessView();
        }
        else{
            dropToPickPackagePresenter.prepareFailView();}


    }
    @Override
    public void back(){
        DropToPickPackageOutputData dropToPickPackageOutputData = new DropToPickPackageOutputData(inBattleDataAccessObject.getPlayer());
        dropToPickPackagePresenter.preparePickItemView(dropToPickPackageOutputData);
    }
}
