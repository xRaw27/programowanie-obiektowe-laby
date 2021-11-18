package agh.ics.oop;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private final List<Grass> grassTufts = new ArrayList<>();

    public GrassField(int numberOfTufts) {
        int size = (int)Math.sqrt(10 * numberOfTufts);

        Random randGenerator = new Random();
        Set<Integer> randSet = new LinkedHashSet<>();
        while (randSet.size() < numberOfTufts) {
            randSet.add(randGenerator.nextInt((size + 1) * (size + 1)));
        }

        for (Integer x : randSet) {
            this.grassTufts.add(new Grass(new Vector2d(x % (size + 1), x / (size + 1))));
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object != null) return object;

        for (Grass grassTuft : this.grassTufts) {
            if (position.equals(grassTuft.getPosition())) return grassTuft;
        }
        return null;
    }

    @Override
    public String toString() {
        this.bottomLeftCorner = this.animals.get(0).getPosition();
        this.topRightCorner = this.animals.get(0).getPosition();

        for (Animal animal : this.animals) {
            this.bottomLeftCorner = this.bottomLeftCorner.lowerLeft(animal.getPosition());
            this.topRightCorner = this.topRightCorner.upperRight(animal.getPosition());
        }
        for (Grass grassTuft : this.grassTufts) {
            this.bottomLeftCorner = this.bottomLeftCorner.lowerLeft(grassTuft.getPosition());
            this.topRightCorner = this.topRightCorner.upperRight(grassTuft.getPosition());
        }

        return super.toString();
    }
}
