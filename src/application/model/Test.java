package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Destillering destillering = new Destillering(null, null, 1, "Ole", 50, 0.5, Kornsort.EVERGREEN);
        Destillering destillering1 = new Destillering(null, null, 2, "Ole", 50, 0.5, Kornsort.EVERGREEN);
        Fad fad = new Fad(1, 70, "Spanien", "Sherry");
        Fad fad1 = new Fad(2, 60, "England", "Bourbon");

        fad.fyldPå(destillering, 40);
        fad1.fyldPå(destillering1, 20);
        fad1.fyldPå(destillering, 10);
        fad.fyldPå(fad1, 10);

        System.out.println("fad.getVolume() = " + fad.getVolume());
        System.out.println("destillering = " + destillering.getVolume());
        System.out.println(fad.visInhold());

    }
}
