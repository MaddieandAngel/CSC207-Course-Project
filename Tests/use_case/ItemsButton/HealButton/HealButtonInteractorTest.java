package use_case.ItemsButton.HealButton;

import data_access.APIAccess;
import data_access.InBattleDataAccessObject;
import entity.ActivePlayerFactory;
import entity.BagAndItems.*;
import entity.CurrentEnemyFactory;
import entity.Enemy;
import entity.Player;
import interface_adapter.APIAccessInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.EnemyBehaviour.EnemyBehaviour;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;

import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HealButtonInteractorTest {

    InBattleDataAccessObject battleRepository;

    int numberOfRevive;

    int numberOfHeal10;

    int numberOfHeal20;

    int numberOfHeal45;

    int healAmount;

    int originalPlayerHealth;

    @BeforeEach
    void setUp() throws IOException {
        Random random = new Random();

        APIAccessInterface api = new APIAccess();

        // Generate an enemy with a random id, level and health
        Enemy enemy = new CurrentEnemyFactory().create(random.nextInt(0, 6), random.nextInt(1, 11));
        enemy.setHealth(random.nextInt(1, enemy.getCurrentHealth()));

        EnemyBehaviourInterface enemyBehaviour = new EnemyBehaviour(api, enemy);
        battleRepository = new InBattleDataAccessObject(new ActivePlayerFactory(), api, enemyBehaviour);
        Player player = battleRepository.getPlayer();

        // Generate random values for player health, level number of revive potions, heal10, heal20, and heal45 potions
        int levelsToIncrease = random.nextInt(1, 15);
        while (levelsToIncrease != 0) {
            player.levelUp();
            levelsToIncrease--;
        }
        player.setHealth(random.nextInt(1, player.getMaxHealth()));
        originalPlayerHealth = player.getCurrentHealth();

        Item revive = new revivePotion();
        int numRevive = random.nextInt(0, 2);
        while (numRevive != 0) {
            player.getBag().addItem(revive);
            numRevive--;
        }
        numberOfRevive = player.getBag().numOfRevive();

        Item heal10 = new healingPotion10();
        int numHeal10 = random.nextInt(0, 2);
        while (numHeal10 != 0) {
            player.getBag().addItem(heal10);
            numHeal10--;
        }
        numberOfHeal10 = player.getBag().numOfHeal10();

        Item heal20 = new healingPotion20();
        int numHeal20 = random.nextInt(0, 2);
        while (numHeal20 != 0) {
            player.getBag().addItem(heal10);
            numHeal20--;
        }
        numberOfHeal20 = player.getBag().numOfHeal20();

        Item heal45 = new healingPotion45();
        int numHeal45 = random.nextInt(0, 2);
        while (numHeal45 != 0) {
            player.getBag().addItem(heal10);
            numHeal45--;
        }
        numberOfHeal45 = player.getBag().numOfHeal45();

        int temp = random.nextInt(1, 4);
        if (temp == 1) {
            healAmount = 10;
        } else if (temp == 2) {
            healAmount = 20;
        } else {
            healAmount = 45;
        }
    }

    @Test
    void HealButtonInteractor() throws IOException {
        HealButtonDataAccessInterface dataAccessInterface = battleRepository;

        HealButtonOutputBoundary successPresenter = new HealButtonOutputBoundary() {
            @Override
            public void prepareSuccessView(HealButtonOutputData data) {

                // Check that the number of provided heal type has decreased by one
                if (healAmount == 10) {
                    assertEquals(dataAccessInterface.getPlayer().getBag().numOfHeal10(), numberOfHeal10 - 1);
                } else if (healAmount == 20) {
                    assertEquals(dataAccessInterface.getPlayer().getBag().numOfHeal20(), numberOfHeal20 - 1);
                } else {
                    // heal45 was used
                    assertEquals(dataAccessInterface.getPlayer().getBag().numOfHeal45(), numberOfHeal45 - 1);
                }

                if (!(data.getEnemyAction().equals("attack"))) {
                    // The player's current health will be greater than their original health
                    assert data.getPlayerCurrentHealth() > originalPlayerHealth;
                    // Since enemy did not attack, damage to player should be 0
                    assertEquals(data.getDamageToPlayer(), 0);
                } else {
                    // The enemy attacked the player, so enemy card values should not be empty strings/char
                    assert !(data.getEnemyCardValue().equals(""));
                    assert data.getEnemyCardSuit() != ' ';
                    assert !(data.getEnemyCardImage().equals(""));
                }

                if (data.getReviveUsed()) {
                    assertEquals(data.getPlayerCurrentHealth(), dataAccessInterface.getPlayer().getMaxHealth());
                }

                if (data.getPlayerCurrentHealth() == 0) {
                    assertEquals(numberOfRevive, 0);
                    assert !data.getReviveUsed();
                }
            }
        };

        HealButtonInputData inputData = new HealButtonInputData(healAmount);
        HealButtonInputBoundary interactor = new HealButtonInteractor(successPresenter, dataAccessInterface);
        interactor.execute(inputData);
    }

}