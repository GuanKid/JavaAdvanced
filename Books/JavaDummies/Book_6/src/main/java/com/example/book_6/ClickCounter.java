package com.example.book_6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClickCounter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Button btn;
    Label lbl;
    int iClickCount = 0;

    @Override
    public void start(Stage primaryStage) {
        // Create the button
        btn = new Button("Click me please!");
        btn.setOnAction(e -> buttonClick() );

        // Create the label
        lbl = new Label("You have not clicked the button.");

        // Add the label and button the layout pane.
        BorderPane pane = new BorderPane();
        pane.setTop(lbl);
        pane.setCenter(btn);

        // Add the layout pane to the scene
        Scene scene = new Scene(pane, 250, 150);

        // Add the scene to the stage, set the title & show the stage.
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Counter");
        primaryStage.show();
    }

    public void buttonClick() {
        iClickCount++;
        if (iClickCount == 1) {
            lbl.setText("You have clicked the button once");
        } else {
            lbl.setText("You have clicked the button " + iClickCount + "  times");
        }
    }
}
