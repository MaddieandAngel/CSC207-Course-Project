package interface_adapter.explore;

import use_case.movement.MovementInputBoundary;
import use_case.movement.MovementInputData;

public class MovementButtonController {

    final MovementInputBoundary movementUseCaseInteractor;

    public MovementButtonController(MovementInputBoundary movementUseCaseInteractor){
        this.movementUseCaseInteractor = movementUseCaseInteractor;
    }

    public void execute(String direction){
        MovementInputData movementInputData = new MovementInputData(direction);
        movementUseCaseInteractor.execute(movementInputData);
    }
}
