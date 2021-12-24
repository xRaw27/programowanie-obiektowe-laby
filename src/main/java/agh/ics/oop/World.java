package agh.ics.oop;

import agh.ics.oop.animal.Animal;
import agh.ics.oop.engine.IEngine;
import agh.ics.oop.engine.NormalSimulationEngine;
import agh.ics.oop.map.BorderedMap;
import agh.ics.oop.map.IMap;

import java.util.*;

public class World {

    public static void main(String[] args) {
//        try {
////            List<MoveDirection> directions = OptionsParser.parse(args);
////            IWorldMap map = new RectangularMap(10, 5);
////
////            List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2,2), new Vector2d(3,4)));
////
////            IEngine engine = new SimulationEngine(directions, map, positions);
////            engine.run();
//
//            List<MoveDirection> directions = OptionsParser.parse(args);
//            IWorldMap map = new GrassField(10);
//
//            List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(5,5), new Vector2d(7,6)));
//
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//
//        } catch(IllegalArgumentException ex) {
//            System.out.println(ex.getMessage());
//        }

//        App.main(args);

//        Genotype g1 = new Genotype();
//        Genotype g2 = new Genotype();


//
//        Random random = new Random();

//        IMap map = new BorderedMap(19, 10, 4, 8);

        IMap map = new BorderedMap(8, 9, 4, 6);
        IEngine engine = new NormalSimulationEngine(map, 10, 1, 5);

        engine.run();

//        System.out.println(map.randomUnoccupiedMapPosition());
//        System.out.println(map.randomUnoccupiedMapPosition());
//        System.out.println(map.randomUnoccupiedMapPosition());
//        System.out.println(map.randomUnoccupiedMapPosition());
//        System.out.println(map.randomUnoccupiedMapPosition());
//        System.out.println(map.randomUnoccupiedMapPosition());


//        System.out.println(map.randomUnoccupiedJunglePosition());
//        System.out.println(map.randomUnoccupiedJunglePosition());

//        Animal animal1 = new Animal(1, map, new Vector2d(1, 1), 33);
//        Animal animal2 = new Animal(2,map, new Vector2d(2, 2), 33);
//        Animal animal3 = new Animal(3, map, animal1, animal2);
//
//        System.out.println(animal1);
//        System.out.println(animal2);
//        System.out.println(animal3);


//        animal3.move(moveEnergy);
//        System.out.println(animal3);
//
//        animal3.move(moveEnergy);
//        System.out.println(animal3);
//
//        animal3.move(moveEnergy);
//        System.out.println(animal3);
//
//        animal3.move(moveEnergy);
//        System.out.println(animal3);
//
//        animal3.move(moveEnergy);
//        System.out.println(animal3);

//        System.out.println(Integer.compare(1, 2));

//        SortedSet<Animal> essa = new TreeSet<>();
//        essa.add(animal1);
//        essa.add(animal2);
//        essa.add(animal3);
//
//        System.out.println(essa);
//
//        System.out.println(essa.size());
//
//        System.out.println(essa.last());
//
//        System.out.println(essa);


    }
}

// [0, 0, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7]
// [0, 0, 0, 0, 1, 1, 1, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7]
// [0, 0, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7]