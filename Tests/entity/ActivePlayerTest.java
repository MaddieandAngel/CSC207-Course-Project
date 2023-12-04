package entity;

import entity.BagAndItems.Bag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivePlayerTest {

    ActivePlayer player;

    @BeforeEach
    void setUp() {
        // Will create an instance of ActivePlayer with the predetermined values
        player = new ActivePlayer();
    }

    @Test
    void getLevel() {
        assertEquals(player.getLevel(), 1);
    }

    @Test
    void getCurrentHealth() {
        assertEquals(player.getCurrentHealth(), 15);
    }

    @Test
    void getMaxHealth() {
        assertEquals(player.getMaxHealth(), 15);
    }

    @Test
    void setHealth() {
        player.setHealth(50);
        assertEquals(player.getCurrentHealth(), 50);
    }

    @Test
    void levelUp() {
        player.levelUp();
        assertEquals(player.getLevel(), 2);

    }

    @Test
    void getExperiencePoints() {
        assertEquals(player.getExperiencePoints(), 0);
    }

    @Test
    void setExperiencePoints() {
        player.setExperiencePoints(39);
        assertEquals(player.getExperiencePoints(), 39);
    }

    @Test
    void getMaxCardHold() {
        assertEquals(player.getMaxCardHold(), 5);
    }

    @Test
    void setMaxCardHold() {
        player.setMaxCardHold(3);
        assertEquals(player.getMaxCardHold(), 3);
    }

    @Test
    void getBag() {
        assert player.getBag() != null;
    }
}