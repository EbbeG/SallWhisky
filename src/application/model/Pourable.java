package application.model;

public abstract class Pourable {
    private double volume;

    public Pourable(double volume) {
        this.volume = volume;
    }

    public void reducerVolume(double liter) {
        if (liter > volume) {
            throw new IllegalArgumentException("Ikke nok destillat volume");
        }
        volume -= liter;
    }



    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
