package gui;

import application.controller.Controller;
import application.model.Destillering;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class DestilleringPane {

    private static ListView<Destillering> lvwDestilleringer;
    private static TextArea txaInfo;
    private static Controller controller = Controller.getController();

    public static Pane getContent() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        // Labels

        pane.add(new Label("Destilleringer:"), 0, 0);

        // Listviews

        lvwDestilleringer = new ListView<>();
        lvwDestilleringer.getItems().setAll(controller.getDestilleringer());
        lvwDestilleringer.getSelectionModel().selectedItemProperty().addListener((ov, oldDestillering, newDestillering) -> selectedDestilleringChanged());
        pane.add(lvwDestilleringer, 0, 1);

        // TextArea
        txaInfo = new TextArea();
        txaInfo.setEditable(false);
        pane.add(txaInfo, 1, 1);

        // Buttons
        Button btnCreateDestillering = new Button("Tilføj Destillering");
        btnCreateDestillering.setOnAction(e -> createDestilleringAction());

        pane.add(btnCreateDestillering, 0, 2);


        return pane;

    }

    private static void selectedDestilleringChanged() {
        updateControls();
    }

    public static void updateControls() {
        Destillering destillering = lvwDestilleringer.getSelectionModel().getSelectedItem();
        if (destillering != null) {
            txaInfo.setText(destillering.getInfo());
        } else {
            txaInfo.clear();
        }

    }

    private static void createDestilleringAction() {
        DestilleringWindow dia = new DestilleringWindow("Tilføj Destillering");
        dia.showAndWait();

        lvwDestilleringer.getItems().setAll(controller.getDestilleringer());


    }
}
