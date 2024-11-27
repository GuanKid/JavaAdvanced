package com.example.java_dummies_book6.Chapter_4;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GridPaneTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ColumnConstraints col1 = new ColumnConstraints(200);
        ColumnConstraints col2 = new ColumnConstraints(100);
        ColumnConstraints col3 = new ColumnConstraints(200);

//        col1.setPercentWidth(33);
//        col2.setPercentWidth(33);
//        col3.setPercentWidth(33);

        GridPane grid = new GridPane();
        grid.getColumnConstraints().addAll(col1, col2, col3);

        TextField txt1 = new TextField("Text Field 1");
        TextField txt2 = new TextField("Text Field 2");
        TextField txt3 = new TextField("Text Field 3");


        grid.addRow(0, txt1, txt2, txt3);
//        grid.setColumnSpan(txtName, 2);
//        grid.setValignment(lblName, VPos.BOTTOM);

        Scene scene = new Scene(grid, 750, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
