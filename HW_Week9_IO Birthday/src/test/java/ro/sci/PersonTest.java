package ro.sci;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;
import static ro.sci.Person.processValidResult;

public class PersonTest {
    private static final int LINE_NUMBER = 0;
    private static final String VALID_INPUT = "firstName,lastName,01/01/2000";

    @Test
    public void testProcessValidResult() {
        //given

        //when
        Person newPerson = processValidResult(LINE_NUMBER, VALID_INPUT);

        //then
        assertEquals(0,newPerson.getId());
        assertEquals("firstName",newPerson.getFirstName());
        assertEquals("lastName",newPerson.getLastName());
        assertEquals(LocalDate.of(2000,1,1),newPerson.getDateOfBirth());
    }
}