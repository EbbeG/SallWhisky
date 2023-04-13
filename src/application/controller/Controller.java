package application.controller;

import application.model.*;
import storage.Storage;


import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Controller {
    private static Controller controller;
    private Storage storage;

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    private Controller() {
        storage = Storage.getStorage();
    }

    public Lager createLager(String lagernavn) {
        Lager lager = new Lager(lagernavn);
        storage.addLager(lager);
        return lager;
    }

    public void deleteLager(Lager lager) {
        storage.removeLager(lager);
    }

    public Destillering createDestillering(LocalDate startDato, LocalDate slutDato, int newMakeNr, String medarbejderNavn, double volume, double alkoholProcent, Kornsort kornsort) {
        Destillering destillering = new Destillering(startDato, slutDato, newMakeNr, medarbejderNavn, volume, alkoholProcent, kornsort);
        storage.addDestillering(destillering);
        return destillering;
    }

    public void deleteDestillering(Destillering destillering) {
        storage.removeDestillering(destillering);
    }

    public void setRygemateriale(Destillering destillering, String rygemateriale) {
        destillering.setRygeMateriale(rygemateriale);
    }

    public void setKommentar(Destillering destillering, String kommentar) {
        destillering.setKommentar(kommentar);
    }

    public Reol createReol(int reolNr) {
        Reol reol = new Reol(reolNr);
        return reol;
    }

    public Reol createReol(Lager lager, int reolNr) {
        return lager.createReol(reolNr);
    }

    public void deleteReolFromLager(Lager lager, Reol reol) {
        lager.removeReol(reol);
    }

    public Fad createFad(int nr, double størrelse, String oprindelse, String fadType) {
        Fad fad = new Fad(nr, størrelse, oprindelse, fadType);
        storage.addFad(fad);
        return fad;
    }

    public void addFadToReol(Reol reol, int pladsNr, Fad fad) {
        reol.addFad(pladsNr, fad);
    }

    public void removeFadFromReol(Reol reol, int pladsNr) {
        reol.removeFad(pladsNr);
    }

    public void fyldPåFadFraDestillering(Fad fad, Map<Destillering, Double> destilleringer, LocalDate påfyldningsDato) {
        for (Map.Entry<Destillering, Double> destilleringDoubleEntry : destilleringer.entrySet()) {
            fad.fyldPå(destilleringDoubleEntry.getKey(), destilleringDoubleEntry.getValue(), påfyldningsDato);
        }
    }

    public void fyldPåFadFraFad(Fad fad, Map<Fad, Double> fade, LocalDate påfyldningsDato) {
        for (Map.Entry<Fad, Double> fadDoubleEntry : fade.entrySet()) {
            fad.fyldPå(fadDoubleEntry.getKey(), fadDoubleEntry.getValue(), påfyldningsDato);
        }
    }

    public List<Lager> getLagre() {
        return storage.getLagre();
    }

    public List<Destillering> getDestilleringer() {
        return storage.getDestilleringer();
    }

    public List<Fad> getFade() {
        return storage.getFade();
    }



    public void loadStorage() {
        try (FileInputStream fileIn = new FileInputStream("storage.ser")) {
            try (ObjectInputStream in = new ObjectInputStream(fileIn);) {
                storage = (Storage) in.readObject();

                System.out.println("Storage loaded from file storage.ser.");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error loading storage object.");
                throw new RuntimeException(ex);
            }
        } catch (IOException ex) {
            System.out.println("Error loading storage object.");
            throw new RuntimeException(ex);
        }

    }

    public void saveStorage() {
        try (FileOutputStream fileOut = new FileOutputStream("storage.ser")) {
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(storage);
                System.out.println("Storage saved in file storage.ser.");
            }
        } catch (IOException ex) {
            System.out.println("Error saving storage object.");
            throw new RuntimeException(ex);
        }
    }


}
