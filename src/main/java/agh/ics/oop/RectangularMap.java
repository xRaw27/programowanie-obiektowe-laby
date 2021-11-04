package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    private final Vector2d bottomLeftCorner = new Vector2d(0, 0);
    private final Vector2d topRightCorner;

    private final List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height) {
        this.topRightCorner = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!this.isOccupied(position) && position.precedes(this.topRightCorner) && position.follows(this.bottomLeftCorner));
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (!this.isOccupied(position) && position.precedes(this.topRightCorner) && position.follows(this.bottomLeftCorner)) {
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : this.animals) {
            if (position.equals(animal.getPosition())) return true;
        }
        return false;
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
        return mapVisualizer.draw(this.bottomLeftCorner, this.topRightCorner);
    }
}
