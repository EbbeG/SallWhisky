package gui;

import application.controller.Controller;
import application.model.Fad;
import application.model.WhiskyType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.HashMap;
import java.util.Map;

public class WhiskyWindow extends Stage {
    private TextField txfNr, txfAlkoholprocent, txfFortyndelsesMængde, txfAntalLiter;
    private ComboBox<WhiskyType> cbbType;
    private TextArea txaBeskrivelse, txaFade;
    private ListView<Fad> lvwModneFade;
    private Controller controller = Controller.getController();

    private Map<Fad, Double> fadDoubleMap = new HashMap<>();
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
        pane.add(new Label("Fade:"), 2, 0);
        pane.add(new Label("Nr:"), 0, 1);
        pane.add(new Label("Type:"), 0, 2);
        pane.add(new Label("Beskrivelse:"), 0, 3);
        pane.add(new Label("Akoholprocent:"), 0, 4);
        pane.add(new Label("Fortyndelses mængde:"), 0, 5);
        pane.add(new Label("Angiv antal liter:"), 3, 0);

        // TextFields
        txfNr = new TextField();
        pane.add(txfNr, 1, 1);

        txfAlkoholprocent = new TextField();
        pane.add(txfAlkoholprocent, 1, 4);

        txfFortyndelsesMængde = new TextField();
        pane.add(txfFortyndelsesMængde, 1, 5);

        txfAntalLiter = new TextField();
        txfAntalLiter.setPromptText("Antal liter");
        pane.add(txfAntalLiter, 3, 1);

        // ComboBox
        cbbType = new ComboBox<>();
        cbbType.getItems().setAll(WhiskyType.BLENDED, WhiskyType.SINGLEMALT, WhiskyType.SINGLECASK);
        cbbType.getSelectionModel().select(0);
        pane.add(cbbType, 1, 2);

        // TextAreas
        txaBeskrivelse = new TextArea();
        txaBeskrivelse.setPrefSize(200, 100);
        pane.add(txaBeskrivelse, 1, 3);

        txaFade = new TextArea();
        txaFade.setPrefSize(200, 100);
        txaFade.setEditable(false);
        pane.add(txaFade, 3, 2, 1, 4);

        // ListView
        lvwModneFade = new ListView<>();
        lvwModneFade.setPrefSize(200, 100);
        lvwModneFade.getItems().setAll(controller.getModneFade());
        pane.add(lvwModneFade, 2, 1, 1, 5);

        // Button
        Button btnTilføj = new Button("Tilføj");
        btnTilføj.setOnAction(event -> tilføjAction());
        pane.add(btnTilføj, 3, 6);





        Button btnOpret = new Button("Opret");
        btnOpret.setOnAction(event -> opretAction());
        pane.add(btnOpret, 3, 7);



    }

    private void opretAction() {
        int nr = Integer.parseInt(txfNr.getText().trim());
        WhiskyType type = cbbType.getSelectionModel().getSelectedItem();
        String beskrivelse = txaBeskrivelse.getText().trim();
        double alkoholprocent = Double.parseDouble(txfAlkoholprocent.getText().trim());
        double fortyndelsesMængde = Double.parseDouble(txfFortyndelsesMængde.getText().trim());

        controller.createWhisky(nr, type, beskrivelse, alkoholprocent, fortyndelsesMængde, fadDoubleMap);
        hide();
    }

    private void tilføjAction() {
        Double antalLiter = Double.parseDouble(txfAntalLiter.getText().trim());
        if (lvwModneFade != null) {
            Fad fad = lvwModneFade.getSelectionModel().getSelectedItem();
            fadDoubleMap.put(fad, antalLiter);
            txaFade.appendText(fad + " " + antalLiter + " liter\n");

        }


    }
}
