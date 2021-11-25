package agh.ics.oop;

import java.util.*;
import java.util.stream.Stream;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grassTufts = new HashMap<>();

    public GrassField(int numberOfTufts) {
        int size = (int) Math.sqrt(10 * numberOfTufts);

        Random randGenerator = new Random();
        Set<Integer> randSet = new LinkedHashSet<>();
        while (randSet.size() < numberOfTufts) {
            randSet.add(randGenerator.nextInt((size + 1) * (size + 1)));
        }

        for (Integer x : randSet) {
            Vector2d grassPosition = new Vector2d(x % (size + 1), x / (size + 1));
            this.grassTufts.put(grassPosition, new Grass(grassPosition));
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object != null) return object;

        return this.grassTufts.get(position);
    }

    @Override
    public String toString() {
        this.bottomLeftCorner = this.topRightCorner = this.grassTufts.keySet().iterator().next();

        Stream.concat(this.animals.keySet().stream(), this.grassTufts.keySet().stream())
                .forEach(position -> {
                    this.bottomLeftCorner = this.bottomLeftCorner.lowerLeft(position);
                    this.topRightCorner = this.topRightCorner.upperRight(position);
                });

        return super.toString();
    }
}
