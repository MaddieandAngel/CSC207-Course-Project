package entity.BagAndItems;

import entity.ActivePlayerFactory;
import entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealingPotion45Test {

    Player player;

    healingPotion45 heal;

    @BeforeEach
    void setUp() {
        player = new ActivePlayerFactory().create();
        player.levelUp();
        player.levelUp(); // max health is now 45
        player.setHealth(10);
        heal = new healingPotion45();
    }

    @Test
    void heal() {
        heal.heal(player);
        assertEquals(player.getCurrentHealth(), 30);
    }

    @Test
    void usage() {
        assertEquals(heal.usage(), "This potion heals 45% of your maxHealth.");
    }

    @Test
    void getName() {
        assertEquals(heal.getName(), "HealingPotion(45%)");
    }
}