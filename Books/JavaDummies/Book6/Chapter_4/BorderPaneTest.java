package com.example.java_dummies_book6.Chapter_4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BorderPaneTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        String cssLayout = "-fx-border-color: red;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-border-style: dashed;\n";

        ArrayList<VBox> vBoxes = new ArrayList<>();
        ArrayList<Button> buttons = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                buttons.add(new Button("Button: " + (i*3+j) ));
            }

            vBoxes.add(new VBox(buttons.get(i*3), buttons.get(i*3+1), buttons.get(i*3+2)));
//            vBoxes.get(i).setAlignment(Pos.CENTER);
            vBoxes.get(i).setStyle(cssLayout);
        }

        BorderPane bPane = new BorderPane(vBoxes.get(0), vBoxes.get(1), vBoxes.get(2), vBoxes.get(3), vBoxes.get(4));

        Scene scene = new Scene(bPane,400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
