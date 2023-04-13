package application.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DestilleringTest {
    private static final double DELTA = 0.000001;

    @Test
    public void testReducerVolume1() {
        LocalDate startDato = LocalDate.of(2023, 4, 13);
        LocalDate slutDato = LocalDate.of(2023, 4, 14);
        int newMakeNr = 1;
        String medarbejderNavn = "Lars";
        double volume = 10.0;
        double alkoholProcent = 40.0;
        Kornsort kornsort = Kornsort.EVERGREEN;

        Destillering destillering = new Destillering(startDato, slutDato, newMakeNr, medarbejderNavn, volume, alkoholProcent, kornsort);

        // Test reducing volume with valid input
        destillering.reducerVolume(2.0);
        assertEquals(8.0, destillering.getVolume(), DELTA);
    }

    public void testReducerVolume2() {
        LocalDate startDato = LocalDate.of(2023, 4, 13);
        LocalDate slutDato = LocalDate.of(2023, 4, 14);
        int newMakeNr = 1;
        String medarbejderNavn = "Lars";
        double volume = 15.0;
        double alkoholProcent = 40.0;
        Kornsort kornsort = Kornsort.EVERGREEN;

        Destillering destillering = new Destillering(startDato, slutDato, newMakeNr, medarbejderNavn, volume, alkoholProcent, kornsort);

        // Test reducing volume with valid input
        destillering.reducerVolume(5.0);
        assertEquals(10.0, destillering.getVolume(), DELTA);
    }

    // Test reducing af volume med ugyldig data

    public void testReducerVolume3() {
        LocalDate startDato = LocalDate.of(2023, 4, 13);
        LocalDate slutDato = LocalDate.of(2023, 4, 14);
        int newMakeNr = 1;
        String medarbejderNavn = "Lars";
        double volume = 10.0;
        double alkoholProcent = 40.0;
        Kornsort kornsort = Kornsort.EVERGREEN;

        Destillering destillering = new Destillering(startDato, slutDato, newMakeNr, medarbejderNavn, volume, alkoholProcent, kornsort);

        // Test reducing volume with valid input
        destillering.reducerVolume(11.0);
        assertEquals(-1.0, destillering.getVolume(), DELTA);
        assertThrows(IllegalArgumentException.class, () -> destillering.reducerVolume(11.0));
    }

    public void testReducerVolume4() {
        LocalDate startDato = LocalDate.of(2023, 4, 13);
        LocalDate slutDato = LocalDate.of(2023, 4, 14);
        int newMakeNr = 1;
        String medarbejderNavn = "Lars";
        double volume = 10.0;
        double alkoholProcent = 40.0;
        Kornsort kornsort = Kornsort.EVERGREEN;

        Destillering destillering = new Destillering(startDato, slutDato, newMakeNr, medarbejderNavn, volume, alkoholProcent, kornsort);

        // Test reducing volume with valid input
        destillering.reducerVolume(-11.0);
        assertEquals(-1.0, destillering.getVolume(), DELTA);
        assertThrows(IllegalArgumentException.class, () -> destillering.reducerVolume(-1.0));
    }

    @Test
    public void testGetStarDato() {
        LocalDate startDato = LocalDate.now();
        Destillering destillering = new Destillering(startDato, null, 1, "Lars", 10.0,
                40.0, Kornsort.EVERGREEN);
        assertEquals(startDato, destillering.getStarDato());
    }

    @Test
    public void testGetSlutDato() {
        LocalDate slutDato = LocalDate.now();
        Destillering destillering = new Destillering(null, slutDato, 1, "Lars", 10.0,
                40.0, Kornsort.EVERGREEN);
        assertEquals(slutDato, destillering.getSlutDato());
    }

    @Test
    public void testGetNewMakeNr() {
        int newMakeNr = 1;
        Destillering destillering = new Destillering(null, null, newMakeNr, "Lars", 10.0,
                40.0, Kornsort.EVERGREEN);
        assertEquals(newMakeNr, destillering.getNewMakeNr());
    }

    @Test
    public void testGetMedarbejderNavn() {
        String medarbejderNavn = "Lars";
        Destillering destillering = new Destillering(null, null, 1, medarbejderNavn, 10.0,
                40.0, Kornsort.EVERGREEN);
        assertEquals(medarbejderNavn, destillering.getMedarbejderNavn());
    }

    @Test
    public void testGetVolume() {
        double volume = 10.0;
        Destillering destillering = new Destillering(null, null, 1, "Lars", volume,
                40.0, Kornsort.EVERGREEN);
        assertEquals(volume, destillering.getVolume(), 0.0);
    }

    @Test
    public void testGetAlkoholProcent() {
        double alkoholProcent = 40.0;
        Destillering destillering = new Destillering(null, null, 1, "Lars", 10.0,
                alkoholProcent, Kornsort.EVERGREEN);
        assertEquals(alkoholProcent, destillering.getAlkoholProcent(), 0.0);
    }

    @Test
    public void testGetKornsort() {
        Kornsort kornsort = Kornsort.EVERGREEN;
        Destillering destillering = new Destillering(null, null, 1, "Lars", 10.0,
                40.0, kornsort);
        assertEquals(kornsort, destillering.getKornsort());
    }

    @Test
    public void testGetRygeMateriale() {
        String rygeMateriale = "Tørv";
        Destillering destillering = new Destillering(null, null, 1, "Lars", 10.0,
                40.0, Kornsort.EVERGREEN);
        destillering.setRygeMateriale(rygeMateriale);
        assertEquals(rygeMateriale, destillering.getRygeMateriale());
    }
    @Test
    void testGetKommentar() {
        Destillering destillering = new Destillering(
                LocalDate.now(), LocalDate.now().plusDays(1),
                1, "Test Medarbejder", 10.0, 40.0, Kornsort.EVERGREEN);
        destillering.setKommentar("Test Kommentar");
        assertEquals("Test Kommentar", destillering.getKommentar());
    }

    @Test
    void testGetInfo() {
        Destillering destillering = new Destillering(
                LocalDate.now(), LocalDate.now().plusDays(1),
                1, "Test Medarbejder", 10.0, 40.0, Kornsort.EVERGREEN);
        destillering.setRygeMateriale("Test Rygemateriale");
        destillering.setKommentar("Test Kommentar");

        String expected = "New make: 1\n" +
                "Start dato: " + LocalDate.now() + "\n" +
                "Slut dato: " + LocalDate.now().plusDays(1) + "\n" +
                "Medarbejder: Test Medarbejder\n" +
                "Liter: 10.0\n" +
                "Alkohol procent: 40.0\n" +
                "Kornsort: EVERGREEN\n" +
                "Ryge materiale: Test Rygemateriale\n" +
                "Kommentar: Test Kommentar\n";

        assertEquals(expected, destillering.getInfo());
    }
}
