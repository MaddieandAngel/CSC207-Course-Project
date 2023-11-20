package use_case.movement;

public class MovementInputData {

    final private String direction;

    public MovementInputData(String direction){
        this.direction = direction;
    }

    String getDirection() {
        return direction;
    }
}
