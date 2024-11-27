package com.example.java_dummies_book6.Chapter_4;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button("Button One");
        Button btn2 = new Button("Button Two");
        Button btn3 = new Button("Button Three");
        Button btn4 = new Button("Button Four");
        Button btn5 = new Button("Button Five");
        FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 10, 10, btn1, btn2, btn3, btn4, btn5);
        pane.setPrefWrapLength(500);

        Scene scene = new Scene(pane,300, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
