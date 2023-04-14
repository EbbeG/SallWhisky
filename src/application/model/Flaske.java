package application.model;

import java.io.Serializable;

public class Flaske implements Serializable {
    private int flaskeNr;
    private int mængde;
    private Whisky whisky;

    public Flaske(int flaskeNr, int mængde) {
        this.flaskeNr = flaskeNr;
        this.mængde = mængde;
    }
    public void visHistorik(){

    }

    public int getFlaskeNr() {
        return flaskeNr;
    }
    public int getMængde() {
        return mængde;
    }

}
