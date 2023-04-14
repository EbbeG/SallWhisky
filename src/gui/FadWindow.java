package gui;

import application.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FadWindow extends Stage {

    Controller controller = Controller.getController();
    TextField txfNr, txfStørrelse, txfOprindelse, txfFadtype;
    public FadWindow(String title) {
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
        pane.add(new Label("Størrelse:"), 0, 1);
        pane.add(new Label("Oprindelse:"), 0, 2);
        pane.add(new Label("Fadtype:"), 0, 3);

        // Textfields
        txfNr = new TextField();
        pane.add(txfNr, 1, 0);

        txfStørrelse = new TextField();
        pane.add(txfStørrelse, 1, 1);

        txfOprindelse = new TextField();
        pane.add(txfOprindelse, 1, 2);

        txfFadtype = new TextField();
        pane.add(txfFadtype, 1, 3);

        // Buttons
        Button btnOpret = new Button("Opret");
        btnOpret.setOnAction(event -> opretAction());
        pane.add(btnOpret, 0, 4);

    }

    private void opretAction() {
        int nr = Integer.parseInt(txfNr.getText().trim());
        double størrelse = Double.parseDouble(txfStørrelse.getText().trim());
        String oprindelse = txfOprindelse.getText().trim();
        String fadtype = txfFadtype.getText().trim();

        controller.createFad(nr, størrelse, oprindelse, fadtype);

        hide();

    }


}
