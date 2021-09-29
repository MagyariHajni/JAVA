package ro.sci.phoneItems;

public class Message {
    private int place;
    private Contact messageContact;
    private String messageText;

    public Message(int place, Contact messageContact, String messageText) {
        this.place = place;
        this.messageContact = messageContact;
        this.messageText = messageText;
    }

    public Contact getMessageContact() {
        return messageContact;
    }

    public long getMessageContactNumber() {

        return messageContact.getPhoneNumber();
    }

    @Override
    public String toString() {
        return "Name - " + this.messageContact.getLastName() + " " + this.messageContact.getFirstName()+
                " / Number - " + this.messageContact.getPhoneNumber()
                + " / Message: " + this.messageText;
    }
}
