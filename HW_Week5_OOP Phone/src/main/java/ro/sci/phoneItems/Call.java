package ro.sci.phoneItems;

public class Call {
    private int place;
    private Contact callContact;

    public Contact getCallContact() {
        return callContact;
    }

    public Call(int place, Contact contact) {
        this.place = place;
        this.callContact = contact;
    }

    @Override
    public String toString() {
        return this.place
                + ". Number - " + this.callContact.getPhoneNumber()
                + " / Name - "+ this.callContact.getFirstName() + " " + this.callContact.getLastName();
    }
}
