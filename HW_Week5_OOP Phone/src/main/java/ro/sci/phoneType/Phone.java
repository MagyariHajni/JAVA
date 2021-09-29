package ro.sci.phoneType;

import ro.sci.phoneItems.Call;
import ro.sci.phoneItems.Contact;
import ro.sci.phoneItems.Message;
import ro.sci.util.UtilPhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Phone {
    private int batteryLife;
    private String phoneColor;
    private String phoneMaterial;
    private long ownNumber;
    private String type;

    private List<Contact> contactList = new ArrayList<>();
    private List<Call> callList = new ArrayList<>();
    private List<Message> messageList = new ArrayList<>();

    public Phone(int batteryLife, String phoneColor, String phoneMaterial, long ownNumber, String type) {
        this.batteryLife = batteryLife;
        this.phoneColor = phoneColor;
        this.phoneMaterial = phoneMaterial;
        this.ownNumber = ownNumber;
        this.type = type;
    }

    public Phone() {
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public List<Call> getCallList() {
        return callList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public long getOwnNumber() {
        return this.ownNumber;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public void setType(String phoneType) {
        this.type = phoneType;
    }

    public void setPhoneInfo(long phoneNumber) {
        Scanner scanner = new Scanner(System.in);
        this.batteryLife = 10;

        System.out.println("Please choose a phone color: ");
        this.phoneColor = scanner.nextLine();

        System.out.println("Please choose a phone material: ");
        this.phoneMaterial = scanner.nextLine();

        this.ownNumber = phoneNumber;

        PhoneList.addPhone(this);
    }

    @Override
    public String toString() {
        return "Phone info: battery life - " + this.batteryLife + "h" +
                " / phone color - " + this.phoneColor +
                " / phone material - " + this.phoneMaterial +
                " / own number - " + this.ownNumber +
                " / phone type - " + this.type;
    }

    public static List<String> phoneBrandsList() {
        List<String> phoneBrands = new ArrayList();

        phoneBrands.add("Samsung");
        phoneBrands.add("Nokia");

        return phoneBrands;
    }

    public void addContact(int place, String firstName, String lastName, long phoneNumber) {
        if (!this.getCallList().isEmpty()) {
            for (Call e : this.getCallList()) {
                if (e.getCallContact().getPhoneNumber() == phoneNumber) {
                    e.getCallContact().setFirstName(firstName);
                    e.getCallContact().setLastName(lastName);
                }
            }
        }

        if (!this.getMessageList().isEmpty()) {
            for (Message e : this.getMessageList()) {
                if (e.getMessageContact().getPhoneNumber() == phoneNumber) {
                    e.getMessageContact().setFirstName(firstName);
                    e.getMessageContact().setLastName(lastName);
                }
            }
        }

        this.contactList.add(new Contact(place, firstName, lastName, phoneNumber));
        System.out.println("You have added " + firstName + " " + lastName + " to your contact list.");
    }

    public void listContacts() {
        if (this.getContactList().isEmpty()) {
            System.out.println("The contact list is currently empty.");
        } else {
            for (Contact e : this.getContactList()) {
                System.out.println(e);
            }
        }
    }

    public void call(long numberToCall) {
        if ((this.getBatteryLife() -2 ) < 0) {
            System.out.println("You need to recharge your phone!");
        } else {
            this.setBatteryLife(this.getBatteryLife() - 2);

            Contact contactToCall = UtilPhone.findContact(this, numberToCall);
            if (contactToCall == null) {
                contactToCall = new Contact(numberToCall);
            }
            int callListSize = this.getCallList().size();
            this.getCallList().add(new Call(callListSize + 1, contactToCall));
            System.out.println("You have called: " + contactToCall.getPhoneNumber()
                    + " / Name - " + contactToCall.getFirstName() + " " + contactToCall.getLastName());
        }

    }

    public void viewHistory() {
        if (this.getCallList().isEmpty()) {
            System.out.println("The call log is currently empty.");
        } else {
            for (Call e : this.getCallList()) {
                System.out.println(e);
            }
        }
    }

    public void sendMessage(long numberToMessage, String text) {
        this.setBatteryLife(getBatteryLife() - 1);
        Contact contactToMessage = UtilPhone.findContact(this, numberToMessage);

        if (contactToMessage == null) {
            contactToMessage = new Contact(numberToMessage);
        }
        int messageListSize = this.getMessageList().size();
        this.getMessageList().add(new Message(messageListSize+1,contactToMessage,text));

        System.out.println("The message was sent to: "+ contactToMessage.getPhoneNumber()
                + " / Name - " + contactToMessage.getFirstName() + " " + contactToMessage.getLastName());
    }

    public void listMessages() {
        if (this.getMessageList().isEmpty()) {
            System.out.println("The message list is currently empty.");
        } else {
            for (Message e : this.getMessageList()) {
                System.out.println(e);
            }
        }
    }

    public void listMessages(long number) {
        boolean foundNumber = false;

        for (Message e : this.getMessageList()) {
            if (e.getMessageContactNumber() == number) {
                System.out.println(e);
                foundNumber = true;
            }
        }
        if (!foundNumber) {
            System.out.println("No messages were found for this number.");
        }
    }

    public void rechargePhone() {
        this.batteryLife = 10;
    }

}
