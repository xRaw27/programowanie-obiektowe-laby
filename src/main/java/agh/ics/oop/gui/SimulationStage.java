package agh.ics.oop.gui;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.*;

public class SimulationStage extends Stage {

//    private final IWorldMap map;
//    private final IEngine engine;
    private final GridPane grid;
    private final Map<String, Image> loadedImages = new HashMap<>();

    public SimulationStage(SimulationProperties simulationProperties) {
        this.setTitle("Symulacja");


        this.grid = new GridPane();
        this.setScene(new Scene(this.grid));
    }

    public void startSimulation() {
//        Thread engineThread = new Thread((Runnable)this.engine);
//        engineThread.start();
    }
}
