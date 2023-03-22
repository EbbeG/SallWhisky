package application.model;

public class Reol {
    private String lagerNavn;
    private int reolNr;
    private Fad[] pladser = new Fad[4];
    private boolean fuld = false;
    private int antalFad = 0;

    public Reol(String lagerNavn, int reolNr) {
        this.lagerNavn = lagerNavn;
        this.reolNr = reolNr;
    }

    public void addFad(Fad fad) {
        System.out.println(antalFad);
        if (antalFad < 4) {
            pladser[antalFad] = fad;
            antalFad++;
        } else {
            fuld = true;
        }
    }

    public boolean isFuld() {
        return fuld;
    }
}
