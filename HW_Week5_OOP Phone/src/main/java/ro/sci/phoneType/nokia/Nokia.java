package ro.sci.phoneType.nokia;

import ro.sci.phoneType.Phone;

import java.util.ArrayList;
import java.util.List;

public class Nokia extends Phone {
    public static List<String> phoneTypesNokia () {
        List<String> phoneTypes= new ArrayList();

        phoneTypes.add("NokiaC10");
        phoneTypes.add("NokiaG50");

        return phoneTypes;
    }




}
