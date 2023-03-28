package application.model;

import java.util.ArrayList;
import java.util.List;

public class Fad extends Pourable {
    private int nr;
    private double kapacitet;
    private String oprindelse;
    private String fadType;
    private List<Påfyldning> påfyldninger = new ArrayList<>();

    public Fad(int nr, double kapacitet, String oprindelse, String fadType) {
        super(0);
        this.nr = nr;
        this.kapacitet = kapacitet;
        this.oprindelse = oprindelse;
        this.fadType = fadType;
    }

    public void fyldPå(Destillering destillering, double liter) {
        if (volume + liter > kapacitet) {
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

    public void increaseVolume(double liter) {
        double currentVolume = getVolume();
        if (currentVolume + liter > kapacitet) {
            throw new IllegalArgumentException("Ikke nok plads på fad");
        }
        setVolume(currentVolume + liter);
    }

    public int getNr() {
        return nr;
    }

    public double getKapacitet() {
        return kapacitet;
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
