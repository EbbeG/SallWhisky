package application.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Lager implements Serializable {

    private String lagerNavn;
    private List<Reol> reoler = new ArrayList<>();

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

    public List<Reol> getReoler() {
        return new ArrayList<>(reoler);
    }

    @Override
    public String toString() {
        return lagerNavn;
    }
}
