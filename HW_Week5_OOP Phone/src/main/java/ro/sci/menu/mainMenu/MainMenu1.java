package ro.sci.menu.mainMenu;

import ro.sci.menu.PhoneMenu;
import ro.sci.phoneType.Phone;
import ro.sci.phoneType.nokia.Nokia;
import ro.sci.phoneType.nokia.nokiaTypes.NokiaC10;
import ro.sci.phoneType.nokia.nokiaTypes.NokiaG50;
import ro.sci.phoneType.samsung.Samsung;
import ro.sci.phoneType.samsung.samsungTypes.SamsungGalaxyA22;
import ro.sci.phoneType.samsung.samsungTypes.SamsungGalaxyS6;
import ro.sci.util.Util;
import ro.sci.util.UtilPhone;

import java.util.List;

public class MainMenu1 {

    public static void accessMainMenu1(){
        String phoneType;
        Phone currentPhone;

        phoneType = selectPhoneType();
        currentPhone = addPhone(phoneType);

        int nextChoice = Util.nextChoice("*******************************" +
                "\nWhat would you like to do next?" +
                "\n1. Access phone menu" +
                "\n2. Back to main menu", 1, 2);
        if (nextChoice == 1) {
            PhoneMenu.accessPhoneMenu(currentPhone);
        }
    }


    public static String selectPhoneType() {
        String phoneBrandChoice;
        String phoneTypeChoice = "";
        List<String> phoneBrands;
        List<String> phoneTypeList;

        phoneBrands = Phone.phoneBrandsList();
        phoneBrandChoice = Util.choose("Please select from available brands (case sensitive): ", phoneBrands);

        switch (phoneBrandChoice) {
            case "Samsung": {
                phoneTypeList = Samsung.phoneTypesSamsung();
                phoneTypeChoice = Util.choose("Please select from available types (case sensitive): ", phoneTypeList);
                break;
            }
            case "Nokia": {
                phoneTypeList = Nokia.phoneTypesNokia();
                phoneTypeChoice = Util.choose("Please select from available types (case sensitive): ", phoneTypeList);
                break;
            }
        }
        return phoneTypeChoice;
    }

    public static Phone addPhone(String phoneType) {
        Phone phone = null;
        switch (phoneType) {
            case "SamsungGalaxyA22": {
                phone = new SamsungGalaxyA22();
                break;
            }
            case "SamsungGalaxyS6": {
                phone = new SamsungGalaxyS6();
                break;
            }
            case "NokiaC10": {
                phone = new NokiaC10();
                break;
            }
            case "NokiaG50": {
                phone = new NokiaG50();
                break;
            }
        }

        phone = UtilPhone.findPhone(phone.getOwnNumber());
        return phone;
    }
}
