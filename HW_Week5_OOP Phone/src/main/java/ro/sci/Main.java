package ro.sci;

import ro.sci.menu.mainMenu.MainMenu1;
import ro.sci.menu.mainMenu.MainMenu3;
import ro.sci.util.Util;

public class Main {

    public static void main(String[] args) {

        int mainChoice;

//        Phone phone = new Phone (5,"black","al",1234,"NokiaC10 / imei - "+Util.getGeneratedLong());
//        PhoneList.addPhone(phone);

        while (true) {
            mainChoice = Util.nextChoice("\nPlease select an option from:\n"
                    + "****************************\n"
                    + "Main menu\n"
                    + "1. Add phone \n"
                    + "2. List phones \n"
                    + "3. Access phone menu \n"
                    + "4. Exit \n"
                    + "What would you like to do?", 1, 4);

            if (mainChoice == 1) {
                MainMenu1.accessMainMenu1();
            } else if (mainChoice == 2) {
                Util.listCurrentList();
            } else if (mainChoice == 3) {
                MainMenu3.accessMainMenu3();
            } else {
                break;
            }
        }
    }

}
