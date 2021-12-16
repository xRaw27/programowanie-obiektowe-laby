package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grassTufts = new HashMap<>();
    private final MapBoundary mapBoundary = new MapBoundary(this);
    private final int size;

    public GrassField(int numberOfTufts) {
        this.size = (int) Math.sqrt(4 * numberOfTufts);

        Random randGenerator = new Random();
        Set<Integer> randSet = new LinkedHashSet<>();
        while (randSet.size() < numberOfTufts) {
            randSet.add(randGenerator.nextInt((this.size + 1) * (this.size + 1)));
        }

        for (Integer x : randSet) {
            Vector2d grassPosition = new Vector2d(x % (size + 1), x / (size + 1));
            this.grassTufts.put(grassPosition, new Grass(grassPosition));
            this.mapBoundary.addPositionVector(grassPosition);
        }
    }

    private void grassHasBeenEaten(Vector2d oldPosition) {
        this.grassTufts.remove(oldPosition);

        Random randGenerator = new Random();
        Vector2d newPosition = oldPosition;
        while (isOccupied(newPosition)) {
            int x = randGenerator.nextInt((this.size + 1) * (this.size + 1));
            newPosition = new Vector2d(x % (size + 1), x / (size + 1));
        }

        System.out.println("Trawa zjedzona na pozycji " + oldPosition + "\nNowa trawa wyrosła na pozycji " + newPosition);
        this.grassTufts.put(newPosition, new Grass(newPosition));
        this.mapBoundary.positionChanged(oldPosition, newPosition);
    }

    public void mapBoundariesChanged() {
        this.bottomLeftCorner = this.mapBoundary.getBottomLeftCorner();
        this.topRightCorner = this.mapBoundary.getTopRightCorner();
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        super.positionChanged(oldPosition, newPosition);
        if (this.grassTufts.get(newPosition) != null) {
            this.grassHasBeenEaten(newPosition);
        }
    }

    @Override
    public boolean place(Animal animal) {
        super.place(animal);
        Vector2d position = animal.getPosition();
        if (this.grassTufts.get(position) != null) {
            this.grassHasBeenEaten(position);
        }
        this.mapBoundary.addPositionVector(position);
        animal.addObserver(this.mapBoundary);
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object != null) return object;

        return this.grassTufts.get(position);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
