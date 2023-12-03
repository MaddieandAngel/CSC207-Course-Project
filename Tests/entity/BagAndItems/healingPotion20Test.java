package entity.BagAndItems;

import entity.ActivePlayerFactory;
import entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealingPotion20Test {

    Player player;

    healingPotion20 heal;

    @BeforeEach
    void setUp() {
        player = new ActivePlayerFactory().create();
        player.levelUp(); // max health is now 30
        player.setHealth(10);
        heal = new healingPotion20();
    }


    @Test
    void heal() {
        heal.heal(player);
        assertEquals(player.getCurrentHealth(), 16);
    }

    @Test
    void usage() {
        assertEquals(heal.usage(), "This potion heals 20% of your maxHealth.");
    }

    @Test
    void getName() {
        assertEquals(heal.getName(), "HealingPotion(20%)");
    }
}