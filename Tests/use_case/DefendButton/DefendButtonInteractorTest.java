package use_case.DefendButton;

import data_access.APIAccess;
import data_access.InBattleDataAccessObject;
import entity.ActivePlayerFactory;
import entity.BagAndItems.Item;
import entity.BagAndItems.revivePotion;
import entity.CurrentEnemyFactory;
import entity.Enemy;
import entity.Player;
import interface_adapter.APIAccessInterface;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.DrawButton.DrawButtonInputBoundary;
import use_case.DrawButton.DrawButtonInteractor;
import use_case.EnemyBehaviour.EnemyBehaviour;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class DefendButtonInteractorTest {
    InBattleDataAccessObject battleRepository;
    int originalPlayerHealth;
    APIAccessInterface api;
    int originalMaxHealth;
    int originalPlayerLevel;
    int enemyLevel;
    int numberOfRevive;

    @BeforeEach
    void setup() throws IOException{
        Random random = new Random();
        api = new APIAccess();

        // Generate an enemy with random id, level and health
        Enemy enemy = new CurrentEnemyFactory().create(random.nextInt(0, 6), random.nextInt(1, 11));
        enemy.setHealth(random.nextInt(1, enemy.getCurrentHealth()));

        EnemyBehaviourInterface enemyBehaviour = new EnemyBehaviour(api);
        battleRepository = new InBattleDataAccessObject(new ActivePlayerFactory(), api, enemyBehaviour);
        Player player = battleRepository.getPlayer();

        // Generate random values for player health, level, and number of revive potions
        int levelsToIncrease = random.nextInt(0, 15);
        while (levelsToIncrease != 0) {
            player.levelUp();
            levelsToIncrease--;
        }
        player.setHealth(random.nextInt(1, player.getMaxHealth()));
        originalPlayerHealth = player.getCurrentHealth();

        Item revive = new revivePotion();
        int numRevive = random.nextInt(0, 6);
        while (numRevive != 0) {
            player.getBag().addItem(revive);
            numRevive--;
        }
        numberOfRevive = player.getBag().numOfRevive();

        originalMaxHealth = player.getMaxHealth();
        originalPlayerLevel = player.getLevel();
        enemyLevel = enemy.getLevel();
    }

    @Test
    void canDefend() throws IOException{
        DefendButtonOutputBoundary successPresenter = new DefendButtonOutputBoundary() {
            @Override
            public void prepareDefendSuccessView(DefendButtonOutputData defendButtonOutputData) {
                //Initialize cardValueInt
                int cardValueInt = 0;

                // If enemy attacks, get Card Value
                if (defendButtonOutputData.getEnemyAction().equals("attack")){
                    String cardValue = defendButtonOutputData.getEnemyCardValue();
                    if (Objects.equals(cardValue, "0")) {
                        cardValueInt = 10;
                    } else if (Objects.equals(cardValue, "A")) {
                        cardValueInt = 1;
                    } else if (Objects.equals(cardValue, "J")) {
                        cardValueInt = 11;
                    } else if (Objects.equals(cardValue, "Q")) {
                        cardValueInt = 12;
                    } else if (Objects.equals(cardValue, "K")) {
                        cardValueInt = 13;
                    } else if (Objects.equals(cardValue, "X")) {
                        // Generate a random int between 0 (inclusive) and 16 (exclusive) for jokers
                        Random random = new Random();
                        cardValueInt = random.nextInt(16);
                    } else {
                        cardValueInt = Integer.parseInt(String.valueOf(cardValue));
                    }
                }
                //Check if only half of the damage dealt by the enemy is done to the player
                assertEquals(defendButtonOutputData.getDamageToPlayer(), enemyLevel * cardValueInt / 2);
                // Check player's health
                if (defendButtonOutputData.isRevivePotionUsed()){
                    assertEquals(defendButtonOutputData.getPlayerCurrentHealth(), defendButtonOutputData.getPlayerMaxHealth());
                }
                else{
                    assertEquals(defendButtonOutputData.getPlayerCurrentHealth(), originalPlayerHealth - defendButtonOutputData.getDamageToPlayer());
                }

            }
        };
        DefendButtonInputBoundary interactor = new DefendButtonInteractor(successPresenter, battleRepository);
        interactor.execute();
    }
}
