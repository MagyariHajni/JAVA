package ro.sci.menu;

import ro.sci.menu.phoneMenu.PhoneMenu1;
import ro.sci.menu.phoneMenu.PhoneMenu5;
import ro.sci.menu.phoneMenu.PhoneMenu6;
import ro.sci.phoneType.Phone;
import ro.sci.util.Util;

import java.util.Scanner;

public class PhoneMenu {
    public static void accessPhoneMenu(Phone phone) {
        Scanner scanner = new Scanner(System.in);
        int phoneMenuChoice;
        int nextChoice;
        boolean continueIteration = true;

        while (continueIteration) {
            phoneMenuChoice = Util.nextChoice("\nPlease select an option from:\n"
                    + "*****************************\n"
                    + "Phone menu\n"
                    + "1. Add contact \n"
                    + "2. View contact list \n"
                    + "3. Make a call \n"
                    + "4. View call log \n"
                    + "5. Send a message \n"
                    + "6. View messages \n"
                    + "7. Check phone battery\n"
                    + "8. Charge phone battery\n"
                    + "9. Back to main menu\n"
                    + "What would you like to do?", 1, 9);

            switch (phoneMenuChoice) {
                case 1: {
                    PhoneMenu1.accessPhoneMenu1(phone);
                    break;
                }
                case 2: {
                    phone.listContacts();
                    break;
                }
                case 3: {
                    System.out.print("Enter the number you want to call: ");
                    long numberToCall = scanner.nextLong();

                    phone.call(numberToCall);
                    break;
                }
                case 4: {
                    phone.viewHistory();
                    break;
                }
                case 5: {
                    PhoneMenu5.accessPhoneMenu5(phone);
                    break;
                }
                case 6: {
                    PhoneMenu6.accessPhoneMenu6(phone);
                    break;
                }
                case 7: {
                    System.out.println("The battery has " + phone.getBatteryLife() + "h left.");
                    break;
                }
                case 8: {
                    phone.rechargePhone();
                    break;
                }
                case 9: {
                    continueIteration = false;
                    break;
                }
            }
        }
    }
}


