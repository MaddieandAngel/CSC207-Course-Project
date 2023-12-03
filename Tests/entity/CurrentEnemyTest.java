package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentEnemyTest {

    CurrentEnemy enemy;

    @BeforeEach
    void setUp() {
        enemy = new CurrentEnemy(5, 3);
    }

    @Test
    void getLevel() {
        assertEquals(enemy.getLevel(), 3);
    }

    @Test
    void getCurrentHealth() {
        assertEquals(enemy.getCurrentHealth(), 45);
    }

    @Test
    void setHealth() {
        enemy.setHealth(72);
        assertEquals(enemy.getCurrentHealth(), 72);
    }

    @Test
    void getName() {
        assertEquals(enemy.getName(), "Greater Omni Mage");
    }

    @Test
    void getPreferredSuit() {
        assertEquals(enemy.getPreferredSuit(), '\0');
    }

    @Test
    void getMinimumPreferredValue() {
        assertEquals(enemy.getMinimumPreferredValue(), 7);
    }

    @Test
    void getMaximumPreferredValue() {
        assertEquals(enemy.getMaximumPreferredValue(), 15);
    }
}