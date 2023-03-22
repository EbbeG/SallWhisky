package application.model;

public class LagerApp {
    public static void main(String[] args) {
        Lager.init();
        Fad fad = new Fad(1, WhiskyType.SINGLEMALT, 30, "Spanien", "Sherry");
        Fad fad1 = new Fad(2, WhiskyType.SINGLEMALT, 30, "Spanien", "Sherry");
        Fad fad2 = new Fad(3, WhiskyType.SINGLEMALT, 30, "Spanien", "Sherry");
        Fad fad3 = new Fad(4, WhiskyType.SINGLEMALT, 30, "Spanien", "Sherry");
        Fad fad4 = new Fad(5, WhiskyType.SINGLEMALT, 30, "Spanien", "Sherry");
        Lager.addFad(fad);
        Lager.addFad(fad1);
        Lager.addFad(fad2);
        Lager.addFad(fad3);
        Lager.addFad(fad4);
        Lager.addFad(fad4);
        Lager.addFad(fad4);
        Lager.addFad(fad4);
        Lager.addFad(fad4);
        Lager.addFad(fad4);
        Lager.addFad(fad4);
        Lager.addFad(fad4);
        Lager.addFad(fad4);

    }
}
