package com.example.java_dummies_book6.Chapter_4;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PizzaOrder extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage stage;
    TextField txtName, txtPhone, txtAddress;
    RadioButton rdoSmall, rdoMedium, rdoLarge, rdoThin, rdoThick;
    CheckBox chkPepperoni, chkMushrooms, chkAnchovies;
    ToggleGroup groupSize, groupCrust;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        String cssLayout = "-fx-border-color: red;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-border-style: dashed;\n";

        // Create the name label and text field
        Label lblName = new Label("Name:");
        txtName = new TextField();
        txtName.setMinWidth(100);
        txtName.setPrefWidth(200);
        txtName.setMaxWidth(300);
        txtName.setPromptText("Enter the name here");

        // Create the phone number label and text field
        Label lblPhone = new Label("Phone Number:");
        txtPhone = new TextField();
        txtPhone.setMinWidth(60);
        txtPhone.setPrefWidth(120);
        txtPhone.setMaxWidth(180);
        txtPhone.setPromptText("Enter the phone number here:");

        // Create the address label and text field
        Label lblAddress = new Label("Address:");
        txtAddress = new TextField();
        txtAddress.setMinWidth(100);
        txtAddress.setPrefWidth(200);
        txtAddress.setMaxWidth(300);
        txtAddress.setPromptText("Enter the address here:");

        // Create the size pane
        Label lblSize = new Label("Size");
        rdoSmall = new RadioButton("Small");
        rdoMedium = new RadioButton("Medium");
        rdoLarge = new RadioButton("Large");
        rdoMedium.setSelected(true);
        groupSize = new ToggleGroup();
        rdoSmall.setToggleGroup(groupSize);
        rdoMedium.setToggleGroup(groupSize);
        rdoLarge.setToggleGroup(groupSize);

        VBox paneSize = new VBox(lblSize, rdoSmall, rdoMedium, rdoLarge);
        paneSize.setSpacing(10);

        // Create the crust pane
        Label lblCrust = new Label("Crust");
        rdoThin = new RadioButton("Thin");
        rdoThick = new RadioButton("Thick");
        rdoThin.setSelected(true);

        groupCrust = new ToggleGroup();
        rdoThin.setToggleGroup(groupCrust);
        rdoThick.setToggleGroup(groupCrust);

        VBox paneCrust = new VBox(lblCrust, rdoThin, rdoThick);
        paneCrust.setSpacing(10);

        // Create the toppings pane
        Label lblToppings = new Label("Toppings");
        chkPepperoni = new CheckBox("Pepperoni");
        chkMushrooms = new CheckBox("Mushrooms");
        chkAnchovies = new CheckBox("Anchovies");

        chkAnchovies.setOnAction(e -> chkAnchovies_Click());

        VBox paneToppings = new VBox(lblToppings, chkPepperoni, chkMushrooms, chkAnchovies);
        paneToppings.setSpacing(10);

        // Create the buttons
        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(80);
        btnOK.setOnAction(e -> btnOK_Click() );

        Button btnCancel = new Button("Cancel");
        btnCancel.setPrefWidth(80);
        btnCancel.setOnAction(e -> btnCancel_Click() );

        HBox paneButtons = new HBox(10, btnOK, btnCancel);

        // Create the GridPane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setMinWidth(500);
        grid.setPrefWidth(500);
        grid.setMaxWidth(800);

//        txtName.setStyle(cssLayout);
//        txtPhone.setStyle(cssLayout);
//        txtAddress.setStyle(cssLayout);
//        paneButtons.setStyle(cssLayout);
//        paneCrust.setStyle(cssLayout);
//        paneSize.setStyle(cssLayout);
//        paneToppings.setStyle(cssLayout);

        // Add the nodes to the pane
        grid.addRow(0, lblName, txtName);
        grid.addRow(1, lblPhone, txtPhone);
        grid.addRow(2, lblAddress, txtAddress);
        grid.addRow(3, paneSize, paneCrust, paneToppings);
        grid.add(paneButtons, 2, 4);

        // Set the alignments and spanning
//        GridPane.setHalignment(lblName, HPos.RIGHT);
        GridPane.setHalignment(lblPhone, HPos.RIGHT);
        GridPane.setHalignment(lblAddress, HPos.RIGHT);
        GridPane.setColumnSpan(txtName, 2);
        GridPane.setColumnSpan(txtPhone, 2);
        GridPane.setColumnSpan(txtAddress, 2);

        // Set column widths
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(33);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(33);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(33);
        grid.getColumnConstraints().addAll(col1, col2, col3);

        // Create the scene and the stage
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza Order");
        primaryStage.setMinWidth(500);
        primaryStage.setMaxWidth(900);
        primaryStage.show();
    }

    public void btnOK_Click()
    {
        // Create a message string with the customer information
        String msg = "Customer:\n\n";
        msg += "\t" + txtName.getText() + " \n";
        msg += "\t" + txtPhone.getText() + "\n\n";
        msg += "\t" + txtAddress.getText() + "\n\n";
        msg += "You have ordered a ";

        // Add the pizza size
        if (rdoSmall.isSelected()) {
            msg += "small ";
        } else if (rdoSmall.isSelected()) {
            msg += "medium ";
        } else if (rdoSmall.isSelected()) {
            msg += "large ";
        }

        // Add the crust style
        if (rdoThin.isSelected()) {
            msg += "thin crust pizza with ";
        } else if (rdoThick.isSelected()) {
            msg += "thick crust pizza with";
        }

        // Add the toppings
        String toppings = "";
        toppings = buildToppings(chkPepperoni, toppings);
        toppings = buildToppings(chkMushrooms, toppings);
        toppings = buildToppings(chkAnchovies, toppings);

        if (toppings.equals(""))
            msg += "no toppings";
        else
            msg += " the following toppings:\n" + toppings;

        // Display the message
        Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
        a.setTitle("Order Details");
        a.showAndWait();

        groupSize.getSelectedToggle().setSelected(false);
        groupCrust.getSelectedToggle().setSelected(false);

        chkAnchovies.setSelected(false);
        chkMushrooms.setSelected(false);
        chkPepperoni.setSelected(false);

        txtAddress.clear();
        txtPhone.clear();
        txtName.clear();
    }

    public String buildToppings(CheckBox chk, String msg) {
        // Helper method for displaying the list of toppings
        if (chk.isSelected()) {
            if (!msg.equals("")) {
                msg += ", ";
            }
            msg += chk.getText();
        }
        return msg;
    }

    public void btnCancel_Click() {
        stage.close();
    }

    public void chkAnchovies_Click() {
        Alert a = new Alert(Alert.AlertType.WARNING, "We don't do anchovies here.");
        a.setTitle("Yuck!");
        a.showAndWait();
        chkAnchovies.setSelected(false);
    }

}
