package use_case.movement;

import entity.Enemy;
import entity.EnemyFactory;
import interface_adapter.APIAccessInterface;
import interface_adapter.explore.ExploreDataAccessInterface;
import interface_adapter.explore.GenerateEnemyDataAccessInterface;
import use_case.EnemyBehaviour.EnemyBehaviour;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;

import java.io.IOException;
import java.util.Random;

public class MovementInteractor implements MovementInputBoundary {

    final ExploreDataAccessInterface exploreDataAccessObject;
    final GenerateEnemyDataAccessInterface inBattleDataAccessObject;
    final MovementOutputBoundary movementPresenter;
    final EnemyFactory enemyFactory;
    final APIAccessInterface apiAccessObject;

    public MovementInteractor(ExploreDataAccessInterface exploreDataAccessObject,
                              GenerateEnemyDataAccessInterface inBattleDataAccessObject,
                              MovementOutputBoundary movementOutputBoundary, EnemyFactory enemyFactory,
                              APIAccessInterface apiAccessInterface){
        this.exploreDataAccessObject = exploreDataAccessObject;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
        this.movementPresenter = movementOutputBoundary;
        this.enemyFactory = enemyFactory;
        this.apiAccessObject = apiAccessInterface;
    }

    @Override
    public void execute(MovementInputData movementInputData) {
        String direction = movementInputData.getDirection();
        switch (direction) {
            case "N" -> exploreDataAccessObject.moveNorth();
            case "E" -> exploreDataAccessObject.moveEast();
            case "S" -> exploreDataAccessObject.moveSouth();
            case "W" -> exploreDataAccessObject.moveWest();
            default -> throw new RuntimeException("Input data should be \"N\", \"E\", \"S\", or \"W\"");
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

            //Draws 5 cards for the enemy's initial hand (or at least attempts to):
            try {
                EnemyBehaviourInterface enemyHandGenerator = new EnemyBehaviour(apiAccessObject,
                        inBattleDataAccessObject.getDeck(), inBattleDataAccessObject.getEnemy());
                //Note: creates an instance of an EnemyBehaviour instead of its interface. Might be a problem?

                enemyHandGenerator.enemyDrawInitialHand();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            movementPresenter.prepareTurnSelectView(new EnemyOutputData(enemy.getName(), enemy.getLevel()));
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
