package storage;

import application.model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Storage implements Serializable {
    private static Storage storage;

    private List<Lager> lagre;
    private List<Destillering> destilleringer;
    private List<Fad> fade;
    private List<Whisky> whishkies;
    private List<Flaske> flasker;

    public static Storage getStorage() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    private Storage() {
        lagre = new ArrayList<>();
        destilleringer = new ArrayList<>();
        fade = new ArrayList<>();
        whishkies = new ArrayList<>();
        flasker = new ArrayList<>();
    }

    // -------------------------------------------------------------------------


    public List<Lager> getLagre() {
        return new ArrayList<>(lagre);
    }

    public void addLager(Lager lager) {
        lagre.add(lager);
    }

    public void removeLager(Lager lager) {
        lagre.remove(lager);
    }

    // -------------------------------------------------------------------------

    public List<Destillering> getDestilleringer() {
        return new ArrayList<>(destilleringer);
    }

    public void addDestillering(Destillering destillering) {
        destilleringer.add(destillering);
    }

    public void removeDestillering(Destillering destillering) {
        destilleringer.remove(destillering);
    }

    // -------------------------------------------------------------------------

    public List<Fad> getFade() {
        return new ArrayList<>(fade);
    }

    public void addFad(Fad fad) {
        fade.add(fad);
    }

    public void removeFad(Fad fad) {
        fade.remove(fad);
    }

    // -------------------------------------------------------------------------

    public List<Whisky> getWhiskies() {
        return new ArrayList<>(whishkies);
    }

    public void addWhisky(Whisky whisky) {
        whishkies.add(whisky);
    }

    public void removeWhisky(Whisky whisky) {
        whishkies.remove(whisky);
    }

    // -------------------------------------------------------------------------
    public List<Flaske> getFlasker() {
        return new ArrayList<>(flasker);
    }

    public void addFlaske(Flaske flaske) {
        flasker.add(flaske);
    }

    public void removeFlaske(Flaske flaske) {
        flasker.remove(flaske);
    }



}
