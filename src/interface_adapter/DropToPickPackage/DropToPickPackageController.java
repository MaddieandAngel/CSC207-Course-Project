package interface_adapter.DropToPickPackage;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import entity.Player;
import use_case.DropToPickPackage.DropToPickPackageInputBoundary;
import use_case.DropToPickPackage.DropToPickPackageInputData;

public class DropToPickPackageController {
    final DropToPickPackageInputBoundary dropToPickPackageInteractor;


    public DropToPickPackageController(DropToPickPackageInputBoundary dropToPickPackageInteractor) {
        this.dropToPickPackageInteractor = dropToPickPackageInteractor;
    }
    public void execute(int num){

            DropToPickPackageInputData dropToPickPackageInputData = new DropToPickPackageInputData(num);
            dropToPickPackageInteractor.execute(dropToPickPackageInputData);

    }
    public void back(){
        dropToPickPackageInteractor.back();
    }
}
