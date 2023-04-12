package gui;

import application.controller.Controller;
import application.model.Lager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LagerWindow extends Stage {

    private Controller controller = Controller.getController();
    private TextField txfLagerNavn;


    public LagerWindow(String title) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        this.setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // Labels
        pane.add(new Label("Lager navn:"), 0, 0);

        // TextFields

        txfLagerNavn = new TextField();
        pane.add(txfLagerNavn, 0, 1);

        // Buttons

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 0, 2);

        btnOpret.setOnAction(event -> opretAction());





    }

    private void opretAction() {
        String navn = txfLagerNavn.getText().trim();
        if (navn.length() == 0) {

        }
        controller.createLager(navn);
        hide();


    }


}
