package use_case.DrawButton;

import data_access.APIAccess;
import data_access.InBattleDataAccessObject;
import entity.ActivePlayerFactory;
import entity.BagAndItems.Item;
import entity.BagAndItems.revivePotion;
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

class DrawButtonInteractorTest {

    InBattleDataAccessObject battleRepository;

    int originalPlayerHealth;

    APIAccessInterface api;

    int playerOriginalHandLength;

    int originalMaxHealth;

    int originalPlayerLevel;

    int originalEnemyHealth;

    int numberOfRevive;

    @BeforeEach
    void setUp() throws IOException {
        Random random = new Random();

        api = new APIAccess();

        // Create a hand for the player that is not full
        int numCardsInHand = random.nextInt(0,5);
        while (numCardsInHand != 0) {
            api.DrawCard("player");
            numCardsInHand--;
        }
        playerOriginalHandLength = api.GetCardsInPile("player").length;

        // Generate an enemy with random id, level and health
        Enemy enemy = new CurrentEnemyFactory().create(random.nextInt(0, 6), random.nextInt(1, 11));
        enemy.setHealth(random.nextInt(1, enemy.getCurrentHealth()));

        EnemyBehaviourInterface enemyBehaviour = new EnemyBehaviour(api, enemy);
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
        originalEnemyHealth = enemy.getCurrentHealth();
    }

    @Test
    void canDraw() throws IOException {
        DrawButtonDataAccessInterface dataAccessInterface = battleRepository;

        DrawButtonOutputBoundary successPresenter = new DrawButtonOutputBoundary() {
            @Override
            public void prepareSuccessView(DrawButtonOutputData data) {

                // Check maxHealth, level, and enemy health do not change
                assertEquals(originalMaxHealth, data.getPlayerMaxHealth());
                assertEquals(originalPlayerLevel, data.getPlayerLevel());
                assertEquals(originalEnemyHealth, data.getEnemyHealth());

                // Check if damage values are correct for damage towards player
                if (!(data.getEnemyAction().equals("attack"))) {
                    assertEquals(data.getDamageToPlayer(), 0);
                }

                // Check if health was updated for player correctly
                if (originalPlayerHealth <= data.getDamageToPlayer()) {
                    if (data.revivePotionUsed()) {
                        assertEquals(data.getPlayerCurrentHealth(), data.getPlayerMaxHealth());
                    } else if (data.getPlayerCurrentHealth() == dataAccessInterface.getPlayer().getMaxHealth()) {
                        // Check that revive potion was used and there is now one less in the player's inventory
                        assert data.revivePotionUsed();
                        assertEquals(numberOfRevive, dataAccessInterface.getPlayer().getBag().numOfRevive() - 1);

                    } else {
                        assertEquals(data.getPlayerCurrentHealth(), 0);
                        // Check that revive potion was not used and the number of revive potions in the player's inventory should be 0
                        assert !(data.revivePotionUsed());
                        assertEquals(dataAccessInterface.getPlayer().getBag().numOfRevive(), 0);
                    }
                } else {
                    assertEquals(data.getPlayerCurrentHealth(), originalPlayerHealth - data.getDamageToPlayer());
                }

                // Check that card was added to pile
                try {
                    assertEquals(api.GetCardsInPile("player").length, playerOriginalHandLength + 1);
                } catch (IOException e) {
                    fail("IOException not expected");
                }

            }

            @Override
            public void prepareFailView(String error) {
                fail("failView not expected, hand is not full");

            }
        };
        DrawButtonInputBoundary interactor = new DrawButtonInteractor(successPresenter, battleRepository);
        interactor.execute();
    }

    @Test
    void handFull() throws IOException {
        DrawButtonDataAccessInterface dataAccessInterface = battleRepository;

        // Ensure that the player's hand is full
        while (playerOriginalHandLength != 5) {
            dataAccessInterface.getAPI().DrawCard("player");
            playerOriginalHandLength++;
        }

        DrawButtonOutputBoundary failPresenter = new DrawButtonOutputBoundary() {
            @Override
            public void prepareSuccessView(DrawButtonOutputData data) {
                fail("fail view/pop-up expected since the player's hand is full, so cannot draw");

            }

            @Override
            public void prepareFailView(String error) {

                // Check string error/message
                assertEquals(error, "Hand full");

                // Check that player's hand remains the same (size 5)
                try {
                    assertEquals(api.GetCardsInPile("player").length, 5);
                } catch (IOException e) {
                    fail("IOException not expected");
                }

                // Check that all the variables have not changed
                assertEquals(originalPlayerHealth, dataAccessInterface.getPlayer().getCurrentHealth());
                assertEquals(originalMaxHealth, dataAccessInterface.getPlayer().getMaxHealth());
                assertEquals(originalPlayerLevel, dataAccessInterface.getPlayer().getLevel());
                assertEquals(originalEnemyHealth, dataAccessInterface.getEnemy().getCurrentHealth());
                assertEquals(numberOfRevive, dataAccessInterface.getPlayer().getBag().numOfRevive());

            }
        };
        DrawButtonInputBoundary interactor = new DrawButtonInteractor(failPresenter, battleRepository);
        interactor.execute();

    }
}