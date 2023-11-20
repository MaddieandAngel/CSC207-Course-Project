package interface_adapter.DropToPickPackage;

import entity.Player;
import use_case.DropToPickPackage.DropToPickPackageInputBoundary;
import use_case.DropToPickPackage.DropToPickPackageInputData;

public class DropToPickPackageController {
    final DropToPickPackageInputBoundary dropToPickPackageInteractor;


    public DropToPickPackageController(DropToPickPackageInputBoundary dropToPickPackageInteractor) {
        this.dropToPickPackageInteractor = dropToPickPackageInteractor;
    }
    public void execute(Player player, int num, int back){

            DropToPickPackageInputData dropToPickPackageInputData = new DropToPickPackageInputData(player, num);
            dropToPickPackageInteractor.execute(dropToPickPackageInputData);

    }
    public void back(){
        dropToPickPackageInteractor.back();
    }
}
