package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void rotateTest() {
        assertEquals(MapDirection.NORTH, MapDirection.WEST.rotate(2));
        assertEquals(MapDirection.NORTHEAST, MapDirection.SOUTH.rotate(5));
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.rotate(6));
        assertEquals(MapDirection.SOUTHEAST, MapDirection.SOUTHEAST.rotate(0));
        assertEquals(MapDirection.SOUTH, MapDirection.SOUTHEAST.rotate(1));
        assertEquals(MapDirection.SOUTHWEST, MapDirection.WEST.rotate(7));
        assertEquals(MapDirection.WEST, MapDirection.WEST.rotate(8));
        assertEquals(MapDirection.NORTHWEST, MapDirection.SOUTH.rotate(3));
    }
}
