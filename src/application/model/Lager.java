package application.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lager {

    private static List<Reol> reoler = new ArrayList<>();

    private static int reolIndex = 0;

    public static void addFad(Fad fad) {
        if (reoler.get(reolIndex).isFuld() && reolIndex < reoler.size() - 1) {
            reolIndex++;
        } else {
            if (!reoler.get(reolIndex).isFuld())
                reoler.get(reolIndex).addFad(fad);
            else
                throw new RuntimeException("Ikke flere ledige pladser");
        }

    }

    public Reol createReol(String lagerNavn, int reolNr) {
        Reol reol = new Reol(lagerNavn, reolNr);
        reoler.add(reol);
        return reol;
    }

    public static void init() {
        Reol reol1 = new Reol("Sall", 1);
        Reol reol2 = new Reol("Sall", 2);
//        Reol reol3 = new Reol("Sall", 3);

        reoler.add(reol1);
        reoler.add(reol2);
//        reoler.add(reol3);
    }


}
