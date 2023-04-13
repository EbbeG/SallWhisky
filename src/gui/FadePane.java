package gui;

import application.controller.Controller;
import application.model.Fad;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FadePane {

    private static ListView<Fad> lvwFade;
    private static TextArea txaInfo;
    private static Controller controller = Controller.getController();

    public static Pane getContent() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        // Labels
        pane.add(new Label("Fade:"), 0, 0);

        // Listviews

        lvwFade = new ListView<>();
        lvwFade.getItems().setAll(controller.getFade());
        lvwFade.getSelectionModel().selectedItemProperty().addListener((ov, oldFad, newFad) -> selectedFadChanged());
        pane.add(lvwFade, 0, 1);

        // Textarea
        txaInfo = new TextArea();
        txaInfo.setEditable(false);
        pane.add(txaInfo, 1, 1);

        // Buttons

        Button btnCreateFad = new Button("Opret Fad");
        btnCreateFad.setOnAction(e -> createFadAction());
        pane.add(btnCreateFad, 0, 2);

        Button btnVisIndhold = new Button("Vis Indhold");
        btnVisIndhold.setOnAction(e -> visIndholdAction());
        pane.add(btnVisIndhold, 0, 3);


        return pane;
    }

    private static void visIndholdAction() {
        Fad fad = lvwFade.getSelectionModel().getSelectedItem();
        IndholdWindow dia = new IndholdWindow("Indhold", fad);
        dia.showAndWait();
    }

    private static void createFadAction() {
        FadWindow dia = new FadWindow("Opret Fad");
        dia.showAndWait();

        lvwFade.getItems().setAll(controller.getFade());
    }

    private static void selectedFadChanged() {
    }
}
