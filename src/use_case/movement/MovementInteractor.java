package use_case.movement;

public class MovementInteractor implements MovementInputBoundary {

    final MovementOutputBoundary movementPresenter;

    public MovementInteractor(MovementOutputBoundary movementOutputBoundary){
        this.movementPresenter = movementOutputBoundary;
    }

    @Override
    public void execute(MovementInputData movementInputData) {
        String direction = movementInputData.getDirection();
        if (direction.equals("N")){

        }
        else if (direction.equals("E")){

        }
        else if (direction.equals("S")){

        }
        else if (direction.equals("W")){

        }
        else {
            throw new RuntimeException("Input data should be \"N\", \"E\", \"S\", or \"W\"");
        }
    }
}
