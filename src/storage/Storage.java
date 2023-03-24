package storage;

import application.model.Destillering;
import application.model.Lager;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Storage storage;

    private List<Lager> lagre;
    private List<Destillering> destilleringer;

    public static Storage getStorage() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    private Storage() {
        lagre = new ArrayList<>();
        destilleringer = new ArrayList<>();
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

}
