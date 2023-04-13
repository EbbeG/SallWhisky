package gui;

import application.controller.Controller;
import application.model.Whisky;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class WhiskyPane {
    private static Controller controller = Controller.getController();
    private static ListView<Whisky> lvwWhisky;

    public static Pane getContent() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        // Labels
        pane.add(new Label("Whisky:"), 0, 0);

        // Listviews
        lvwWhisky = new ListView<>();
        lvwWhisky.getItems().setAll(controller.getWhiskies());
        pane.add(lvwWhisky, 0, 1);

        return pane;

    }
}
