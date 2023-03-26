package application.model;

public abstract class Indhold {

    private double volume;

    public Indhold(double volume) {
        this.volume = volume;
    }

    public void reducerVolume(double liter) {
        if (liter > volume) {
            throw new IllegalArgumentException("Ikke nok destillat volume");
        }
        volume -= liter;
    }

    public void increaseVolume(double liter) {
        volume += liter;
    }

    public double getVolume() {
        return volume;
    }

    public abstract String visInhold();


}
