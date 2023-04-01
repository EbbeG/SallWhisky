package application.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Væske {
    private Map<Destillering, Double> destilleringer = new HashMap<>();
    private Map<Væske, Double> væsker = new HashMap<>();
    private LocalDate førsteLagring;

    public Væske(Væske væske) {
        this.destilleringer = væske.getDestilleringer();
        this.væsker = væske.getVæsker();
        this.førsteLagring = væske.getFørsteLagring();
    }

    public Væske(LocalDate førsteLagring) {
        this.førsteLagring = førsteLagring;
    }

    public void addDestillering(Destillering destillering, double liter) {
        // Hvis væske allerede indeholder destillering, bliver volumen bare forøget
        if (destilleringer.containsKey(destillering)) {
            liter += destilleringer.get(destillering);
        }
        destilleringer.put(destillering, liter);
    }

    public void addVæske(Væske v, double liter) {
        // Laver nyt væske objekt, så ændringer til originale væske ikke påvirker indholdet af den væske der blev tilføjet
        Væske væske = new Væske(v);
        væsker.put(væske, liter);
    }

    public String getIndhold() {
        StringBuilder sb = new StringBuilder();

        sb.append("Destillater:\n");

        for (Destillering destillering : destilleringer.keySet()) {
            String s = "New Make: " + destillering.getNewMakeNr() + ", " + destilleringer.get(destillering) + " Liter\n";
            sb.append(s.indent(2));
        }

        if (!væsker.isEmpty()) {
            sb.append("\nVæsker:\n");

            for (Væske væske : væsker.keySet()) {
                sb.append(væsker.get(væske) + " Liter\n");
                String s = væske.getIndhold();
                sb.append(s.indent(2));
            }
        }



        return sb.toString();
    }

    @Override
    public String toString() {
        return "Væske{" +
                "destilleringer=" + destilleringer +
                ", væsker=" + væsker +
                '}';
    }

    public Map<Destillering, Double> getDestilleringer() {
        return new HashMap<>(destilleringer);
    }

    public Map<Væske, Double> getVæsker() {
        return new HashMap<>(væsker);
    }

    public LocalDate getFørsteLagring() {
        return førsteLagring;
    }
}
