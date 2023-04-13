package gui;

import application.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartWindow extends Application {

    private Controller controller;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Sall Whisky");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    @Override
    public void stop() {
        controller.saveStorage();
    }

    private void initContent(BorderPane pane) {
        controller = Controller.getController();
        controller.loadStorage();

        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabLager = new Tab("Lager");
        tabPane.getTabs().add(tabLager);

        tabLager.setContent(LagerPane.getContent());
        //tabLager.setOnSelectionChanged(event -> LagerPane.updateControls());

        Tab tabDestilleringer = new Tab("Destilleringer");
        tabPane.getTabs().add(tabDestilleringer);

        tabDestilleringer.setContent(DestilleringPane.getContent());
        //tabDestilleringer.setOnSelectionChanged(event -> DestilleringPane.updateControls());

        Tab tabFade = new Tab("Fade");
        tabPane.getTabs().add(tabFade);

        Tab tabWhisky = new Tab("Whisky");
        tabPane.getTabs().add(tabWhisky);




    }





}
