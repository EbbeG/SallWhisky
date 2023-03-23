package application.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reol {
    private int reolNr;
    private Map<Integer, Fad> plads = new HashMap<>();


    public Reol(int reolNr) {
        this.reolNr = reolNr;
    }

    public void addFad(int pladsNr, Fad fad) {
        plads.put(pladsNr, fad);
    }

    public void removeFad(int pladsNr) {
        plads.remove(pladsNr);
    }

    public Fad getFad(int pladsNr) {
        return plads.get(pladsNr);
    }

    public List<Fad> getFade() {
        return new ArrayList<>(plads.values());
    }




}
