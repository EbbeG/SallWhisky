package application.model;

import java.util.HashMap;
import java.util.Map;

public class Fad extends Indhold {
    private int nr;
    private double størrelse;
    private String oprindelse;
    private String fadType;
    private Map<Indhold, Double> indholdLiter = new HashMap<>();

    public Fad(int nr, double størrelse, String oprindelse, String fadType) {
        super(0);
        this.nr = nr;
        this.størrelse = størrelse;
        this.oprindelse = oprindelse;
        this.fadType = fadType;
    }

    public void fyldPå(Indhold indhold, double liter) {
        if (getVolume() + liter > størrelse) {
            throw new IllegalArgumentException("Ikke nok plads på fad");
        }
        indhold.reducerVolume(liter);
        increaseVolume(liter);
        // Hvis fad allerede indeholder destillering, bliver volumen forøget
        if (indholdLiter.containsKey(indhold)) {
            liter += indholdLiter.get(indhold);
        }

        indholdLiter.put(indhold, liter);
    }

    @Override
    public String visInhold() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fad: " + nr + "\n");
        for (Indhold indhold : indholdLiter.keySet()) {
            sb.append(indholdLiter.get(indhold) + " Liter af \n" + indhold.visInhold().replaceAll("(?m)^", "\t") + "\n");

        }
        return sb.toString();
    }

    public int getNr() {
        return nr;
    }

    public double getStørrelse() {
        return størrelse;
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
