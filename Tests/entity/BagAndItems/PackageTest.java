package entity.BagAndItems;

import entity.ActivePlayerFactory;
import entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageTest {

    Package bag;

    Player player;

    @BeforeEach
    void setUp() {
        bag = new Package();
        player = new ActivePlayerFactory().create();
        player.levelUp(); // max health is now 30
        player.setHealth(10);
    }

    @Test
    void isFull() {
        assertFalse(bag.isFull());
    }

    @Test
    void addItem() {
        Item item = new healingPotion10();
        bag.addItem(item);
        assertEquals(bag.numOfItemsTotal(), 1);
        assertEquals(bag.numOfHeal10(), 1);
    }

    @Test
    void levelUpBag() {
        bag.levelUpBag();
        for (int i = 0; i < 7; i++) {
            bag.addItem(new healingPotion45());
        }
        // when level increases from 0 to 1 bag will be full when there are 7 items in the bag
        assert bag.isFull();
    }

    @Test
    void useItem() {
        bag.addItem(new healingPotion10());
        bag.useItem(10, player);
        assertEquals(player.getCurrentHealth(), 13);
        assertEquals(bag.numOfHeal10(), 0);
    }

    @Test
    void useItemNoItem() {
        assertFalse(bag.useItem(0, player));
    }

    @Test
    void dropItem() {
        bag.addItem(new healingPotion20());
        bag.dropItem(20);
        assertEquals(bag.numOfHeal20(), 0);
    }

    @Test
    void dropItemNoItem() {
        assertFalse(bag.dropItem(10));
    }

    @Test
    void numOfItemsTotal() {
        bag.addItem(new healingPotion10());
        bag.addItem(new healingPotion20());
        bag.addItem(new healingPotion45());
        bag.addItem(new revivePotion());
        assertEquals(bag.numOfItemsTotal(), 4);
    }

    @Test
    void numOfHeal10() {
        bag.addItem(new healingPotion10());
        assertEquals(bag.numOfHeal10(), 1);
    }

    @Test
    void numOfHeal20() {
        bag.addItem(new healingPotion20());
        assertEquals(bag.numOfHeal20(), 1);
    }

    @Test
    void numOfHeal45() {
        bag.addItem(new healingPotion45());
        bag.addItem(new healingPotion45());
        assertEquals(bag.numOfHeal45(), 2);
    }

    @Test
    void numOfRevive() {
        bag.addItem(new revivePotion());
        assertEquals(bag.numOfRevive(), 1);
    }
}