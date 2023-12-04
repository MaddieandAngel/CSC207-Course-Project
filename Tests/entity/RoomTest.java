package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    Room room;

    @BeforeEach
    void setUp() {
        room = new Room();
    }

    @Test
    void isHasNorth() {
        assertFalse(room.isHasNorth());
    }

    @Test
    void isHasEast() {
        assertFalse(room.isHasEast());
    }

    @Test
    void isHasSouth() {
        assertFalse(room.isHasSouth());
    }

    @Test
    void isHasWest() {
        assertFalse(room.isHasWest());
    }

    @Test
    void isHasStairs() {
        assertFalse(room.isHasStairs());
    }

    @Test
    void isHasEnemy() {
        assertFalse(room.isHasEnemy());
    }

    @Test
    void isHasItem() {
        assertFalse(room.isHasItem());
    }

    @Test
    void isHasBeenSearched() {
        assertFalse(room.isHasBeenSearched());
    }

    @Test
    void setHasNorth() {
        room.setHasNorth(true);
        assert room.isHasNorth();
    }

    @Test
    void setHasEast() {
        room.setHasEast(true);
        assert room.isHasEast();
    }

    @Test
    void setHasSouth() {
        room.setHasSouth(true);
        assert room.isHasSouth();
    }

    @Test
    void setHasWest() {
        room.setHasWest(true);
        assert room.isHasWest();
    }

    @Test
    void setHasStairs() {
        room.setHasStairs(true);
        assert room.isHasStairs();
    }

    @Test
    void setHasEnemy() {
        room.setHasEnemy(true);
        assert room.isHasEnemy();
    }

    @Test
    void setHasItem() {
        room.setHasItem(true);
        assert room.isHasItem();
    }

    @Test
    void setHasBeenSearched() {
        room.setHasBeenSearched(true);
        assert room.isHasBeenSearched();
    }
}