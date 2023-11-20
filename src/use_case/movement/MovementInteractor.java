package use_case.movement;

import entity.Enemy;
import entity.EnemyFactory;
import interface_adapter.explore.ExploreDataAccessInterface;
import interface_adapter.explore.GenerateEnemyDataAccessInterface;

import java.util.Random;

public class MovementInteractor implements MovementInputBoundary {

    final ExploreDataAccessInterface exploreDataAccessObject;
    final GenerateEnemyDataAccessInterface inBattleDataAccessObject;
    final MovementOutputBoundary movementPresenter;
    final EnemyFactory enemyFactory;

    public MovementInteractor(ExploreDataAccessInterface exploreDataAccessObject,
                              GenerateEnemyDataAccessInterface inBattleDataAccessObject,
                              MovementOutputBoundary movementOutputBoundary, EnemyFactory enemyFactory){
        this.exploreDataAccessObject = exploreDataAccessObject;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
        this.movementPresenter = movementOutputBoundary;
        this.enemyFactory = enemyFactory;
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
            // Generates a random enemy:
            Random randomizer = new Random();
            int floorLevel = exploreDataAccessObject.getFloorLevel();
            Enemy enemy = enemyFactory.create(randomizer.nextInt(0, 6),
                    randomizer.nextInt(floorLevel / 5, (floorLevel / 5) + 3));
            inBattleDataAccessObject.setEnemy(enemy);
            inBattleDataAccessObject.generateInitialEnemyHand();

            //TODO: Create output data with enemy's name and level

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
