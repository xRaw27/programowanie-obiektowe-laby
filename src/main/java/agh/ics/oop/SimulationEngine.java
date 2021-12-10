package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SimulationEngine implements IEngine {
    private final IWorldMap map;
    private final List<MoveDirection> moveDirections;
    private final List<Animal> animals = new ArrayList<>();

    public SimulationEngine(List<MoveDirection> moveDirections, IWorldMap map, List<Vector2d> startingPositions) {
        this.map = map;
        this.moveDirections = moveDirections;

        for (Vector2d startingPosition : startingPositions) {
            Animal animal = new Animal(map, startingPosition);
            if (map.place(animal)) {
                this.animals.add(animal);
            }
        }
    }

    @Override
    public void run() {
        System.out.println(this.moveDirections);
        System.out.println("Pozycja startowa");
        System.out.println(this.map);
        System.out.println("");

        if (!this.animals.isEmpty()) {
            int index = 0;
            for (MoveDirection moveDirection : moveDirections) {
                System.out.println((index + 1) + " " + moveDirection.getMessage());

                this.animals.get(index).move(moveDirection);
                index = (index + 1) % this.animals.size();

                System.out.println(this.map);
                System.out.println("");
            }
        }
    }

    List<Vector2d> getAnimalsPositions() {
        return this.animals.stream()
                .map(Animal::getPosition)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    List<MapDirection> getAnimalsDirections() {
        return this.animals.stream()
                .map(Animal::getDirection)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
