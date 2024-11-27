package com.example.book6_3;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class Chapter_3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Alert b = new Alert(Alert.AlertType.INFORMATION, "You have clicked once.");
        b.showAndWait();

        Alert c = new Alert(Alert.AlertType.INFORMATION, "Are you certain?",
                ButtonType.YES, ButtonType.NO);
        c.showAndWait();

        Alert d = new Alert(Alert.AlertType.INFORMATION, "Are you certain?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> r = d.showAndWait();

        if (r.isPresent() && r.get() == ButtonType.YES) {
            System.out.println("The user clicked YES!");
        } else if (r.isPresent() && r.get() == ButtonType.NO) {
            System.out.println("The user clicked NO!");
        }

    }
}
