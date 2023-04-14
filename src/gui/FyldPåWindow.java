package gui;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Fad;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.HashMap;
import java.util.Map;

public class FyldPåWindow extends Stage {
    private Controller controller = Controller.getController();
    private Fad fad;
    private ListView<Fad> lvwFade;
    private ListView<Destillering> lvwDestilleringer;
    private TextField txfVolume;
    private TextArea txaPåfyldning;
    private DatePicker dpkPåfyldningsdato;

    private Map<Destillering, Double> destilleringer = new HashMap<>();
    private Map<Fad, Double> fade = new HashMap<>();

    public FyldPåWindow(String title, Fad fad, String væskeKilde) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        this.setTitle(title);
        this.fad = fad;

        GridPane pane = new GridPane();
        initContent(pane, væskeKilde);
        Scene scene = new Scene(pane);
        setScene(scene);
    }

    private void initContent(GridPane pane, String væskeKilde) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // Fra destillering
        if (væskeKilde.equals("Destillering")) {
            pane.add(new Label("Destilleringer:"), 0, 0);
            lvwDestilleringer = new ListView<>();
            lvwDestilleringer.setPrefHeight(300);
            lvwDestilleringer.getItems().setAll(controller.getDestilleringer());
            pane.add(lvwDestilleringer, 0, 1, 1, 2);
        } else {
            pane.add(new Label("Fade:"), 0, 0);
            lvwFade = new ListView<>();
            lvwFade.setPrefHeight(300);
            lvwFade.getItems().setAll(controller.getFade());
            pane.add(lvwFade, 0, 1, 1, 2);
        }

        // Labels
        pane.add(new Label("Angiv liter:"), 1, 0);
        pane.add(new Label("Påfyldningsdato:"), 1, 3);

        // Textfields
        txfVolume = new TextField();
        pane.add(txfVolume, 1, 1);

        // Buttons
        Button btnTilføj = new Button("Tilføj");
        btnTilføj.setOnAction(event -> tilføjVæskeAction());
        pane.add(btnTilføj, 2, 1);

        Button btnVisInfo = new Button("Vis info");
        btnVisInfo.setOnAction(event -> visInfoAction());
        pane.add(btnVisInfo, 0, 3);

        Button btnFyldPå = new Button("Fyld på");
        btnFyldPå.setOnAction(event -> fyldPåAction());
        pane.add(btnFyldPå,2, 4);

        // Datepicker
        dpkPåfyldningsdato = new DatePicker();
        pane.add(dpkPåfyldningsdato, 1, 4);

        // TextArea
        txaPåfyldning = new TextArea();
        txaPåfyldning.setEditable(false);
        txaPåfyldning.setPrefWidth(250);
        txaPåfyldning.setPrefHeight(300);
        pane.add(txaPåfyldning, 1, 2, 2, 1);


    }

    private void visInfoAction() {
        if (lvwDestilleringer != null) {
            Destillering destillering = lvwDestilleringer.getSelectionModel().getSelectedItem();
            DestilleringInfoWindow dia = new DestilleringInfoWindow("Destillering", destillering);
            dia.showAndWait();
        } else {
            Fad fad = lvwFade.getSelectionModel().getSelectedItem();
            IndholdWindow dia = new IndholdWindow("Indhold", fad);
            dia.showAndWait();
        }
    }

    private void tilføjVæskeAction() {
        double antalLiter = Double.parseDouble(txfVolume.getText().trim());
        if (lvwDestilleringer != null) {
            Destillering destillering = lvwDestilleringer.getSelectionModel().getSelectedItem();
            destilleringer.put(destillering, antalLiter);
            txaPåfyldning.appendText(destillering + " " + antalLiter + " liter\n");
        } else {
            Fad fad = lvwFade.getSelectionModel().getSelectedItem();
            fade.put(fad, antalLiter);
            txaPåfyldning.appendText(fad + " " + antalLiter + " liter\n");
        }
    }

    private void fyldPåAction() {
        try {
            if (lvwDestilleringer != null) {
                controller.fyldPåFadFraDestillering(fad, destilleringer, dpkPåfyldningsdato.getValue());
            } else {
                controller.fyldPåFadFraFad(fad, fade, dpkPåfyldningsdato.getValue());
            }
            hide();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl");
            alert.setHeaderText("Der skete en fejl");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }


    }
}
