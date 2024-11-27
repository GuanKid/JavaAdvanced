package com.example.java_dummies_book6.Chapter_4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button("Number One");
        Button btn2 = new Button("Two");
        Button btn3 = new Button("The Third One");

        btn1.setMaxWidth(Double.MAX_VALUE);
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn3.setMaxWidth(Double.MAX_VALUE);

        // pane
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(btn1, btn2, btn3);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.TOP_CENTER);

//        vBox.setMargin(btn1, new Insets(10));
//        vBox.setMargin(btn2, new Insets(10));
//        vBox.setMargin(btn3, new Insets(10));

        // scene
        Scene scene = new Scene(vBox, 500, 500);

        // stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("HBOX Test");
        primaryStage.show();
    }
}
