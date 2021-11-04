package ro.sci;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ro.sci.Util.checkInputErrors;

public class UtilTest {
    private static final String ERROR_MISSING_DATA_INPUT = ",lastName,";
    private static final String ERROR_EMPTY_DATA_INPUT = "";
    private static final String ERROR_INCORRECT_DATE_FORMAT_INPUT = "firstName,lastName,01/2000";
    private static final String ERROR_INCORRECT_DATE_FORMAT_INPUT2 = "firstName,lastName,a/b/c";
    private static final String ERROR_INCORRECT_DATE_INPUT = "firstName,lastName,35/15/1800";
    private static final String VALID_INPUT = "firstName,lastName,01/01/2000";

    @Test
    public void testCheckInputErrorsWithIncompleteData() {
        //given

        //when
        String errorMissingData = checkInputErrors(ERROR_MISSING_DATA_INPUT);
        String errorEmptyData = checkInputErrors(ERROR_EMPTY_DATA_INPUT);

        //then
        assertEquals(" -missing data", errorMissingData, errorEmptyData);
    }


    @Test
    public void testCheckInputErrorsWithIncorrectDateFormat() {
        //given

        //when
        String errorIncorrectDateFormat = checkInputErrors(ERROR_INCORRECT_DATE_FORMAT_INPUT);
        String errorIncorrectDateFormat2 = checkInputErrors(ERROR_INCORRECT_DATE_FORMAT_INPUT2);

        //then
        assertEquals("-not valid birthdate input", errorIncorrectDateFormat.substring(1, 27), errorIncorrectDateFormat2.substring(1, 27));
    }


    @Test
    public void testCheckInputErrorsWithIncorrectDate() {
        //given

        //when
        String errorIncorrectDate = checkInputErrors(ERROR_INCORRECT_DATE_INPUT);

        //then
        assertTrue(errorIncorrectDate.contains("-invalid number 35 for day (must be a number between 01 and 31)")
                && errorIncorrectDate.contains("-invalid number 15 for month (must be a number between 01 and 12)")
                && errorIncorrectDate.contains("-invalid number 1800 for year (must be a number between 1900 and"));
    }

    @Test
    public void testCheckInputErrorsWithValidInput() {
        //given

        //when
        String validInput = checkInputErrors(VALID_INPUT);

        //then
        assertEquals("", validInput);
    }


}