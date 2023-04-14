package gui;

import application.controller.Controller;
import application.model.Fad;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FadePane {

    private static ListView<Fad> lvwFade;
    private static TextArea txaInfo;
    private static ToggleGroup tglGroup;
    private static RadioButton rbDestillering, rbFad;
    private static Controller controller = Controller.getController();

    public static Pane getContent() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        // Labels
        pane.add(new Label("Fade:"), 0, 0);
        pane.add(new Label("Fyld fra:"), 1, 2);

        // Listviews

        lvwFade = new ListView<>();
        lvwFade.getItems().setAll(controller.getFade());
        lvwFade.getSelectionModel().selectedItemProperty().addListener((ov, oldFad, newFad) -> selectedFadChanged());
        pane.add(lvwFade, 0, 1, 4, 1);

        // Textarea
        txaInfo = new TextArea();
        txaInfo.setEditable(false);
        pane.add(txaInfo, 4, 1);

        // Buttons

        Button btnCreateFad = new Button("Opret Fad");
        btnCreateFad.setOnAction(e -> createFadAction());
        pane.add(btnCreateFad, 0, 3);

        Button btnFyldPå = new Button("Fyld på");
        btnFyldPå.setOnAction(e -> fyldPåAction());
        pane.add(btnFyldPå, 2, 3);

        // Radiobuttons
        tglGroup = new ToggleGroup();

        rbDestillering = new RadioButton("Destillering");
        rbDestillering.setToggleGroup(tglGroup);
        rbFad = new RadioButton("Fad");
        rbFad.setToggleGroup(tglGroup);

        pane.add(rbDestillering, 2, 2);
        pane.add(rbFad, 3, 2);

        if (lvwFade.getItems().size() > 0) {
            lvwFade.getSelectionModel().select(0);
        }


        return pane;
    }

    private static void fyldPåAction() {
        Fad fad = lvwFade.getSelectionModel().getSelectedItem();
        if (fad != null) {
            RadioButton selected = (RadioButton) tglGroup.getSelectedToggle();
            FyldPåWindow dia = new FyldPåWindow("Fyld på", fad, selected.getText());

            dia.showAndWait();
            updateControls();
        }

    }


    private static void createFadAction() {
        FadWindow dia = new FadWindow("Opret Fad");
        dia.showAndWait();

        lvwFade.getItems().setAll(controller.getFade());
    }

    private static void selectedFadChanged() {
        updateControls();
    }

    private static void updateControls() {
        Fad fad = lvwFade.getSelectionModel().getSelectedItem();
        if (fad != null) {
            txaInfo.setText(fad.getIndhold());
        } else {
            txaInfo.clear();
        }
    }
}
