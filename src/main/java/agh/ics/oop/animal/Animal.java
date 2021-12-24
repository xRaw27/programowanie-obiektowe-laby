package agh.ics.oop.animal;

import agh.ics.oop.*;
import agh.ics.oop.map.IMap;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement, Comparable<Animal> {
    public final int id;

    private final IMap map;
    private final Genotype genotype;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    private Vector2d position;
    private MapDirection direction;
    private int energy;

    public Animal(int id, IMap map, Vector2d initialPosition, int startEnergy) {
        this.id = id;
        this.map = map;
        this.genotype = new Genotype();
        this.position = initialPosition;
        this.direction = MapDirection.randomDirection();
        this.energy = startEnergy;
    }

    public Animal(int id, IMap map, Animal animal1, Animal animal2) {
        this.id = id;
        this.map = map;
        this.genotype = new Genotype(animal1.genotype, animal2.genotype, Math.round((float) animal1.energy * 32 / ( animal1.energy + animal2.energy)));
        this.position = animal1.position;
        this.direction = MapDirection.randomDirection();
        this.energy = animal1.energy / 4 + animal2.energy / 4;
//        Integer essa = animal1.energy + animal2.energy;
//        System.out.println(animal1.energy);
//        System.out.println(animal1.energy / 4);
//        System.out.println(animal2.energy);
//        System.out.println(animal2.energy / 4);
//
//        System.out.println(Math.round((float) animal1.energy * 32 / ( animal1.energy + animal2.energy)));

//        this.genotype = new Genotype(animal1.genotype, animal2.genotype);

    }

    public void move(int moveEnergy) {
        int moveDirection = this.genotype.randomGene();

        this.energy -= moveEnergy;

        System.out.println(moveDirection);

        switch (moveDirection) {
            case 0 -> {
                Vector2d newPosition = this.position.add(this.direction.toUnitVector());
                this.updatePosition(newPosition);
            }
            case 4 -> {
                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());
                this.updatePosition(newPosition);
            }
            default -> this.direction = this.direction.rotate(moveDirection);
        }
    }

//    public int getEnergy() {
//        return energy;
//    }

    private void updatePosition(Vector2d newPosition) {
        this.position = newPosition;
//        if (this.map.canMoveTo(newPosition)) {
//            Vector2d oldPosition = this.position;
//            this.position = newPosition;
//            this.observers.forEach(observer -> observer.positionChanged(oldPosition, newPosition));
//        }
    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observers.removeIf(observer::equals);
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getDirection() {
        return this.direction;
    }

    @Override
    public String getLabel() {
        return direction.getSymbol() + this.position;
    }

    @Override
    public String getImageSrc() {
        return direction.getImageSrc();
    }

    @Override
    public String toString() {
//        return "id = " + this.id + ", position = " + this.position + ", direction = " + this.direction + ", energy = " + this.energy + ", genotype = " + this.genotype;
        return "id = " + this.id + ", position = " + this.position + ", direction = " + this.direction + ", energy = " + this.energy;
//        return "position = " + this.position + ", energy = " + this.energy + ", genotype = " + this.genotype;
//        return direction.getSymbol();
    }

    @Override
    public int compareTo(Animal other) {
        int energyCompare = Integer.compare(this.energy, other.energy);

        if (energyCompare == 0) {
            return Integer.compare(this.id, other.id);
        }
        else {
            return energyCompare;
        }
    }
}
