package use_case.UseItem;

import data_access.APIAccess;
import data_access.InBattleDataAccessObject;
import data_access.UseItemDataAccessObject;
import entity.ActivePlayerFactory;
import entity.BagAndItems.Item;
import entity.BagAndItems.healingPotion10;
import entity.BagAndItems.healingPotion20;
import entity.BagAndItems.healingPotion45;
import entity.CurrentEnemyFactory;
import entity.Enemy;
import entity.Player;
import interface_adapter.APIAccessInterface;
import interface_adapter.UseItems.UseItemsPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.EnemyBehaviour.EnemyBehaviour;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;

import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class UseItemsInteractorTest {
    InBattleDataAccessObject inBattleDataAccessObject;

    int numberOfRevive;

    int numberOfHeal10;

    int numberOfHeal20;

    int numberOfHeal45;

    int healAmount;

    int originalPlayerHealth;
    int playerMaxHealth;
    @BeforeEach
    void setUp() throws IOException {
        Random random = new Random();

        APIAccessInterface api = new APIAccess();

        EnemyBehaviourInterface enemyBehaviour = new EnemyBehaviour(api);
        inBattleDataAccessObject = new InBattleDataAccessObject(new ActivePlayerFactory(), api, enemyBehaviour);
        Player player = inBattleDataAccessObject.getPlayer();
        playerMaxHealth = player.getMaxHealth();

        int levelsToIncrease = random.nextInt(1, 15);
        while (levelsToIncrease != 0) {
            player.levelUp();
            levelsToIncrease--;
        }
        player.setHealth(random.nextInt(1, player.getMaxHealth()));
        originalPlayerHealth = player.getCurrentHealth();

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
            player.getBag().addItem(heal20);
            numHeal20--;
        }
        numberOfHeal20 = player.getBag().numOfHeal20();

        Item heal45 = new healingPotion45();
        int numHeal45 = random.nextInt(0, 2);
        while (numHeal45 != 0) {
            player.getBag().addItem(heal45);
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
    void UseItemsInteractor(){
        UseItemDataAccessInterface useItemDataAccessObject = new UseItemDataAccessObject();
        UseItemOutputBoundary useItemPresenter = new UseItemOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                if (healAmount == 10){
                    useItemDataAccessObject.useItem(10, inBattleDataAccessObject);
                    assertEquals(inBattleDataAccessObject.getPlayer().getBag().numOfHeal10(), numberOfHeal10-1);
                    assertEquals(inBattleDataAccessObject.getPlayer().getCurrentHealth(), originalPlayerHealth + Math.floor(playerMaxHealth * 0.1));
                }
                else if (healAmount == 20){
                    useItemDataAccessObject.useItem(20, inBattleDataAccessObject);
                    assertEquals(inBattleDataAccessObject.getPlayer().getBag().numOfHeal20(), numberOfHeal20-1);
                    assertEquals(inBattleDataAccessObject.getPlayer().getCurrentHealth(), originalPlayerHealth + Math.floor(playerMaxHealth * 0.1));

                }
                else{
                    useItemDataAccessObject.useItem(45, inBattleDataAccessObject);
                    assertEquals(inBattleDataAccessObject.getPlayer().getBag().numOfHeal45(), numberOfHeal45-1);
                    assertEquals(inBattleDataAccessObject.getPlayer().getCurrentHealth(), originalPlayerHealth + Math.floor(playerMaxHealth * 0.1));

                }

            }

            @Override
            public void prepareFailView() {
            }
        };

    }
}
