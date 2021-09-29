package ro.sci.menu.mainMenu;

import ro.sci.menu.PhoneMenu;
import ro.sci.phoneType.Phone;
import ro.sci.util.Util;
import ro.sci.util.UtilPhone;

import java.util.Scanner;

public class MainMenu3 {

    public static void accessMainMenu3(){
        Scanner scanner = new Scanner(System.in);
        Phone currentPhone;
        while (true) {
            System.out.println("Please enter phone number: ");
            long phoneNumber = scanner.nextLong();
            currentPhone = UtilPhone.findPhone(phoneNumber);

            if (currentPhone == null) {
                int nextChoice = Util.nextChoice("\nThere is no phone found with this number.\n" +
                        "\n*******************************" +
                        "\n1. Enter another phone number" +
                        "\n2. Back to main menu" +
                        "\nWhat would you like to do next?", 1, 2);
                if (nextChoice == 2) {
                    break;
                }
            } else {
                PhoneMenu.accessPhoneMenu(currentPhone);
                break;
            }
        }
    }
}
