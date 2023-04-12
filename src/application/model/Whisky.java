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

    public Whisky(int nr, WhiskyType type, String beskrivelse, double alkoholProcent, double fortyndelseMængde, Map<Fad, Double> fade) {
        this.nr = nr;
        this.type = type;
        this.beskrivelse = beskrivelse;
        this.alkoholProcent = alkoholProcent;
        this.fortyndelseMængde = fortyndelseMængde;
        this.væske = new Væske();
        for (Map.Entry<Fad, Double> fadDoubleEntry : fade.entrySet()) {
            væske.addVæske(fadDoubleEntry.getKey().getVæske(), fadDoubleEntry.getValue());
        }
    }




}
