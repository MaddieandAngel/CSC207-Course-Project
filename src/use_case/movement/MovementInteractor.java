package use_case.movement;

import entity.BagAndItems.*;
import entity.Enemy;
import entity.EnemyFactory;
import interface_adapter.APIAccessInterface;
import interface_adapter.explore.ExploreDataAccessInterface;
import interface_adapter.explore.GenerateEnemyDataAccessInterface;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;

import java.io.IOException;
import java.util.Random;

public class MovementInteractor implements MovementInputBoundary {

    final ExploreDataAccessInterface exploreDataAccessObject;
    final GenerateEnemyDataAccessInterface inBattleDataAccessObject;
    final MovementOutputBoundary movementPresenter;
    final EnemyFactory enemyFactory;
    final EnemyBehaviourInterface enemyBehaviour;
    final APIAccessInterface apiAccessObject;

    public MovementInteractor(ExploreDataAccessInterface exploreDataAccessObject,
                              GenerateEnemyDataAccessInterface inBattleDataAccessObject,
                              MovementOutputBoundary movementOutputBoundary, EnemyFactory enemyFactory,
                              EnemyBehaviourInterface enemyBehaviour, APIAccessInterface apiAccessInterface){
        this.exploreDataAccessObject = exploreDataAccessObject;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
        this.movementPresenter = movementOutputBoundary;
        this.enemyFactory = enemyFactory;
        this.enemyBehaviour = enemyBehaviour;
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
        boolean searchable = !(exploreDataAccessObject.getHasBeenSearched());
        MovementOutputData movementOutputData = new MovementOutputData(directions, searchable);

        if (exploreDataAccessObject.checkForStairs()){
            movementPresenter.prepareStairsView();
        }
        else if (exploreDataAccessObject.checkForEnemy()){
            System.out.println("enemy"); //TODO: delete later

            //Remove enemy from the room, so that it can't be encountered again
            exploreDataAccessObject.removeEnemyFromRoom();

            // Generates a random enemy:
            Random randomizer = new Random();
            int floorLevel = exploreDataAccessObject.getFloorLevel();
            Enemy enemy = enemyFactory.create(randomizer.nextInt(0, 6),
                    randomizer.nextInt(floorLevel / 5, (floorLevel / 5) + 3));
            inBattleDataAccessObject.setEnemy(enemy);

            //Draws 5 cards for the enemy's initial hand (or at least attempts to):
            try {
                enemyBehaviour.enemyDrawInitialHand(inBattleDataAccessObject.getEnemy());
                // Will draw 5 cards for the player when the battle starts
                for (int i = 0; i < 5; i++) {
                    if (apiAccessObject.GetCardsInPile("player") == null || apiAccessObject.GetCardsInPile("player").length < 5) {
                        apiAccessObject.DrawCard("player");
                    }
                }
                System.out.println(apiAccessObject.GetCardsInPile("player").length == 5);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            movementPresenter.prepareTurnSelectView(new EnemyOutputData(enemy.getName(), enemy.getLevel()));
        }
        else if (exploreDataAccessObject.checkForItem()){
            System.out.println("item"); //TODO: delete later

            //Remove item from the room, so that it can't be found again if you re-enter the room
            exploreDataAccessObject.removeItemFromRoom();

            //Generates a random item
            Random r = new Random();
            int randomItem = r.nextInt(100);
            if (randomItem < 40){
                Item item = new healingPotion10();
                movementPresenter.prepareItemCollectionView(item);
            }
            else if (randomItem <70){
                Item item = new healingPotion20();
                movementPresenter.prepareItemCollectionView(item);
            }
            else if (randomItem < 90){
                Item item = new healingPotion45();
                movementPresenter.prepareItemCollectionView(item);
            }
            else{
                Item item= new revivePotion();
                movementPresenter.prepareItemCollectionView(item);
            }
        }
        else {
            movementPresenter.prepareEmptyRoomView(movementOutputData);
        }
    }
}
