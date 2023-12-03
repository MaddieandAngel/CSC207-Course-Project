package use_case.SearchButton;

import entity.BagAndItems.*;
import entity.Enemy;
import interface_adapter.APIAccessInterface;

import java.io.IOException;
import java.util.Random;
import entity.EnemyFactory;
import interface_adapter.explore.ExploreDataAccessInterface;
import interface_adapter.explore.GenerateEnemyDataAccessInterface;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;
import use_case.movement.EnemyOutputData;
import use_case.movement.MovementOutputData;

import javax.swing.*;

public class SearchButtonIneractor implements SearchButtonInputBoundary{
    final SearchButtonOutputBoundary searchButtonPresenter;
    final EnemyFactory enemyFactory;
    final APIAccessInterface apiAccessObject;
    final ExploreDataAccessInterface exploreDataAccessObject;
    final GenerateEnemyDataAccessInterface inBattleDataAccessObject;
    final EnemyBehaviourInterface enemyBehaviour;


    public SearchButtonIneractor(SearchButtonOutputBoundary searchButtonPresenter,
                                 EnemyFactory enemyFactory, APIAccessInterface apiAccessInterface,
                                 ExploreDataAccessInterface exploreDataAccessObject,
                                 GenerateEnemyDataAccessInterface inBattleDataAccessObject, EnemyBehaviourInterface enemyBehaviour) {
        this.searchButtonPresenter = searchButtonPresenter;
        this.enemyFactory = enemyFactory;
        this.apiAccessObject = apiAccessInterface;
        this.exploreDataAccessObject = exploreDataAccessObject;
        this.inBattleDataAccessObject = inBattleDataAccessObject;
        this.enemyBehaviour = enemyBehaviour;
    }

    @Override
    public void execute() {
        MovementOutputData movementOutputData = new MovementOutputData(exploreDataAccessObject.getDirections());
        Random r = new Random();
        int random = r.nextInt(100);
        if (random <= 1){
            searchButtonPresenter.prepareEmptyRoomView();
            JOptionPane.showMessageDialog(null, "The room is empty:(");
        }else if (random <= 1){
            JOptionPane.showMessageDialog(null, "There's enemy in the room");
            Random randomizer = new Random();
            int floorLevel = exploreDataAccessObject.getFloorLevel();
            Enemy enemy = enemyFactory.create(randomizer.nextInt(0, 6),
                    randomizer.nextInt(floorLevel / 5, (floorLevel / 5) + 3));
            inBattleDataAccessObject.setEnemy(enemy);
            try {
                enemyBehaviour.enemyDrawInitialHand(inBattleDataAccessObject.getEnemy());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            searchButtonPresenter.prepareTurnSelectView(new EnemyOutputData(enemy.getName(), enemy.getLevel()));
        }else{
            JOptionPane.showMessageDialog(null, "There's an item in the room!");
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
