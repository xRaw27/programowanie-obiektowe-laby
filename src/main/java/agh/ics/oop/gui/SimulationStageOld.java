package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class SimulationStageOld extends Stage {

    private final IWorldMap map;
//    private final IEngine engine;
    private final GridPane grid;
    private final Map<String, Image> loadedImages = new HashMap<>();

    public SimulationStageOld(String[] args) {
        this.setTitle("Symulacja");

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(5,5), new Vector2d(7,6), new Vector2d(0,0), new Vector2d(2,2)));
        this.map = new GrassField(30);
//        this.engine = new SimulationEngineGUI(directions, this.map, positions, this);

        this.grid = new GridPane();
        this.setScene(new Scene(this.grid));
    }

    public void startSimulation() {
//        Thread engineThread = new Thread((Runnable)this.engine);
//        engineThread.start();
    }

    private void prepareGridPane() {
        this.grid.getChildren().clear();
        this.grid.getColumnConstraints().clear();
        this.grid.getRowConstraints().clear();

        this.grid.setGridLinesVisible(false);
        this.grid.setGridLinesVisible(true);

        this.grid.add(new Label("y/x"), 0, 0, 1, 1);
    }

    public void drawMap(Vector2d bottomLeftCorner, Vector2d topRightCorner) {
        this.prepareGridPane();

        ColumnConstraints cc = new ColumnConstraints(60);
        cc.setHalignment(HPos.CENTER);
        RowConstraints rc = new RowConstraints(60);
        rc.setValignment(VPos.CENTER);

        this.grid.getColumnConstraints().add(cc);
        for (int i = bottomLeftCorner.x; i <= topRightCorner.x; i++) {
            this.grid.getColumnConstraints().add(cc);
            this.grid.add(new Label(String.valueOf(i)), i - bottomLeftCorner.x + 1, 0, 1, 1);
        }

        this.grid.getRowConstraints().add(rc);
        for (int i = topRightCorner.y; i >= bottomLeftCorner.y; i--) {
            this.grid.getRowConstraints().add(rc);
            this.grid.add(new Label(String.valueOf(i)), 0, topRightCorner.y - i + 1, 1, 1);
        }

        for (int i = bottomLeftCorner.x; i <= topRightCorner.x; i++) {
            for (int j = bottomLeftCorner.y; j <= topRightCorner.y; j++) {
                Vector2d position = new Vector2d(i, j);
                if (this.map.isOccupied(position)) {
                    VBox vbox = new GuiElementBox((IMapElement)this.map.objectAt(position), this.loadedImages);
                    this.grid.add(vbox, i - bottomLeftCorner.x + 1, topRightCorner.y - j + 1, 1, 1);
                }
            }
        }
    }
}
