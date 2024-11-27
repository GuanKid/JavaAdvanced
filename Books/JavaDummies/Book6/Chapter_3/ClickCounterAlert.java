package Book6.Chapter_3;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.util.Optional;

public class ClickCounterAlert extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }
    Button btn;
    Label lbl;
    int iClickCount = 0;

    Stage stage;

    @Override public void start(Stage primaryStage)
    {
        this.stage = primaryStage;

        // Create the button
        btn = new Button();
        btn.setText("Click me please!");
        btn.setOnAction(e -> buttonClick());

        // Create the close button
        Button btnClose = new Button("Close");
        btnClose.setOnAction(e -> btnClose_Click());

        // Add the button to a layout pane
        BorderPane pane = new BorderPane();
        pane.setCenter(btn);
        pane.setBottom(btnClose);

        // Add the layout pane to a scene
        Scene scene = new Scene(pane, 250, 150);

        // Add the scene to the stage, set the title
        // and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Counter");

        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            btnClose_Click();
        });
        primaryStage.show();


    }
    public void buttonClick()
    {
        iClickCount++;
        if (iClickCount == 1)
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "You have clicked once." );
            a.showAndWait();
        }
        else
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "You have clicked " + iClickCount + " times.");
            a.showAndWait();
        }
    }

    private void btnClose_Click()
    {
        boolean reallyQuit = false;

        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are you certain you want to exit?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> r = a.showAndWait();

        if (r.isPresent() && r.get() == ButtonType.YES)
        {
            reallyQuit = true;
        }

        if (reallyQuit)
        {
            // Perform cleanup tasks here
            // such as saving files or freeing resources
            stage.close();
        }

    }

}
