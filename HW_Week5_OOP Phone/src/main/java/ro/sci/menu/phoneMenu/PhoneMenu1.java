package ro.sci.menu.phoneMenu;

import ro.sci.phoneItems.Contact;
import ro.sci.phoneType.Phone;
import ro.sci.util.UtilPhone;

import java.util.Scanner;

public class PhoneMenu1 {

    public static void accessPhoneMenu1(Phone phone) {
        Scanner scanner = new Scanner(System.in);
        String firstName ;
        String lastName ;
        long phoneNumber ;
        int nextChoice ;
        Contact contact;

        while (true) {
            System.out.println("Please enter contact details:");
            System.out.print("-First name: ");
            firstName = scanner.next();
            System.out.print("-Last name: ");
            lastName = scanner.next();
            System.out.print("-Phone number: ");
            phoneNumber = scanner.nextLong();

            int listSize = phone.getContactList().size();

            nextChoice = UtilPhone.checkNumber(phone, phoneNumber);

            if (nextChoice == 1) {
                contact = UtilPhone.findContact(phone, phoneNumber);

                contact.updateContact(firstName,lastName,phoneNumber);
                break;
            } else if (nextChoice == 2) {
                boolean foundNumber = true;
                while (foundNumber) {
                    foundNumber = false;
                    System.out.print("\n-New phone number: ");
                    phoneNumber = scanner.nextLong();
                    for (Contact e : phone.getContactList()) {
                        if (e.getPhoneNumber() == phoneNumber) {
                            foundNumber = true;
                            System.out.println("This number already exists in contact list, please add new number.");
                            break;
                        }
                    }
                }

                phone.addContact(listSize + 1, firstName, lastName, phoneNumber);
                break;
            } else if (nextChoice != 3) {
                phone.addContact(listSize + 1, firstName, lastName, phoneNumber);
                break;
            }
        }
    }
}
