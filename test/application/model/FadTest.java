package application.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FadTest {
    @Test
    public void testFyldPå() {
        Destillering destillering = new Destillering(LocalDate.now(), LocalDate.now(), 1, "Lars", 10.0,
                40.0, Kornsort.EVERGREEN);
        Fad fad = new Fad(50, 40,"Spanien","Bourbon");

        fad.fyldPå(destillering, 10.0, LocalDate.now());

        assertEquals(10.0, fad.getVolume());
        assertNotNull(fad.getVæske());
        assertEquals(1, fad.getVæske().getDestilleringer().size());
        assertEquals(destillering, fad.getVæske().getDestilleringer().get(0));
        assertEquals(10.0, fad.getVæske().getDestilleringer().get(0));
    }

    @Test
    public void testFyldPåThrowsException() {
        Destillering destillering = new Destillering(LocalDate.now(), LocalDate.now(), 1, "Lars", 50.0,
                40.0, Kornsort.EVERGREEN);
        Fad fad = new Fad(50, 40,"Spanien","Bourbon");

        assertThrows(IllegalArgumentException.class, () -> fad.fyldPå(destillering, 10.0, LocalDate.now()));
    }
}