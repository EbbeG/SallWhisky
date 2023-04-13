package gui;

import application.controller.Controller;
import application.model.Fad;
import application.model.Lager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class IndholdWindow extends Stage {
    private Fad fad;
    private Controller controller = Controller.getController();


    public IndholdWindow(String title, Fad fad) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        this.setTitle(title);

        this.fad = fad;

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
        txaIndhold.setText(fad.getIndhold());

        pane.add(txaIndhold, 0, 0);


    }
}
