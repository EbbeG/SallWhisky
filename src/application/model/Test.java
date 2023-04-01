package application.model;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Fad fad = new Fad(1, 100, "Danmark", "Sherry");
        Fad fad1 = new Fad(2, 100, "Danmark", "Bourbon");
        Destillering destillering = new Destillering(LocalDate.now(), LocalDate.now(), 1, "Stål", 100, 50, Kornsort.EVERGREEN);
        fad1.fyldPå(destillering, 30, LocalDate.now());
        fad.fyldPå(destillering, 50, LocalDate.now());
        fad.fyldPå(fad1, 30, LocalDate.now());
        System.out.println(fad.getVolume());
        System.out.println("fad.getVæske() = " + fad.getVæske());
        Destillering destillering1 = new Destillering(LocalDate.now(), LocalDate.now(), 2, "Snævar", 50, 50, Kornsort.EVERGREEN);
        fad1.fyldPå(destillering1, 10, LocalDate.now());
        System.out.println("fad.getVæske() = " + fad.getVæske());
        System.out.println("fad1.getVæske() = " + fad1.getVæske());
        System.out.println(fad);
        System.out.println("-----------------------------");
        System.out.println(fad.getIndhold());
    }
}
