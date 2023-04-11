package application.model;

import java.util.ArrayList;
import java.util.List;


public class Lager {

    private String lagerNavn;
    private static List<Reol> reoler = new ArrayList<>();

    public Lager(String lagerNavn) {
        this.lagerNavn = lagerNavn;
    }

    public Reol createReol(int reolNr) {
        Reol reol = new Reol(reolNr);
        reoler.add(reol);
        return reol;
    }
    public void addReol(Reol reol) {
        if (!reoler.contains(reol)) {
            reoler.add(reol);
        }
    }

    public void removeReol(Reol reol) {
        reoler.remove(reol);
    }

    public String getLagerNavn() {
        return lagerNavn;
    }

    public static List<Reol> getReoler() {
        return new ArrayList<>(reoler);
    }
}
