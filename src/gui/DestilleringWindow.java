package gui;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Kornsort;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

public class DestilleringWindow extends Stage {
    private Controller controller = Controller.getController();
    private DatePicker dpkStart, dpkSlut;
    private ComboBox<Kornsort> cbbKornsort;
    private TextField txfNewMakeNr, txfMedarbejderNavn, txfVolume, txfAlkoholprocent, txfRygeMateriale, txfKommentar;

    public DestilleringWindow(String title) {
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
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        // Labels
        pane.add(new Label("Start dato:"), 0, 0);
        pane.add(new Label("Slut dato:"), 0, 1);
        pane.add(new Label("New Make Nr:"), 0, 2);
        pane.add(new Label("Medarbejder navn:"), 0, 3);
        pane.add(new Label("Volume:"), 0, 4);
        pane.add(new Label("Alkoholprocent:"), 0, 5);
        pane.add(new Label("Kornsort"), 0, 6);
        pane.add(new Label("Ryge materiale:"), 0, 7);
        pane.add(new Label("Kommentar:"), 0, 8);


        // Datepickers
        dpkStart = new DatePicker();
        pane.add(dpkStart, 1, 0);

        dpkSlut = new DatePicker();
        pane.add(dpkSlut, 1, 1);

        // TextFields og ComboBox
        txfNewMakeNr = new TextField();
        pane.add(txfNewMakeNr, 1, 2);

        txfMedarbejderNavn = new TextField();
        pane.add(txfMedarbejderNavn, 1, 3);

        txfVolume = new TextField();
        pane.add(txfVolume, 1, 4);

        txfAlkoholprocent = new TextField();
        pane.add(txfAlkoholprocent, 1, 5);

        cbbKornsort = new ComboBox<>();
        cbbKornsort.getItems().addAll(Kornsort.EVERGREEN, Kornsort.STAIRWAY, Kornsort.IRINA);
        cbbKornsort.getSelectionModel().select(0);
        pane.add(cbbKornsort, 1, 6);

        txfRygeMateriale = new TextField();
        txfRygeMateriale.setPromptText("Valgfri...");
        pane.add(txfRygeMateriale, 1, 7);

        txfKommentar = new TextField();
        txfKommentar.setPromptText("Valgfri...");
        pane.add(txfKommentar, 1, 8);

        // Buttons

        Button btnOpret = new Button("Opret");
        btnOpret.setOnAction(e -> opretAction());
        pane.add(btnOpret, 0, 9);

    }

    private void opretAction() {
        LocalDate startDato = dpkStart.getValue();
        LocalDate slutDato = dpkSlut.getValue();

        int newMakeNr = Integer.parseInt(txfNewMakeNr.getText().trim());
        String medarbejderNavn = txfMedarbejderNavn.getText().trim();
        double volume = Double.parseDouble(txfVolume.getText().trim());
        double alkoholprocent = Double.parseDouble(txfAlkoholprocent.getText().trim());
        Kornsort kornsort = cbbKornsort.getSelectionModel().getSelectedItem();

        Destillering destillering = controller.createDestillering(startDato, slutDato, newMakeNr, medarbejderNavn, volume, alkoholprocent, kornsort);
        String rygeMateriale = txfRygeMateriale.getText().trim();
        String kommentar = txfKommentar.getText().trim();

        if (!rygeMateriale.isEmpty()) {
            controller.setRygemateriale(destillering, rygeMateriale);
        }
        if (!kommentar.isEmpty()) {
            controller.setKommentar(destillering, kommentar);
        }

        hide();


    }

}
