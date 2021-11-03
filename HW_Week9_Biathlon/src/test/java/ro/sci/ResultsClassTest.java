package ro.sci;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static ro.sci.ResultsClass.*;

public class ResultsClassTest {

    static final int ATHLETE_NUMBER = 0;
    static final String ATHLETE_NAME = "AthleteName";
    static final String COUNTRY_CODE = "Code";
    static final Duration SKI_TIME_RESULTS = Duration.ZERO;
    static final String FIRST_SHOOTING_RANGE = "xxxxx";
    static final String SECOND_SHOOTING_RANGE = "xxxxx";
    static final String THIRD_SHOOTING_RANGE = "xxxxx";

    Athlete testAthlete;
    Athlete testAthlete2;
    List<Athlete> initialResults;

    @Before
    public void setUp() {
        testAthlete = mock(Athlete.class);
        testAthlete2 = new Athlete(ATHLETE_NUMBER, ATHLETE_NAME, COUNTRY_CODE, SKI_TIME_RESULTS, FIRST_SHOOTING_RANGE, SECOND_SHOOTING_RANGE, THIRD_SHOOTING_RANGE);
    }


    @Test
    public void testAddValidResultToList() {
        //given
        initialResults = new ArrayList<>(getValidResultsStandings());
        //when
        addValidResultToList(testAthlete);
        List<Athlete> currentResults = getValidResultsStandings();

        //then
        Assert.assertEquals(initialResults.size() + 1, currentResults.size());
        Assert.assertTrue(currentResults.contains(testAthlete));
        Assert.assertTrue(currentResults.containsAll(initialResults));
    }

    @Test
    public void testAddExistingValidResultToList() {
        //given
        addValidResultToList(testAthlete);
        initialResults = new ArrayList<>(getValidResultsStandings());

        //when
        addValidResultToList(testAthlete);
        List<Athlete> currentResults = getValidResultsStandings();

        //then
        Assert.assertEquals(initialResults.size(), currentResults.size());
    }


}