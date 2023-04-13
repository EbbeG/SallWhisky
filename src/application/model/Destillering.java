package application.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Destillering implements Serializable {
    private LocalDate startDato, slutDato;
    private int newMakeNr;
    private String medarbejderNavn;
    private double volume;
    private double alkoholProcent;
    private Kornsort kornsort;
    private String rygeMateriale;
    private String kommentar;
    // Skal destillering kunne se hvilke fade det ligger på? List<Fad>


    public Destillering(LocalDate startDato, LocalDate slutDato, int newMakeNr, String medarbejderNavn, double volume, double alkoholProcent, Kornsort kornsort) {
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.newMakeNr = newMakeNr;
        this.medarbejderNavn = medarbejderNavn;
        this.volume = volume;
        this.alkoholProcent = alkoholProcent;
        this.kornsort = kornsort;
    }

    public void reducerVolume(double liter) {
        if (liter > volume) {
            throw new IllegalArgumentException("Ikke nok destillat volume");
        }
        volume -= liter;
    }

    public void setRygeMateriale(String rygeMateriale) {
        this.rygeMateriale = rygeMateriale;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    @Override
    public String toString() {
        return "New make: " + newMakeNr;
    }

    public LocalDate getStarDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public int getNewMakeNr() {
        return newMakeNr;
    }

    public String getMedarbejderNavn() {
        return medarbejderNavn;
    }

    public double getVolume() {
        return volume;
    }

    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public Kornsort getKornsort() {
        return kornsort;
    }

    public String getRygeMateriale() {
        return rygeMateriale;
    }

    public String getKommentar() {
        return kommentar;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("New make: " + newMakeNr + "\n");
        sb.append("Start dato: " + startDato + "\n");
        sb.append("Slut dato: " + slutDato + "\n");
        sb.append("Medarbejder: " + medarbejderNavn + "\n");
        sb.append("Liter: " + volume + "\n");
        sb.append("Alkohol procent: " + alkoholProcent + "\n");
        sb.append("Kornsort: " + kornsort + "\n");

        if (rygeMateriale != null){
            sb.append("Ryge materiale: " + rygeMateriale + "\n");
        } if (kommentar != null){
            sb.append("Kommentar: " + kommentar + "\n");
        }

        return sb.toString();
    }
}
