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

public class ReolWindow extends Stage {
    private Lager lager;
    private Controller controller = Controller.getController();

    private TextField txfReolNr;


    public ReolWindow(String title, Lager lager) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        this.setTitle(title);

        this.lager = lager;

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

        pane.add(new Label("Reol nr:"), 0, 0);

        // TextFields

        txfReolNr = new TextField();
        pane.add(txfReolNr, 0, 1);

        // Buttons

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 0, 2);

        btnOpret.setOnAction(event -> opretAction());


    }

    private void opretAction() {
        int nr = Integer.parseInt(txfReolNr.getText().trim());

        controller.createReol(lager, nr);
        hide();



    }

}
