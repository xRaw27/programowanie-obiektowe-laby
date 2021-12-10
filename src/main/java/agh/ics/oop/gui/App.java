package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();

//        String[] args = getParameters().getRaw().toArray(new String[0]);
//
//        System.out.println(Arrays.toString(args));
//
//        try {
//            List<MoveDirection> directions = OptionsParser.parse(args);
//            IWorldMap map = new GrassField(10);
//
//            List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(5,5), new Vector2d(7,6)));
//
//            IEngine engine = new SimulationEngineGUI(directions, map, positions);
//            Thread engineThread = new Thread((Runnable)engine);
//            engineThread.start();
//
//        } catch(IllegalArgumentException ex) {
//            System.out.println(ex.getMessage());
//        }

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("JavaFX App");

//        GridPane gridPane = createGrid();
        Label label1 = new Label("start");

        this.primaryStage.setScene(new Scene(label1, 400, 400));

        this.primaryStage.show();

//        gridPane.getColumnConstraints().add(new ColumnConstraints(30));
//        gridPane.getColumnConstraints().remove(0);
    }

    public void update(String s) {
        Label label = new Label(s);
        this.primaryStage.setScene(new Scene(label, 400, 400));
    }

//    private GridPane createGrid() {
//        GridPane grid = new GridPane();
//        grid.setGridLinesVisible(true);
//
//        ColumnConstraints cc = new ColumnConstraints(30);
////        cc.setHalignment(HPos.CENTER);
////
//        RowConstraints rc = new RowConstraints(30);
////        rc.setValignment(VPos.CENTER);
//
//        List<VBox> cells = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            grid.getColumnConstraints().add(cc);
//            grid.getRowConstraints().add(rc);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                VBox vbox = new VBox(new Label("*"));
//                vbox.setAlignment(Pos.CENTER);
//
//                cells.add(vbox);
//                grid.add(vbox, i, j, 1, 1);
//            }
//        }
//
//        cells.get(14).getChildren().clear();
//        cells.get(14).getChildren().add(new Label("A"));
//
//        return grid;
//    }

    public void testt() {
        System.out.println("test");
    }
}
