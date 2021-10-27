package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    @Test
    public void moveTest() {
        Animal testAnimal1 = new Animal();
        assertEquals(true, testAnimal1.isPositionAndDirectionEqual(new Vector2d(2, 2), MapDirection.NORTH));

        World.run(new ArrayList<>(List.of(MoveDirection.FORWARD)), testAnimal1);
        assertEquals(true, testAnimal1.isPositionAndDirectionEqual(new Vector2d(2, 3), MapDirection.NORTH));

        World.run(new ArrayList<>(List.of(MoveDirection.RIGHT)), testAnimal1);
        assertEquals(true, testAnimal1.isPositionAndDirectionEqual(new Vector2d(2, 3), MapDirection.EAST));

        World.run(new ArrayList<>(List.of(MoveDirection.BACKWARD)), testAnimal1);
        assertEquals(true, testAnimal1.isPositionAndDirectionEqual(new Vector2d(1, 3), MapDirection.EAST));

        World.run(new ArrayList<>(List.of(MoveDirection.LEFT)), testAnimal1);
        assertEquals(true, testAnimal1.isPositionAndDirectionEqual(new Vector2d(1, 3), MapDirection.NORTH));

        World.run(new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD)), testAnimal1);
        assertEquals(true, testAnimal1.isPositionAndDirectionEqual(new Vector2d(1, 4), MapDirection.NORTH));

        World.run(new ArrayList<>(Arrays.asList(MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD)), testAnimal1);
        assertEquals(true, testAnimal1.isPositionAndDirectionEqual(new Vector2d(4, 3), MapDirection.SOUTH));

        World.run(new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD)), testAnimal1);
        assertEquals(true, testAnimal1.isPositionAndDirectionEqual(new Vector2d(0, 0), MapDirection.WEST));


        Animal testAnimal2 = new Animal();
        assertEquals(true, testAnimal2.isPositionAndDirectionEqual(new Vector2d(2, 2), MapDirection.NORTH));

        ArrayList<MoveDirection> moveDirections = OptionsParser.parse(new String[]{"f", "f", "f", "f", "l", "b", "b", "b", "r", "r", "r", "f", "f", "r", "f", "f", "l", "b", "l", "f", "l"});
        World.run(moveDirections, testAnimal2);
        assertEquals(true, testAnimal2.isPositionAndDirectionEqual(new Vector2d(3, 3), MapDirection.NORTH));
    }
}
