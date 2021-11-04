package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationEngineTest {

    @Test
    public void animalsMoveTest() {
//        Test 1
        List<Vector2d> positions1 = new ArrayList<>(Arrays.asList(new Vector2d(2,2), new Vector2d(3,4)));
        List<MoveDirection> directions1 = new ArrayList<>(Arrays.asList(
                MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD));

        IWorldMap map1 = new RectangularMap(10, 5);
        SimulationEngine engine1 = new SimulationEngine(directions1, map1, positions1);
        engine1.run();

        assertEquals(new ArrayList<>(Arrays.asList(new Vector2d(2,0), new Vector2d(3,5))), engine1.getAnimalsPositions());
        assertEquals(new ArrayList<>(Arrays.asList(MapDirection.SOUTH, MapDirection.NORTH)), engine1.getAnimalsDirections());

//        Test 2
        List<Vector2d> positions2 = new ArrayList<>(Arrays.asList(new Vector2d(4,2), new Vector2d(1,4), new Vector2d(5, 5)));
        List<MoveDirection> directions2 = new ArrayList<>(Arrays.asList(
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.LEFT
        ));

        IWorldMap map2 = new RectangularMap(5, 5);
        SimulationEngine engine2 = new SimulationEngine(directions2, map2, positions2);
        engine2.run();

        assertEquals(new ArrayList<>(Arrays.asList(new Vector2d(4,5), new Vector2d(3,5), new Vector2d(5,5))), engine2.getAnimalsPositions());
        assertEquals(new ArrayList<>(Arrays.asList(MapDirection.WEST, MapDirection.SOUTH, MapDirection.NORTH)), engine2.getAnimalsDirections());

//        Test 3
        List<Vector2d> positions3 = new ArrayList<>(List.of(new Vector2d(4,3)));
        List<MoveDirection> directions3 = new ArrayList<>(Arrays.asList(
                MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD));

        IWorldMap map3 = new RectangularMap(4, 4);
        SimulationEngine engine3 = new SimulationEngine(directions3, map3, positions3);
        engine3.run();

        assertEquals(List.of(new Vector2d(0, 0)), engine3.getAnimalsPositions());
        assertEquals(List.of(MapDirection.WEST), engine3.getAnimalsDirections());
    }
}

//    ---------- inny sposób testowania -----------
//    Animal animal3 = ((Animal) map2.objectAt(new Vector2d(3, 5)));
//    Animal animal4 = ((Animal) map2.objectAt(new Vector2d(4, 5)));
//    Animal animal5 = ((Animal) map2.objectAt(new Vector2d(5, 5)));
//
//    assertEquals(MapDirection.SOUTH, animal3.getDirection());
//    assertEquals(MapDirection.WEST, animal4.getDirection());
//    assertEquals(MapDirection.NORTH, animal5.getDirection());
