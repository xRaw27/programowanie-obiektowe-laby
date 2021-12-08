package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    protected Vector2d bottomLeftCorner;
    protected Vector2d topRightCorner;

    protected final Map<Vector2d, Animal> animals = new HashMap<>();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.animals.put(newPosition, this.animals.remove(oldPosition));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.animals.containsKey(position);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (this.canMoveTo(position)) {
            this.animals.put(position, animal);
            animal.addObserver(this);
            return true;
        }
        throw new IllegalArgumentException("Cannot place animal at position: " + animal.getPosition() + ". This position is already occupied.");
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.animals.get(position);
    }

    @Override
    public String toString() {
        return this.mapVisualizer.draw(this.bottomLeftCorner, this.topRightCorner);
    }
}
