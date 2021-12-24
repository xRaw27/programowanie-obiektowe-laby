package agh.ics.oop.engine;

import agh.ics.oop.map.IMap;

public class NormalSimulationEngine extends AbstractSimulationEngine {
    public NormalSimulationEngine(IMap map, int startEnergy, int moveEnergy, int initialNumberOfAnimals) {
        super(map, startEnergy, moveEnergy, initialNumberOfAnimals);
    }
}
