package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    protected Vector2d bottomLeftCorner;
    protected Vector2d topRightCorner;

    protected final List<Animal> animals = new ArrayList<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal animal : this.animals) {
            if (position.equals(animal.getPosition())) return false;
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (this.canMoveTo(position)) {
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : this.animals) {
            if (position.equals(animal.getPosition())) return animal;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.mapVisualizer.draw(this.bottomLeftCorner, this.topRightCorner);
    }
}
