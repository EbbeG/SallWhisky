package application.model;

import java.util.HashMap;
import java.util.Map;

public class Fad {
    private int nr;
    private double størrelse;
    private double volume = 0;
    private String oprindelse;
    private String fadType;
    private Væske væske = new Væske();

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
        væske.addDestillering(destillering, liter);
    }

    public void fyldPå(Fad fad, double liter) {
        if (volume + liter > størrelse) {
            throw new IllegalArgumentException("Ikke nok plads på fad");
        }
        fad.reducerVolume(liter);
        volume += liter;
        væske.addVæske(fad.getVæske(), liter);
    }

    public void reducerVolume(double liter) {
        if (liter > volume) {
            throw new IllegalArgumentException("Ikke nok destillat volume");
        }
        volume -= liter;
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

    public Væske getVæske() {
        return væske;
    }

    @Override
    public String toString() {
        return "nr: " + nr + " Fadtype: " + fadType;
    }
}
