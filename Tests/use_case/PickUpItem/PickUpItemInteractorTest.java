package Tests.use_case.PickUpItem;

import data_access.APIAccess;
import data_access.InBattleDataAccessObject;
import data_access.PickUpItemDataAccessObject;
import data_access.UseItemDataAccessObject;
import entity.ActivePlayerFactory;
import entity.BagAndItems.*;
import entity.CurrentEnemyFactory;
import entity.Enemy;
import entity.Player;
import interface_adapter.APIAccessInterface;
import interface_adapter.UseItems.UseItemsPresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.EnemyBehaviour.EnemyBehaviour;
import use_case.EnemyBehaviour.EnemyBehaviourInterface;
import use_case.PickUpItem.PickUpItemDataAccessInterface;
import use_case.PickUpItem.PickUpItemOutputBoundary;
import use_case.PickUpItem.PickUpItemOutputData;
import use_case.movement.MovementOutputData;

import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class PickUpItemInteractorTest {

    InBattleDataAccessObject inBattleDataAccessObject;

    int numberOfRevive;

    int numberOfHeal10;

    int numberOfHeal20;

    int numberOfHeal45;

    int healAmount;

    int originalPlayerHealth;
    int playerMaxHealth;
    Bag bag;
    Item item;
    MovementOutputData movementOutputData;
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
        Item revive = new revivePotion();
        int numRevive = random.nextInt(0, 2);
        while (numRevive != 0) {
            player.getBag().addItem(revive);
            numRevive--;
        }
        numberOfRevive = player.getBag().numOfRevive();

        int temp = random.nextInt(1, 5);
        if (temp == 1) {
            item = new healingPotion10();
        } else if (temp == 2) {
            item = new healingPotion20();
        } else if (temp == 3){
            item = new healingPotion45();
        }
        else{item = new revivePotion();}
        MovementOutputData movementOutputData = new MovementOutputData("s", true);
        bag = player.getBag();
    }
    @Test
    void PickUpItemsInteractor(){
        PickUpItemDataAccessInterface pickUpItemDataAccessObject = new PickUpItemDataAccessObject();

        PickUpItemOutputBoundary pickUpItemOutputBoundary = new PickUpItemOutputBoundary() {

            @Override
            public void prepareSuccessView(PickUpItemOutputData pickUpItemOutputData, MovementOutputData movementOutputData) {
                if (item instanceof healingPotion10){
                    pickUpItemDataAccessObject.addItem(bag, item);
                    Assertions.assertEquals(inBattleDataAccessObject.getPlayer().getBag().numOfHeal10(), numberOfHeal10+1);
                }
                else if (item instanceof healingPotion20){
                    pickUpItemDataAccessObject.addItem(bag, item);
                    Assertions.assertEquals(inBattleDataAccessObject.getPlayer().getBag().numOfHeal20(), numberOfHeal20+1);

                }
                else if (item instanceof healingPotion45){
                    pickUpItemDataAccessObject.addItem(bag, item);
                    Assertions.assertEquals(inBattleDataAccessObject.getPlayer().getBag().numOfHeal45(), numberOfHeal45+1);

                }
                else{
                    pickUpItemDataAccessObject.addItem(bag, new revivePotion());
                    Assertions.assertEquals(inBattleDataAccessObject.getPlayer().getBag().numOfHeal45(), numberOfRevive+1);
                }
            }

            @Override
            public void prepareFailView() {

            }

            @Override
            public void back(MovementOutputData movementOutputData) {

            }


        };
    }
}

