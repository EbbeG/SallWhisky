package gui;

import application.controller.Controller;
import application.model.Fad;
import application.model.Lager;
import application.model.Reol;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class LagerPane {

    private static Controller controller = Controller.getController();
    private static ListView<Lager> lvwLagre;
    private static ListView<Reol> lvwReoler;
    private static ListView<Fad> lvwFade;
    public static Pane getContent() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);


        // Labels
        pane.add(new Label("Lagre:"), 0, 0);
        pane.add(new Label("Reoler:"), 1, 0);
        pane.add(new Label("Fad:"), 2, 0);

        // Listviews
        lvwLagre = new ListView<>();
        lvwLagre.getItems().setAll(controller.getLagre());
        lvwLagre.getSelectionModel().selectedItemProperty().addListener((ov, oldLager, newLager) -> selectedLagerChanged());

        pane.add(lvwLagre, 0, 1);


        lvwReoler = new ListView<>();
        lvwReoler.getSelectionModel().selectedItemProperty().addListener((ov, oldReol, newReol) -> selectedReolChanged());
        pane.add(lvwReoler, 1, 1);

        lvwFade = new ListView<>();
        pane.add(lvwFade, 2, 1, 2, 1);

        // Buttons
        Button btnCreateLager = new Button("Opret Lager");
        btnCreateLager.setOnAction(e -> createLagerAction());

        Button btnCreateReol = new Button("Opret Reol");
        btnCreateReol.setOnAction(e -> createReolAction());

        Button btnTilføjFad = new Button("Tilføj Fad");
        btnTilføjFad.setOnAction(e -> tilføjFadAction());

        Button btnVisIndhold = new Button("Vis Indhold");
        btnVisIndhold.setOnAction(e -> visIndholdAction());

        pane.add(btnCreateLager, 0, 3);
        pane.add(btnCreateReol, 1, 3);
        pane.add(btnTilføjFad, 2, 3);
        pane.add(btnVisIndhold, 3, 3);

        if (lvwLagre.getItems().size() > 0) {
            lvwLagre.getSelectionModel().select(0);
        }

        return pane;

    }

    private static void tilføjFadAction() {

    }


    private static void selectedLagerChanged() {
        Lager lager = lvwLagre.getSelectionModel().getSelectedItem();
        if (lager != null) {
            lvwReoler.getItems().setAll(lager.getReoler());
        } else {
            lvwReoler.getItems().clear();
        }
    }

    private static void selectedReolChanged() {
        Reol reol = lvwReoler.getSelectionModel().getSelectedItem();
        if (reol != null) {
            lvwFade.getItems().setAll(reol.getFade());
        } else {
            lvwFade.getItems().clear();
        }
    }


    private static void visIndholdAction() {
        Fad fad = lvwFade.getSelectionModel().getSelectedItem();
        IndholdWindow dia = new IndholdWindow("Indhold", fad);
        dia.showAndWait();
    }


    private static void createLagerAction() {
        LagerWindow dia = new LagerWindow("Opret Lager");
        dia.showAndWait();

        lvwLagre.getItems().setAll(controller.getLagre());
    }

    private static void createReolAction() {
        Lager lager = lvwLagre.getSelectionModel().getSelectedItem();
        ReolWindow dia = new ReolWindow("Opret Reol", lager);
        dia.showAndWait();

        lvwReoler.getItems().setAll(lager.getReoler());
    }
}
