package com.example.java_dummies_book6.Chapter_4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button("Button One");
        Button btn2 = new Button("Button Two");
        Button btn3 = new Button("Button Three");

        // pane
        HBox hbox = new HBox( btn1, btn2, btn3);
        hbox.setPadding(new Insets(40, 20, 40, 20));

        hbox.setMargin(btn1, new Insets(10));
        hbox.setMargin(btn2, new Insets(10));
        hbox.setMargin(btn3, new Insets(10));

        // scene
        Scene scene = new Scene(hbox, 500, 500);

        // stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("HBOX Test");
        primaryStage.show();
    }
}
