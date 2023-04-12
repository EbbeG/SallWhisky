package application.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reol implements Serializable {
    private int reolNr;
    private Map<Integer, Fad> pladser = new HashMap<>();


    public Reol(int reolNr) {
        this.reolNr = reolNr;
    }

    public void addFad(int pladsNr, Fad fad) {
        pladser.put(pladsNr, fad);
    }

    public void removeFad(int pladsNr) {
        pladser.remove(pladsNr);
    }

    public Fad getFad(int pladsNr) {
        return pladser.get(pladsNr);
    }

    public List<Fad> getFade() {
        return new ArrayList<>(pladser.values());
    }




}
