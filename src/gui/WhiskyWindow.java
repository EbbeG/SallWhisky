package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WhiskyWindow extends Stage {
    public WhiskyWindow(String title) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Labels
        pane.add(new Label("Nr:"), 0, 0);
        pane.add(new Label("Type:"), 0, 1);
        pane.add(new Label("Navn:"), 0, 2);
        pane.add(new Label("Beskrivelse:"), 0, 3);
        pane.add(new Label("Akoholprocent:"), 0, 4);
        pane.add(new Label("Fortyndelses mængde:"), 0, 5);

    }
}
