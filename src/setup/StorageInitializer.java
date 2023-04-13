package setup;

import application.controller.Controller;
import application.model.Fad;
import application.model.Lager;
import application.model.Reol;

public class StorageInitializer {
    public static void main(String[] args) {
        initStorage();
    }

    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        Controller controller = Controller.getController();
        Lager sall = controller.createLager("Sall");
        Lager container = controller.createLager("Container");

        Reol reol1 = controller.createReol(sall, 1);
        Reol reol2 = controller.createReol(sall, 2);

        Reol reol3 = controller.createReol(container, 3);
        Reol reol4 = controller.createReol(container, 4);

        Fad fad1 = controller.createFad(1, 100, "Spanien", "Bourbon");
        Fad fad2 = controller.createFad(2, 150, "Spanien", "Bourbon");

        controller.addFadToReol(reol1, 1, fad1);
        controller.addFadToReol(reol2, 1, fad2);


        controller.saveStorage();
    }

}
