package gui;

import application.model.Destillering;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DestilleringInfoWindow extends Stage {
    private Destillering destillering;

    public DestilleringInfoWindow(String title, Destillering destillering) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        this.setTitle(title);

        this.destillering = destillering;

        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // Textarea

        TextArea txaIndhold = new TextArea();
        txaIndhold.setEditable(false);
        txaIndhold.setText(destillering.getInfo());

        pane.add(txaIndhold, 0, 0);

    }
}
