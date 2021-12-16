package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class App extends Application {
//    private Stage primaryStage;
//    private GridPane grid;
//    private IWorldMap map;
//    private IEngine engine;
//    private final Map<String, Image> loadedImages = new HashMap<>();

    public static void main(String[] args) {
        Application.launch(args);
    }

//    @Override
//    public void init() throws Exception {
//        super.init();
//
////        String[] args = getParameters().getRaw().toArray(new String[0]);
////        System.out.println(Arrays.toString(args));
////
////        try {
////            List<MoveDirection> directions = OptionsParser.parse(args);
////            this.map = new GrassField(20);
////
////            List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(5,5), new Vector2d(7,6)));
////            this.engine = new SimulationEngineGUI(directions, this.map, positions, this);
////
////        } catch(IllegalArgumentException ex) {
////            System.out.println(ex.getMessage());
////            System.exit(0);
////        }
//
//    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        TextField directionsTextField = new TextField();
        Button startButton = new Button("Start");
        VBox vbox = new VBox(20, directionsTextField, startButton);
        vbox.setAlignment(Pos.CENTER);
        VBox.setMargin(directionsTextField, new Insets(0, 20, 0, 20));

        startButton.setOnAction(actionEvent -> {
            try {
                SimulationStage simulationStage = new SimulationStage(directionsTextField.getText().split(" "));
                simulationStage.show();
                simulationStage.startSimulation();

            } catch(IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

        });

        primaryStage.setScene(new Scene(vbox, 400, 200));
        primaryStage.show();
    }

}
