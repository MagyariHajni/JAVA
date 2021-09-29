package ro.sci.util;

import ro.sci.phoneItems.Contact;
import ro.sci.phoneType.Phone;
import ro.sci.phoneType.PhoneList;

import java.util.List;
import java.util.Scanner;

public class UtilPhone {

    public static Phone findPhone(long phoneNumber) {
        Phone phone = null;
        List<Phone> currentPhoneList = PhoneList.generatePhoneList();

        for (Phone e : currentPhoneList) {
            if (e.getOwnNumber() == phoneNumber) {
                phone = e;
            }
        }
        return phone;
    }

    public static Contact findContact(Phone phone, long number) {
        List<Contact> contactList = phone.getContactList();
        for (Contact e : contactList) {
            if (e.getPhoneNumber() == number) {
                return e;
            }
        }
        return null;
    }

    public static int checkNumber(Phone phone, long number) {
        int nextChoice = 0;
        for (Contact e : phone.getContactList()) {
            if (e.getPhoneNumber() == number) {
                nextChoice = Util.nextChoice("\nYou already have this number in your contact list, choose an option:" +
                        "\n1. Update contact name" +
                        "\n2. Change phone number" +
                        "\n3. New contact" +
                        "\nWhat would you like to do?", 1, 3);
                break;
            }
        }
        return nextChoice;
    }

    public static Long addNumber() {
        Scanner scanner = new Scanner(System.in);
        List<Phone> currentPhoneList = PhoneList.generatePhoneList();
        long numberToCheck;

        while (true) {
            System.out.println("Please enter phone number: ");
            numberToCheck = scanner.nextLong();
            boolean foundNumber = false;

            for (Phone e : currentPhoneList) {
                if (e.getOwnNumber() == numberToCheck) {
                    foundNumber = true;
                    break;
                }
            }

            if (foundNumber) {
                System.out.println("This phone number is already in use, select another");
            } else {
                break;
            }

        }
        return numberToCheck;
    }

    public static void divideMessage(Phone phone, long numberToMessage, String text) {
        String textPartOne;
        String textRest = text;

        while (textRest.length()>500){
            textPartOne = textRest.substring(0, 500);
            textRest = textRest.substring(500);
            phone.sendMessage(numberToMessage, textPartOne);
        }

        phone.sendMessage(numberToMessage, textRest);
    }

}



