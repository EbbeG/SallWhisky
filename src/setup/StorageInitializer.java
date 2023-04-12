package setup;

import application.controller.Controller;

public class StorageInitializer {
    public static void main(String[] args) {
        initStorage();
    }

    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        Controller controller = Controller.getController();


        controller.saveStorage();
    }

}
