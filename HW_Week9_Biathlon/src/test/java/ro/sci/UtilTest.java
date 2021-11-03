package ro.sci;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ro.sci.Util.checkInputErrors;

public class UtilTest {

    @Test
    public void testNotValidCsvInput() {
        //given
        String inputLine = "a,,,aa:2:7,abcox,xxoxxx,xxx";
        String[] inputData = inputLine.split(",");

        //when
        String inputError = checkInputErrors(inputLine);
        String[] inputErrorList = inputError.split(" -");

        //then
        assertEquals(7, inputData.length);
        assertEquals("not valid athlete number a",inputErrorList[1]);
        assertEquals("not valid time result input aa:2:7",inputErrorList[2]);
        assertEquals("not valid first shooting range result input abcox",inputErrorList[3]);
        assertEquals("not valid second shooting range result input xxoxxx",inputErrorList[4]);
        assertEquals("not valid third shooting range result input xxx",inputErrorList[5]);
    }

    @Test
    public void testEmptyOrPartialCsvInput() {
        //given
        String inputLine1 = "a,,abcox,xxoxxx,xxx";
        String inputLine2 = "";

        //when
        String inputError1 = checkInputErrors(inputLine1);
        String inputError2 = checkInputErrors(inputLine2);

        //then
        assertEquals(" -missing data", inputError1,inputError2);
    }


}