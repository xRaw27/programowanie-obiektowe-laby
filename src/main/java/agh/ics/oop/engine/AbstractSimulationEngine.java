package agh.ics.oop.engine;

import agh.ics.oop.animal.Animal;
import agh.ics.oop.map.IMap;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractSimulationEngine implements IEngine {

    private final IMap map;
    private final int startEnergy;
    private final int moveEnergy;
    private final int initialNumberOfAnimals;

    private int currentNumberOfAnimals = 0;
    private final List<Animal> animals = new ArrayList<>();

    public AbstractSimulationEngine(IMap map, int startEnergy, int moveEnergy, int initialNumberOfAnimals) {
        this.map = map;
        this.startEnergy = startEnergy;
        this.moveEnergy = moveEnergy;
        this.initialNumberOfAnimals = initialNumberOfAnimals;

        System.out.println("silnik rusza");
        this.randomPlace(initialNumberOfAnimals);

    }

    private void randomPlace(int numberOfAnimalsToAdd) {
        while (numberOfAnimalsToAdd > 0) {
            Animal newAnimal = new Animal(this.currentNumberOfAnimals + 1, this.map, this.map.randomUnoccupiedMapPosition(), this.startEnergy);

            this.map.place(newAnimal);
            this.animals.add(newAnimal);
            this.currentNumberOfAnimals += 1;
            numberOfAnimalsToAdd -= 1;
        }
    }

    private void moveAnimals() {
        for (Animal animal : this.animals) {
            animal.move(this.moveEnergy);
        }
    }

    @Override
    public void run() {
//        System.out.println(this.map);
//        System.out.println("");

//        Platform.runLater(() -> {
//            this.gui.drawMap(((AbstractWorldMap)this.map).bottomLeftCorner, ((AbstractWorldMap)this.map).topRightCorner);
//        });
        System.out.println("RUN");

//        while (true) {
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.moveAnimals();

            for (Animal animal : this.animals) {
                System.out.println(animal);
            }
        }
    }
}
