package agh.ics.oop.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class App extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        TextField directionsTextField = new TextField();
        directionsTextField.setPromptText("directions");
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
        startButton.requestFocus();
        primaryStage.show();
    }

}
