package use_case.AttackButton.CardButton;

import data_access.APIAccess;
import data_access.InBattleDataAccessObject;
import entity.*;
import entity.BagAndItems.Item;
import interface_adapter.APIAccessInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.EnemyBehaviour.EnemyBehaviour;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;

import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CardButtonInteractorTest {

    InBattleDataAccessObject battleRepository;

    int cardPlayedValue;

    char cardPlayedSuit;

    APIAccessInterface api;

    int originalPlayerHealth;

    int originalEnemyHealth;

    int originalPlayerMaxHealth;

    int originalPlayerLevel;

    int numberOfRevive;

    @BeforeEach
    void setUp() throws IOException {
        Random random = new Random();

        api = new APIAccess();
        api.DrawCard("player");
        String cardPlayed = api.GetCardsInPile("player")[0];
        cardPlayedValue = api.GetCardValue(cardPlayed);
        cardPlayedSuit = api.GetCardSuit(cardPlayed);

        // Generate an enemy with random id, random level and random health
        Enemy enemy = new CurrentEnemyFactory().create(random.nextInt(0, 6), random.nextInt(1, 11));
        enemy.setHealth(random.nextInt(1, enemy.getCurrentHealth()));

        EnemyBehaviourInterface enemyBehaviour = new EnemyBehaviour(api, enemy);
        battleRepository = new InBattleDataAccessObject(new ActivePlayerFactory(), api, enemyBehaviour);
        Player player = battleRepository.getPlayer();

        // Generate random values for player health, level, and number of revive potions
        int levelsToIncrease = random.nextInt(1, 15);
        while (levelsToIncrease != 0) {
            player.levelUp();
            levelsToIncrease--;
        }
        player.setHealth(random.nextInt(1, player.getMaxHealth() + 1));
        Item revive = new revivePotion();
        int numRevive = random.nextInt(0, 6);
        while (numRevive != 0) {
            player.getBag().addItem(revive);
            numRevive--;
        }
        originalPlayerHealth = player.getCurrentHealth();
        originalPlayerMaxHealth = player.getMaxHealth();
        originalPlayerLevel = player.getLevel();
        originalEnemyHealth = player.getCurrentHealth();
        numberOfRevive = player.getBag().numOfRevive();

    }

    @Test
    void CardButtonInteractor() throws IOException {
        CardButtonDataAccessInterface dataAccessInterface = battleRepository;
        CardButtonOutputBoundary successPresenter = new CardButtonOutputBoundary() {
            @Override
            public void prepareSuccessView(CardButtonOutputData data) {
                // Check if max health and level remain unchanged
                assertEquals(originalPlayerMaxHealth, data.getPlayerMaxHealth());
                assertEquals(originalPlayerLevel, data.getPlayerLevel());

                // Checking if damage values are correct for enemy
                if (!(data.getEnemyAction().equals("attack"))) {
                    assertEquals(data.getDamageToPlayer(), 0);
                }

                // Check if damage values are correct for player
                if (data.getEnemyAction().equals("defend")) {
                    assertEquals(data.getDamageToEnemy(), (int) Math.ceil(dataAccessInterface.getPlayer().getLevel() * cardPlayedValue * 0.5));
                } else {
                    assert (data.getDamageToEnemy() == dataAccessInterface.getPlayer().getLevel() * cardPlayedValue) ||
                            (data.getDamageToEnemy() == dataAccessInterface.getPlayer().getLevel() * cardPlayedValue * 2);
                }

                // Check if health for enemy was updated correctly
                if (originalEnemyHealth <= data.getDamageToEnemy()) {
                    assertEquals(data.getEnemyHealth(), 0);
                } else {
                    assertEquals(data.getEnemyHealth(), originalEnemyHealth - data.getDamageToEnemy());
                }

                // Check if health for player was updated correctly
                if (originalPlayerHealth <= data.getDamageToPlayer()) {
                    if (data.getRevivePotionUsed()) {
                        assertEquals(data.getPlayerCurrentHealth(), data.getPlayerMaxHealth());
                    } else if (data.getPlayerCurrentHealth() == dataAccessInterface.getPlayer().getMaxHealth()) {
                        assert data.getRevivePotionUsed();
                        // Check player's inventory for one less revive potion
                        assertEquals(numberOfRevive - 1, dataAccessInterface.getPlayer().getBag().numOfRevive());
                    } else {
                        assertEquals(data.getPlayerCurrentHealth(), 0);
                        assert !data.getRevivePotionUsed();
                        // Check player's inventory for same number of revive potions
                        assertEquals(numberOfRevive, dataAccessInterface.getPlayer().getBag().numOfRevive());
                    }
                } else {
                    assertEquals(data.getPlayerCurrentHealth(), originalPlayerHealth - data.getDamageToPlayer());
                }

                // Check that player's and enemy's current health was updated
                assertEquals(data.getEnemyHealth(), dataAccessInterface.getEnemy().getCurrentHealth());
                assertEquals(data.getPlayerCurrentHealth(), dataAccessInterface.getPlayer().getCurrentHealth());

                assertEquals(dataAccessInterface.getPlayer().getMaxHealth(), data.getPlayerMaxHealth());
                assertEquals(data.getPlayerLevel(), dataAccessInterface.getPlayer().getLevel());
            }
        };

        CardButtonInputData inputData = new CardButtonInputData(cardPlayedValue, cardPlayedSuit);
        CardButtonInputBoundary interactor = new CardButtonInteractor(successPresenter, battleRepository);
        interactor.execute(inputData);
    }
}