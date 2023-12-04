package entity.BagAndItems;

import entity.ActivePlayerFactory;
import entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RevivePotionTest {

    Player player;

    revivePotion heal;

    @BeforeEach
    void setUp() {
        player = new ActivePlayerFactory().create();
        player.levelUp(); // max health is now 30;
        player.setHealth(0);
        heal = new revivePotion();
    }

    @Test
    void heal() {
        heal.heal(player);
        assertEquals(player.getCurrentHealth(), player.getMaxHealth());
    }

    @Test
    void usage() {
        assertEquals(heal.usage(), "This potion will automatically be used when you failed, and will heal you to your max HP");
    }

    @Test
    void getName() {
        assertEquals(heal.getName(), "RevivePotion");
    }
}