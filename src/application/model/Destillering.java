package application.model;

import java.time.LocalDate;

public class Destillering extends Pourable {
    private LocalDate starDato, slutDato;
    // maltBatch?
    private int newMakeNr;
    private String medarbejderNavn;
    private double alkoholProcent;
    private Kornsort kornsort;
    private String rygeMateriale;
    private String kommentar;
    // Skal destillering kunne se hvilke fade det ligger på? List<Fad>


    public Destillering(LocalDate starDato, LocalDate slutDato, int newMakeNr, String medarbejderNavn, double volume, double alkoholProcent, Kornsort kornsort) {
        super(volume);
        this.starDato = starDato;
        this.slutDato = slutDato;
        this.newMakeNr = newMakeNr;
        this.medarbejderNavn = medarbejderNavn;
        this.alkoholProcent = alkoholProcent;
        this.kornsort = kornsort;
    }


    public void setRygeMateriale(String rygeMateriale) {
        this.rygeMateriale = rygeMateriale;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}
