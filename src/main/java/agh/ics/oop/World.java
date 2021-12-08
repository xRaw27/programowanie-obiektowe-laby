package agh.ics.oop;

import java.util.*;

public class World {

    public static void main(String[] args) {
        try {
//            List<MoveDirection> directions = OptionsParser.parse(args);
//            IWorldMap map = new RectangularMap(10, 5);
//
//            List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2,2), new Vector2d(3,4)));
//
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();

            List<MoveDirection> directions = OptionsParser.parse(args);
            IWorldMap map = new GrassField(10);

            List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(5,5), new Vector2d(7,6)));

            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

        } catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
