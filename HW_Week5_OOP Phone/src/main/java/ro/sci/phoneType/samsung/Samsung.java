package ro.sci.phoneType.samsung;

import ro.sci.phoneType.Phone;

import java.util.ArrayList;
import java.util.List;

public class Samsung extends Phone {

    public static List<String> phoneTypesSamsung() {
        List<String> phoneTypes = new ArrayList();

        phoneTypes.add("SamsungGalaxyA22");
        phoneTypes.add("SamsungGalaxyS6");

        return phoneTypes;
    }

}
