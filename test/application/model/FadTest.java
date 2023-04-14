package application.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FadTest {

    @Test
    public void testFyldPå1() {
        Destillering destillering = new Destillering(LocalDate.now(), LocalDate.now(), 1, "Lars", 100.0,
                40.0, Kornsort.EVERGREEN);
        Fad fad = new Fad(50, 40,"Spanien","Bourbon");

        fad.fyldPå(destillering, 10.0, LocalDate.now());

        assertEquals(10.0, fad.getVolume(), 0.01);
        assertNotNull(fad.getVæske());
        Map<Destillering, Double> destilleringer = fad.getVæske().getDestilleringer();
        assertEquals(1, destilleringer.size());
        assertTrue(destilleringer.containsKey(destillering));
        assertEquals(10.0, destilleringer.get(destillering), 0.01);
    }

    @Test
    public void testFyldPå2() {
        Destillering destillering = new Destillering(LocalDate.now(), LocalDate.now(), 1, "Lars", 100.0,
                40.0, Kornsort.EVERGREEN);
        Fad fad = new Fad(50, 40,"Spanien","Bourbon");

        fad.fyldPå(destillering, 20.0, LocalDate.now());

        assertEquals(20.0, fad.getVolume(), 0.01);
        assertNotNull(fad.getVæske());
        Map<Destillering, Double> destilleringer = fad.getVæske().getDestilleringer();
        assertEquals(1, destilleringer.size());
        assertTrue(destilleringer.containsKey(destillering));
        assertEquals(20.0, destilleringer.get(destillering), 0.01);
    }

    // Test af ugyldig data

    @Test
    public void testFyldPå3() {
        Destillering destillering = new Destillering(LocalDate.now(), LocalDate.now(), 1, "Lars", 100.0,
                40.0, Kornsort.EVERGREEN);
        Fad fad = new Fad(50, 40,"Spanien","Bourbon");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            fad.fyldPå(destillering, 60.0, LocalDate.now());
        });

        String expectedMessage = "Ikke nok plads på fad";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void TestFyldPåFad1() {
        Destillering destillering = new Destillering(LocalDate.now(), LocalDate.now(), 1, "Lars", 100.0,
                40.0, Kornsort.EVERGREEN);
        Fad fad = new Fad(1,50,"Spanien","Bourbon");
        Fad fad1 = new Fad(2,100,"Spanien","Bourbon");
        LocalDate påfyldningsDato = LocalDate.now();
        fad.fyldPå(destillering, 50, påfyldningsDato);


        fad1.fyldPå(fad,25, påfyldningsDato);
        assertEquals(25, fad1.getVolume(), 0.0);
    }

    @Test
    public void TestFyldPåFad2() {
        Destillering destillering = new Destillering(LocalDate.now(), LocalDate.now(), 1, "Lars", 100.0,
                40.0, Kornsort.EVERGREEN);
        Fad fad = new Fad(1, 50, "Spanien", "Bourbon");
        Fad fad1 = new Fad(2, 100, "Spanien", "Bourbon");
        LocalDate påfyldningsDato = LocalDate.now();
        fad.fyldPå(destillering, 50, påfyldningsDato);

        fad1.fyldPå(fad, 50, påfyldningsDato);
        assertEquals(50, fad1.getVolume(), 0.0);
    }

    // Test af ugylidig data

    @Test
    public void TestFyldPåFad3() {
        Destillering destillering = new Destillering(LocalDate.now(), LocalDate.now(), 1, "Lars", 150.0,
                40.0, Kornsort.EVERGREEN);
        Fad fad = new Fad(1, 150, "Spanien", "Bourbon");
        Fad fad1 = new Fad(2, 100, "Spanien", "Bourbon");
        LocalDate påfyldningsDato = LocalDate.now();
        fad.fyldPå(destillering, 120, påfyldningsDato);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            fad1.fyldPå(fad, 110, påfyldningsDato);
        });

        String expectedMessage = "Ikke nok plads på fad";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}