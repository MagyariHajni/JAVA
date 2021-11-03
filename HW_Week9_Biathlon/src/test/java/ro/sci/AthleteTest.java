package ro.sci;

import org.junit.Test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AthleteTest {

    @Test
    public void testValidCsvInput() {
        //given
        String inputLine = "22,Umar Jorgson,SK,30:27,xxxox,xxoxx,xxoxo";
        Duration inputFinalResult = Duration.ofSeconds(30 * 60 + 27L + 4 * 10);

        //when
        Athlete newAthlete = Athlete.processValidResult(inputLine);

        //then
        assertNotNull(newAthlete);
        assertEquals(22, newAthlete.getAthleteNumber());
        assertEquals("Umar Jorgson", newAthlete.getAthleteName());
        assertEquals("SK", newAthlete.getCountryCode());
        assertEquals(Duration.ofSeconds(30 * 60 + 27L), newAthlete.getSkiTimeResults());
        assertEquals("xxxox", newAthlete.getFirstShootingRange());
        assertEquals("xxoxx", newAthlete.getSecondShootingRange());
        assertEquals("xxoxo", newAthlete.getThirdShootingRange());
        assertEquals(inputFinalResult, newAthlete.getFinalResult());
    }

}