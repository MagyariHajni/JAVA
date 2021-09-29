package ro.sci.menu.phoneMenu;

import ro.sci.phoneItems.Message;
import ro.sci.phoneType.Phone;
import ro.sci.util.Util;

import java.util.Scanner;

public class PhoneMenu6 {
    public static void accessPhoneMenu6(Phone phone) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int nextChoice = Util.nextChoice("\n*****************************\n"
                    + "1. See all messages \n"
                    + "2. Search for messages to a number \n"
                    + "3. Back to phone menu \n"
                    + "What would you like to do?", 1, 3);
            if (nextChoice == 1) {
                phone.listMessages();
            } else if (nextChoice == 2) {
                System.out.print("Search for messages from phone number: ");
                long messageSearchNumber = scanner.nextLong();
                phone.listMessages(messageSearchNumber);
            } else {
                break;
            }

        }

    }
}
