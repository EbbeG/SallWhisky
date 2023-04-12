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
        pane.add(lvwLagre, 0, 1, 1, 2);

        lvwReoler = new ListView<>();
        pane.add(lvwReoler, 1, 1, 1, 2);

        lvwFade = new ListView<>();
        pane.add(lvwFade, 2, 1, 1, 2);

        // Buttons
        Button btnCreateLager = new Button("Opret Lager");
        btnCreateLager.setOnAction(e -> createLagerAction());

        Button btnCreateReol = new Button("Opret Reol");

        Button btnVisIndhold = new Button("Vis Indhold");

        pane.add(btnCreateLager, 0, 3);
        pane.add(btnCreateReol, 1, 3);
        pane.add(btnVisIndhold, 2, 3);

        return pane;

    }

    public static void updateControls() {

    }

    private static void createLagerAction() {
        LagerWindow dia = new LagerWindow("Opret Lager");
        dia.showAndWait();

        lvwLagre.getItems().setAll(controller.getLagre());
        System.out.println(controller.getLagre());




    }
}
