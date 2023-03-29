package application.model;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Fad fad = new Fad(1, 100, "Danmark", "Sherry");
        Fad fad1 = new Fad(2, 100, "Danmark", "Bourbon");
        Destillering destillering = new Destillering(LocalDate.now(), LocalDate.now(), 1, "Stål", 100, 50, Kornsort.EVERGREEN);
        fad1.fyldPå(destillering, 30);
        fad.fyldPå(destillering, 50);
        fad.fyldPå(fad1, 30);
        System.out.println(fad.getVolume());
        System.out.println("fad.getVæske() = " + fad.getVæske());
        Destillering destillering1 = new Destillering(LocalDate.now(), LocalDate.now(), 2, "Snævar", 50, 50, Kornsort.EVERGREEN);
        fad1.fyldPå(destillering1, 10);
        System.out.println("fad.getVæske() = " + fad.getVæske());
    }
}
