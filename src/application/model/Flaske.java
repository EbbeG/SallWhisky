package application.model;

import java.io.Serializable;

public class Flaske implements Serializable {
    private int flaskeNr;
    private int mængde;
    private Whisky whisky;

    public Flaske(int flaskeNr, int mængde, Whisky whisky) {
        this.flaskeNr = flaskeNr;
        this.mængde = mængde;
        this.whisky = whisky;
    }
    public String visHistorik() {
        StringBuilder sb = new StringBuilder();
        sb.append("Flaske nr: " + flaskeNr + ", antal: " + mængde + "\n");
        sb.append(whisky.getInfo());
        return sb.toString();

    }

    public int getFlaskeNr() {
        return flaskeNr;
    }
    public int getMængde() {
        return mængde;
    }

    @Override
    public String toString() {
        return "Flaske " + flaskeNr + " (" +  mængde + " stk.)";
    }
}
