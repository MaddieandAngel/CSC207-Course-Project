package use_case.movement;

import interface_adapter.explore.ExploreDataAccessInterface;

public class MovementInteractor implements MovementInputBoundary {

    final ExploreDataAccessInterface exploreDataAccessObject;
    final MovementOutputBoundary movementPresenter;

    public MovementInteractor(ExploreDataAccessInterface exploreDataAccessObject,
                              MovementOutputBoundary movementOutputBoundary){
        this.exploreDataAccessObject = exploreDataAccessObject;
        this.movementPresenter = movementOutputBoundary;
    }

    @Override
    public void execute(MovementInputData movementInputData) {
        String direction = movementInputData.getDirection();
        if (direction.equals("N")){
            exploreDataAccessObject.moveNorth();
        }
        else if (direction.equals("E")){
            exploreDataAccessObject.moveEast();
        }
        else if (direction.equals("S")){
            exploreDataAccessObject.moveSouth();
        }
        else if (direction.equals("W")){
            exploreDataAccessObject.moveWest();
        }
        else {
            throw new RuntimeException("Input data should be \"N\", \"E\", \"S\", or \"W\"");
        }

        String directions = exploreDataAccessObject.getDirections();
        MovementOutputData movementOutputData = new MovementOutputData(directions);

        if (exploreDataAccessObject.checkForStairs()){
            movementPresenter.prepareStairsView(movementOutputData);
        }
        else if (exploreDataAccessObject.checkForEnemy()){
            //TODO: Generate enemy for output data
            //TODO: Use API to give enemy cards?
            movementPresenter.prepareTurnSelectView(movementOutputData);
        }
        else if (exploreDataAccessObject.checkForItem()){
            //TODO: Generate item for output data
            movementPresenter.prepareItemCollectionView(movementOutputData);
        }
        else {
            movementPresenter.prepareEmptyRoomView(movementOutputData);
        }
    }
}
