package agh.ics.oop;

import agh.ics.oop.gui.App;
import agh.ics.oop.gui.SimulationStage;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SimulationEngineGUI implements IEngine, Runnable{
    private final IWorldMap map;
    private final List<MoveDirection> moveDirections;
    private final List<Animal> animals = new ArrayList<>();
    private final SimulationStage gui;

    public SimulationEngineGUI(List<MoveDirection> moveDirections, IWorldMap map, List<Vector2d> startingPositions, SimulationStage gui) {
        this.map = map;
        this.moveDirections = moveDirections;
        this.gui = gui;

        for (Vector2d startingPosition : startingPositions) {
            Animal animal = new Animal(map, startingPosition);
            if (map.place(animal)) {
                this.animals.add(animal);
            }
        }
    }

    @Override
    public void run() {
//        System.out.println(this.map);
//        System.out.println("");

        Platform.runLater(() -> {
            this.gui.drawMap(((AbstractWorldMap)this.map).bottomLeftCorner, ((AbstractWorldMap)this.map).topRightCorner);
        });


        if (!this.animals.isEmpty()) {
            int index = 0;
            for (MoveDirection moveDirection : moveDirections) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                System.out.println((index + 1) + " " + moveDirection.getMessage());

                this.animals.get(index).move(moveDirection);
                index = (index + 1) % this.animals.size();

//                System.out.println(this.map);
//                System.out.println("");

                Platform.runLater(() -> {
                    this.gui.drawMap(((AbstractWorldMap)this.map).bottomLeftCorner, ((AbstractWorldMap)this.map).topRightCorner);
                });
            }
        }
    }
}
