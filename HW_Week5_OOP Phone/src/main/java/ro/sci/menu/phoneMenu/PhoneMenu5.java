package ro.sci.menu.phoneMenu;

import ro.sci.phoneType.Phone;
import ro.sci.util.Util;
import ro.sci.util.UtilPhone;

import java.util.Scanner;

public class PhoneMenu5 {

    public static void accessPhoneMenu5(Phone phone) {
        Scanner scanner = new Scanner(System.in);
        int nextChoice;
        System.out.print("Enter the number you want to send a message to: ");
        long numberToMessage = scanner.nextLong();
        scanner.nextLine();

        while (true) {

            System.out.print("Enter text message: ");
            String messageText = scanner.nextLine();

            System.out.println(messageText);

            if (messageText.length() > (500 * 10)) {
                System.out.println("\nMessage is too long (you might consider writing an email).");
                nextChoice = Util.nextChoice("\n*****************************\n"
                        + "1. Rewrite message \n"
                        + "2. Back to phone menu \n"
                        + "What would you like to do?", 1, 2);
                if (nextChoice == 2) {
                    break;
                }
            } else {
                int numberOfMessages;

                if (messageText.length() % 500 == 0) {
                    numberOfMessages = messageText.length() / 500;
                } else {
                    numberOfMessages = messageText.length() / 500 + 1;
                }

                if (numberOfMessages > phone.getBatteryLife()) {
                    System.out.println("\nYou don't have enough battery to send this message.");
                    nextChoice = Util.nextChoice("\n*****************************\n"
                            + "1. Rewrite message \n"
                            + "2. Recharge and send \n"
                            + "3. Back to phone menu \n"
                            + "What would you like to do?", 1, 3);

                    if (nextChoice == 2) {
                        phone.rechargePhone();
                        UtilPhone.divideMessage(phone, numberToMessage, messageText);
                        break;
                    } else if (nextChoice == 3) {
                        break;
                    }
                } else {
                    UtilPhone.divideMessage(phone, numberToMessage, messageText);
                    break;
                }
            }
        }
    }


}
