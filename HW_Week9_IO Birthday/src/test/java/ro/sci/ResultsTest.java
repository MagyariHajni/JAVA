package ro.sci;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static ro.sci.Results.addValidResultToList;
import static ro.sci.Results.getValidResults;

public class ResultsTest {
    private static final int ID = 0;
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final LocalDate DATE_OF_BIRTH = LocalDate.now();

    Person testPerson;
    Person testPerson2;
    List<Person> initialResults;

    @Before
    public void setUp() {
        testPerson = mock(Person.class);
        addValidResultToList(testPerson);
        initialResults = new ArrayList<>(getValidResults());
    }

    @Test
    public void testAddValidResultToList() {
        //given
        testPerson2 = new Person(ID,FIRST_NAME,LAST_NAME,DATE_OF_BIRTH);

        //when
        addValidResultToList(testPerson2);
        List<Person> currentResults = getValidResults();

        //then
        Assert.assertEquals(initialResults.size() + 1, currentResults.size());
        Assert.assertTrue(currentResults.contains(testPerson2));
        Assert.assertTrue(currentResults.containsAll(initialResults));
    }

    @Test
    public void testAddExistingPersonToList() {
        //given

        //when
        addValidResultToList(testPerson);
        List<Person> currentResults = getValidResults();

        //then
        Assert.assertEquals(initialResults.size(), currentResults.size());
        Assert.assertTrue(currentResults.contains(testPerson));
    }


}