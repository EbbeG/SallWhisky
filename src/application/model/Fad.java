package application.model;

public class Fad {
    private int nr;
    private WhiskyType type;
    private double størrelse;
    private String oprindelse;
    private String tidligereIndhold;

    public Fad(int nr, WhiskyType type, double størrelse, String oprindelse, String tidligereIndhold) {
        this.nr = nr;
        this.type = type;
        this.størrelse = størrelse;
        this.oprindelse = oprindelse;
        this.tidligereIndhold = tidligereIndhold;
    }

    public void addTilLager() {
        Lager.addFad(this);
    }
}
