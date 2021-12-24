package agh.ics.oop.gui;

import agh.ics.oop.engine.EngineType;
import agh.ics.oop.map.MapType;

public class SimulationProperties {

    private final MenuStage menu;

    private int mapWidth;
    private int mapHeight;
    private int jungleWidth;
    private int jungleHeight;
    private MapType mapType;

    private int startEnergy;
    private int moveEnergy;
    private int plantEnergy;

    private int initialNumberOfAnimals;
    private int grassSpawnEachDay;
    private EngineType engineType;

    public SimulationProperties(MenuStage menu) {
        this.menu = menu;
        this.parseProperties();

        System.out.println(this.mapWidth);
        System.out.println(this.mapHeight);
        System.out.println(this.jungleWidth);
        System.out.println(this.jungleHeight);
        System.out.println(this.mapType);

        System.out.println(this.startEnergy);
        System.out.println(this.moveEnergy);
        System.out.println(this.plantEnergy);

        System.out.println(this.initialNumberOfAnimals);
        System.out.println(this.grassSpawnEachDay);
        System.out.println(this.engineType);
    }

    private void parseProperties() {
        this.mapWidth = Integer.parseInt(this.menu.mapWidthTextField.getText());
        this.mapHeight = Integer.parseInt(this.menu.mapHeightTextField.getText());
        if (this.mapWidth < 3) {
            throw new IllegalArgumentException("The map width given is too small");
        }
        if (this.mapHeight < 3 ) {
            throw new IllegalArgumentException("The map height given is too small");
        }

        float ratio = Float.parseFloat(this.menu.jungleRatioTextField.getText());
        this.jungleWidth = (int) Math.round(this.mapWidth * Math.sqrt(ratio));
        this.jungleHeight = (int) Math.round(this.mapHeight * Math.sqrt(ratio));
        if (this.jungleWidth <= 0 || this.jungleHeight <= 0) {
            throw new IllegalArgumentException("The jungle ratio given is too small to create the map");
        }
        if (this.jungleWidth >= this.mapWidth || this.jungleHeight >= this.mapHeight ) {
            throw new IllegalArgumentException("The jungle ratio given is too big to create the map");
        }

        this.startEnergy = Integer.parseInt(this.menu.startEnergyTextField.getText());
        this.moveEnergy = Integer.parseInt(this.menu.moveEnergyTextField.getText());
        this.plantEnergy = Integer.parseInt(this.menu.plantEnergyTextField.getText());
        if (this.startEnergy <= 0 || this.moveEnergy <= 0 || this.plantEnergy <= 0) {
            throw new IllegalArgumentException("All energy properties must be greater than 0");
        }

        this.initialNumberOfAnimals = Integer.parseInt(this.menu.initialNumberOfAnimalsTextField.getText());
        if (this.initialNumberOfAnimals <= 0) {
            throw new IllegalArgumentException("The initial number of animals must be greater than 0");
        }

        this.grassSpawnEachDay = Integer.parseInt(this.menu.grassSpawnEachDayTextField.getText());
        if (this.grassSpawnEachDay <= 0) {
            throw new IllegalArgumentException("The number of grass spawn each day must be greater than 0");
        }

        this.mapType = (MapType) this.menu.mapTypeToggleGroup.getSelectedToggle().getUserData();
        this.engineType = (EngineType) this.menu.evolutionTypeToggleGroup.getSelectedToggle().getUserData();
    }
}
