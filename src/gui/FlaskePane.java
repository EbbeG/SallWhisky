package gui;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Flaske;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FlaskePane {
    private static ListView<Flaske> lvwFlasker;
    private static TextArea txaInfo;
    private static Controller controller = Controller.getController();


    public static Pane getContent() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        // Labels
        pane.add(new Label("Flasker:"), 0, 0);

        // Listviews
        lvwFlasker = new ListView<>();
        lvwFlasker.getItems().setAll(controller.getFlasker());
        lvwFlasker.getSelectionModel().selectedItemProperty().addListener((ov, oldFlaske, newFlaske) -> selectedFlaskeChanged());
        pane.add(lvwFlasker, 0, 1);

        // TextArea
        txaInfo = new TextArea();
        txaInfo.setEditable(false);
        pane.add(txaInfo, 1, 1);

        // Buttons
        Button btnCreateFlaske = new Button("Opret Flaske");
        btnCreateFlaske.setOnAction(e -> createFlaskeAction());

        pane.add(btnCreateFlaske, 0, 2);



    }

    private static void createFlaskeAction() {
    }

    private static void selectedFlaskeChanged() {
        updateControls();
    }

    private static void updateControls() {
        Flaske flaske = lvwFlasker.getSelectionModel().getSelectedItem();
        if (flaske != null) {
            txaInfo.setText(flaske.getInfo());
        } else {
            txaInfo.clear();
        }

    }
}
