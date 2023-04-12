package application.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Fad implements Serializable {
    private int nr;
    private double størrelse;
    private double volume = 0;
    private String oprindelse;
    private String fadType;
    private Væske væske;

    public Fad(int nr, double størrelse, String oprindelse, String fadType) {
        this.nr = nr;
        this.størrelse = størrelse;
        this.oprindelse = oprindelse;
        this.fadType = fadType;
    }

    public void fyldPå(Destillering destillering, double liter, LocalDate påfyldningsDato) {
        if (volume + liter > størrelse) {
            throw new IllegalArgumentException("Ikke nok plads på fad");
        }
        destillering.reducerVolume(liter);
        volume += liter;
        // Hvis fadet er tomt, laves en ny væske hvor første lagrings dato bliver sat til påfyldningsDato
        if (væske == null) {
            væske = new Væske(påfyldningsDato, this);
        }
        væske.addDestillering(destillering, liter);
    }

    public void fyldPå(Fad fad, double liter, LocalDate påfyldningsDato) {
        if (volume + liter > størrelse) {
            throw new IllegalArgumentException("Ikke nok plads på fad");
        }
        fad.reducerVolume(liter);
        volume += liter;
        // Hvis fadet er tomt, laves ny væske hvor første lagrings dato bliver sat til den tilsatte væskes første lagrings dato
        if (væske == null) {
            væske = new Væske(fad.getVæske().getFørsteLagring(), this);
        }
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

    public String getIndhold() {
        StringBuilder sb = new StringBuilder();
        sb.append(this + "\n");
        sb.append("Lagringsdato: " + væske.getFørsteLagring() + "\n");
        sb.append(væske.getIndhold());
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Fad " + nr + " (" + fadType + ")";
    }
}
