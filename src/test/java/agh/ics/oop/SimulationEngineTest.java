package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimulationEngineTest {

    @Test
    public void rectangularMapAnimalsMoveTest() {
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

//        Test 4
        List<Vector2d> positions4 = new ArrayList<>(Arrays.asList(new Vector2d(4,2), new Vector2d(1,4), new Vector2d(5, 5), new Vector2d(1,4)));
        List<MoveDirection> directions4 = new ArrayList<>(Arrays.asList(MoveDirection.LEFT, MoveDirection.LEFT));

        IWorldMap map4 = new RectangularMap(10, 14);
        IllegalArgumentException thrown4 = assertThrows(IllegalArgumentException.class, () -> {
            SimulationEngine engine4 = new SimulationEngine(directions4, map4, positions4);
        });
        assertEquals("Cannot place animal at position: (1,4). This position is already occupied.", thrown4.getMessage());
    }

    @Test
    public void grassFieldAnimalsMoveTest() {
//        Test 1
        List<Vector2d> positions1 = new ArrayList<>(Arrays.asList(new Vector2d(2,2), new Vector2d(3,4)));
        List<MoveDirection> directions1 = new ArrayList<>(Arrays.asList(
                MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD));

        IWorldMap map1 = new GrassField(10);
        SimulationEngine engine1 = new SimulationEngine(directions1, map1, positions1);
        engine1.run();

        assertEquals(new ArrayList<>(Arrays.asList(new Vector2d(2,-1), new Vector2d(3,7))), engine1.getAnimalsPositions());
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

        IWorldMap map2 = new GrassField(30);
        SimulationEngine engine2 = new SimulationEngine(directions2, map2, positions2);
        engine2.run();

        assertEquals(new ArrayList<>(Arrays.asList(new Vector2d(4,7), new Vector2d(5,5), new Vector2d(1,6))), engine2.getAnimalsPositions());
        assertEquals(new ArrayList<>(Arrays.asList(MapDirection.WEST, MapDirection.SOUTH, MapDirection.NORTH)), engine2.getAnimalsDirections());

//        Test 3
        List<Vector2d> positions3 = new ArrayList<>(List.of(new Vector2d(4,3)));
        List<MoveDirection> directions3 = new ArrayList<>(Arrays.asList(
                MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD));

        IWorldMap map3 = new GrassField(20);
        SimulationEngine engine3 = new SimulationEngine(directions3, map3, positions3);
        engine3.run();

        assertEquals(List.of(new Vector2d(-2, -3)), engine3.getAnimalsPositions());
        assertEquals(List.of(MapDirection.WEST), engine3.getAnimalsDirections());

//        Test 4
        List<Vector2d> positions4 = new ArrayList<>(Arrays.asList(new Vector2d(4,2), new Vector2d(1,4), new Vector2d(5, 5), new Vector2d(1,4)));
        List<MoveDirection> directions4 = new ArrayList<>(Arrays.asList(MoveDirection.LEFT, MoveDirection.LEFT));

        IWorldMap map4 = new GrassField(20);
        IllegalArgumentException thrown4 = assertThrows(IllegalArgumentException.class, () -> {
            SimulationEngine engine4 = new SimulationEngine(directions4, map4, positions4);
        });
        assertEquals("Cannot place animal at position: (1,4). This position is already occupied.", thrown4.getMessage());
    }

}

