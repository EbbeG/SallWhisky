package setup;

import application.controller.Controller;
import application.model.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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
        Fad fad2 = controller.createFad(2, 200, "Spanien", "Bourbon");
        Fad fad3 = controller.createFad(3, 100, "England", "Sherry");
        Fad fad4 = controller.createFad(4, 150, "England", "Sherry");


        controller.addFadToReol(reol1, 1, fad1);
        controller.addFadToReol(reol2, 1, fad3);
        controller.addFadToReol(reol3, 1, fad2);
        controller.addFadToReol(reol4, 1, fad4);

        Destillering destillering1 = controller.createDestillering(LocalDate.of(2020, 01, 1), LocalDate.of(2023, 01, 1),1, "Snævar", 500, 53, Kornsort.EVERGREEN);
        Destillering destillering2 = controller.createDestillering(LocalDate.of(2019, 01, 1), LocalDate.of(2022, 01, 1),2, "Snævar", 700, 49, Kornsort.IRINA);

        Map<Destillering, Double> map = new HashMap<>();
        map.put(destillering1, 50.0);

        Map<Destillering, Double> map2 = new HashMap<>();
        map2.put(destillering2, 150.0);
        map2.put(destillering1, 50.0);

        controller.fyldPåFadFraDestillering(fad1, map , LocalDate.of(2019,02,3));
        controller.fyldPåFadFraDestillering(fad2, map2 , LocalDate.of(2019,02,3));

        Map<Fad, Double> fadMap = new HashMap<>();
        fadMap.put(fad1, 30.0);
        fadMap.put(fad2, 40.0);
        Whisky whisky1 = controller.createWhisky(1, WhiskyType.SINGLEMALT, "Kraftig whisky", 55.5, 5, fadMap);








        controller.saveStorage();
    }

}
