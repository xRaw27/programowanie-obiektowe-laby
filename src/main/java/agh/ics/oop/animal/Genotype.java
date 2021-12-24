package agh.ics.oop.animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Genotype {
    private final List<Integer> genes;

    public Genotype() {
        this.genes = (new Random()).ints(32, 0, 8).sorted().boxed().collect(Collectors.toList());
    }

    public Genotype(Genotype genotype1, Genotype genotype2, int firstPartSize) {
        this.genes = new ArrayList<>(genotype2.genes);

        int lowerBound = 0;
        int upperBound = firstPartSize;
        if ((new Random()).nextBoolean()) {
            lowerBound = 32 - firstPartSize;
            upperBound = 32;
        }

        for (int i = lowerBound; i < upperBound; i++) {
            this.genes.set(i, genotype1.genes.get(i));
        }
        Collections.sort(this.genes);
    }

    public int randomGene() {
        return this.genes.get((new Random()).nextInt(32));
    }

    @Override
    public String toString() {
        return this.genes.toString();
    }
}
