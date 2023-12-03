package use_case.DropToPickPackage;

import entity.ActivePlayer;
import use_case.DropToPickPackage.DropToPickPackageInputBoundary;
import use_case.DropToPickPackage.DropToPickPackageDataAccessInterface;
import use_case.DropToPickPackage.DropToPickPackageOutputBoundary;

public class DropToPickPackageInteractor implements DropToPickPackageInputBoundary{
    final DropToPickPackageDataAccessInterface dropToPickPackageDataAccessObject;
    final DropToPickPackageOutputBoundary dropToPickPackagePresenter;

    public DropToPickPackageInteractor(DropToPickPackageDataAccessInterface dropToPickPackageDataAccessObject, DropToPickPackageOutputBoundary dropToPickPackagePresenter) {
        this.dropToPickPackageDataAccessObject = dropToPickPackageDataAccessObject;
        this.dropToPickPackagePresenter = dropToPickPackagePresenter;
    }

    @Override
    public void execute(DropToPickPackageInputData dropToPickPackageInputData) {
        boolean success = dropToPickPackageDataAccessObject.dropItem(dropToPickPackageInputData.potionType, dropToPickPackageInputData.player);
        if (success){
            dropToPickPackagePresenter.prepareSuccessView();
            System.out.println("drop:"+Integer.toString(dropToPickPackageInputData.player.getCurrentHealth()));

        }
        else{
            dropToPickPackagePresenter.prepareFailView();}


    }
    @Override
    public void back(ActivePlayer player){
        dropToPickPackagePresenter.preparePickItemView(player);
    }
}
