package application.model;

import java.util.HashMap;
import java.util.Map;

public class Væske {
    private Map<Destillering, Double> destilleringer = new HashMap<>();
    private Map<Væske, Double> væsker = new HashMap<>();

    public Væske(Væske væske) {
        this.destilleringer = new HashMap<>(væske.destilleringer);
        this.væsker = new HashMap<>(væske.væsker);
    }

    public Væske() {}

    public void addDestillering(Destillering destillering, double liter) {
        destilleringer.put(destillering, liter);
    }

    public void addVæske(Væske v, double liter) {
        Væske væske = new Væske(v);
        væsker.put(væske, liter);
    }

    @Override
    public String toString() {
        return "Væske{" +
                "destilleringer=" + destilleringer +
                ", væsker=" + væsker +
                '}';
    }

    public Map<Destillering, Double> getDestilleringer() {
        return destilleringer;
    }

    public Map<Væske, Double> getVæsker() {
        return væsker;
    }
}
