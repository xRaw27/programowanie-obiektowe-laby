package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class GuiElementBox extends VBox {

    public GuiElementBox(IMapElement mapElement, Map<String, Image> loadedImages) {
        String imageSrc = mapElement.getImageSrc();

        if (loadedImages.get(imageSrc) == null) {
            try {
                loadedImages.put(imageSrc, new Image(new FileInputStream(imageSrc)));
                System.out.println("Załadowano nową grafikę");
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }

        ImageView imageView = new ImageView(loadedImages.get(mapElement.getImageSrc()));
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);

        this.getChildren().add(imageView);
        this.getChildren().add(new Label(mapElement.getLabel()));
        this.setAlignment(Pos.CENTER);
    }

}
