package gui;

import application.controller.Controller;
import application.model.Whisky;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class WhiskyPane {
    private static Controller controller = Controller.getController();
    private static ListView<Whisky> lvwWhisky;
    private static TextArea txaInfo;

    public static Pane getContent() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        // Labels
        pane.add(new Label("Whisky:"), 0, 0);

        // Listviews
        lvwWhisky = new ListView<>();
        lvwWhisky.getSelectionModel().selectedItemProperty().addListener((ov, oldWhisky, newWhisky) -> selectedWhiskyChanged());
        lvwWhisky.getItems().setAll(controller.getWhiskies());
        pane.add(lvwWhisky, 0, 1);

        // TextArea
        txaInfo = new TextArea();
        txaInfo.setEditable(false);
        pane.add(txaInfo, 1, 1);

        // Buttons
        Button btnCreateWhisky = new Button("Tilføj Whisky");
        btnCreateWhisky.setOnAction(e -> createWhiskyAction());
        pane.add(btnCreateWhisky, 0, 2);


        return pane;

    }

    private static void createWhiskyAction() {
        WhiskyWindow dia = new WhiskyWindow("Tilføj Whisky");
        dia.showAndWait();

        lvwWhisky.getItems().setAll(controller.getWhiskies());
    }

    private static void selectedWhiskyChanged() {
        updateControls();
    }

    private static void updateControls() {
        Whisky whisky = lvwWhisky.getSelectionModel().getSelectedItem();
        if (whisky != null) {
            txaInfo.setText(whisky.getInfo());
        } else {
            txaInfo.clear();
        }
    }
}
