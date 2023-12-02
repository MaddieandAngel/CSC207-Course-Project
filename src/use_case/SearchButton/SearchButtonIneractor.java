package use_case.SearchButton;

import data_access.ExploreDataAccessObject;
import data_access.InBattleDataAccessObject;
import entity.BagAndItems.*;
import entity.Enemy;
import interface_adapter.APIAccessInterface;

import java.io.IOException;
import java.util.Random;
import entity.EnemyFactory;
import use_case.EnemyBehaviour.EnemyBehaviour;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;
import use_case.movement.EnemyOutputData;
import use_case.movement.MovementOutputData;

public class SearchButtonIneractor implements SearchButtonInputBoundary{
    final SearchButtonOutputBoundary searchButtonPresenter;
    final EnemyFactory enemyFactory;
    final APIAccessInterface apiAccessObject;
    final ExploreDataAccessObject exploreDataAccessObject;
    final InBattleDataAccessObject inBattleDataAccessObject;


    public SearchButtonIneractor(SearchButtonOutputBoundary searchButtonPresenter, EnemyFactory enemyFactory, APIAccessInterface apiAccessInterface, ExploreDataAccessObject exploreDataAccessObject, InBattleDataAccessObject inBattleDataAccessObject) {
        this.searchButtonPresenter = searchButtonPresenter;
        this.enemyFactory = enemyFactory;
        this.apiAccessObject = apiAccessInterface;
        this.exploreDataAccessObject = exploreDataAccessObject;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
    }

    @Override
    public void execute() {
        MovementOutputData movementOutputData = new MovementOutputData(exploreDataAccessObject.getDirections());
        Random r = new Random();
        int random = r.nextInt(100);
        if (random <= 60){
            searchButtonPresenter.prepareEmptyRoomView(movementOutputData);
        }else if (random <= 80){
            Random randomizer = new Random();
            int floorLevel = exploreDataAccessObject.getFloorLevel();
            Enemy enemy = enemyFactory.create(randomizer.nextInt(0, 6),
                    randomizer.nextInt(floorLevel / 5, (floorLevel / 5) + 3));
            inBattleDataAccessObject.setEnemy(enemy);
            try {
                EnemyBehaviourInterface enemyHandGenerator = new EnemyBehaviour(apiAccessObject,
                        inBattleDataAccessObject.getDeck(), inBattleDataAccessObject.getEnemy());
                //Note: creates an instance of an EnemyBehaviour instead of its interface. Might be a problem?

                enemyHandGenerator.enemyDrawInitialHand();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            searchButtonPresenter.prepareTurnSelectView(new EnemyOutputData(enemy.getName(), enemy.getLevel()));
        }else{

            int randomItem = r.nextInt(100);
            if (randomItem < 40){
                Item item = new healingPotion10();
                searchButtonPresenter.prepareItemCollectionView(item);
            }
            else if (randomItem <70){
                Item item = new healingPotion20();
                searchButtonPresenter.prepareItemCollectionView(item);
            }
            else if (randomItem < 90){
                Item item = new healingPotion45();
                searchButtonPresenter.prepareItemCollectionView(item);
            }
            else{
                Item item= new revivePotion();
                searchButtonPresenter.prepareItemCollectionView(item);
            }


        }
    }
}
