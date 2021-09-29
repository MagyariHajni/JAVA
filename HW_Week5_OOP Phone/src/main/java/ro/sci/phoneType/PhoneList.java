package ro.sci.phoneType;

import java.util.ArrayList;
import java.util.List;

public class PhoneList {

    static List<Phone> phoneList= new ArrayList<>();

    public static void addPhone(Phone Phone){
        phoneList.add(Phone);
    }

    public static List<Phone> generatePhoneList(){
        return phoneList;
    }
}
