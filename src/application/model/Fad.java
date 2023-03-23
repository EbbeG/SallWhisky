package application.model;

import java.util.HashMap;
import java.util.Map;

public class Fad {
    private int nr;
    private double størrelse;
    private double volume = 0;
    private String oprindelse;
    private String fadType;
    private Map<Destillering, Double> indholdLiter = new HashMap<>();

    public Fad(int nr, double størrelse, String oprindelse, String fadType) {
        this.nr = nr;
        this.størrelse = størrelse;
        this.oprindelse = oprindelse;
        this.fadType = fadType;
    }

    public void fyldPå(Destillering destillering, double liter) {
        if (volume + liter > størrelse) {
            throw new IllegalArgumentException("Ikke nok plads på fad");
        }
        destillering.reducerVolume(liter);
        volume += liter;
        // Hvis fad allerede indeholder destillering, bliver volumen forøget
        if (indholdLiter.containsKey(destillering)) {
            liter += indholdLiter.get(destillering);
        }

        indholdLiter.put(destillering, liter);


    }

    public int getNr() {
        return nr;
    }

    public double getStørrelse() {
        return størrelse;
    }

    public double getVolume() {
        return volume;
    }

    public String getOprindelse() {
        return oprindelse;
    }

    public String getFadType() {
        return fadType;
    }

    @Override
    public String toString() {
        return "nr: " + nr + " Fadtype: " + fadType;
    }
}
