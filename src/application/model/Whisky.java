package application.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Whisky implements Serializable {
    int nr;
    WhiskyType type;
    Væske væske;
    String beskrivelse;
    double alkoholProcent;
    double fortyndelseMængde;
    double volume = 0;

    public Whisky(int nr, WhiskyType type, String beskrivelse, double alkoholProcent, double fortyndelseMængde, Map<Fad, Double> fade) {
        this.nr = nr;
        this.type = type;
        this.beskrivelse = beskrivelse;
        this.alkoholProcent = alkoholProcent;
        this.fortyndelseMængde = fortyndelseMængde;
        for (Map.Entry<Fad, Double> fadDoubleEntry : fade.entrySet()) {
            Fad fad = fadDoubleEntry.getKey();
            Double liter = fadDoubleEntry.getValue();
            fad.reducerVolume(liter);

            if (this.væske == null) {
                this.væske = new Væske(fad.getVæske().getFørsteLagring(), null);
            }
            væske.addVæske(fad.getVæske(), liter);
            volume += liter;
        }
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this + "\n");
        sb.append("Volume: " + volume + " Liter\n");
        sb.append("Beskrivelse: " + beskrivelse + "\n");
        sb.append("Alkoholprocent: " + alkoholProcent + "%\n");
        sb.append("Fortyndelse mængde: " + fortyndelseMængde + " Liter\n");
        sb.append("Lagringsdato: " + væske.getFørsteLagring() + "\n\n");

        sb.append("Historik:\n");
        sb.append(væske.getIndhold());

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Whisky " + nr + " (" + type + ")";
    }
}
