package ro.sci.phoneItems;

public class Contact {
    private int place;
    private String firstName;
    private String lastName;
    private long phoneNumber;

    public Contact(long phoneNumber) {
        this.place = 0;
        this.firstName = "";
        this.lastName = "";
        this.phoneNumber = phoneNumber;
    }

    public Contact(int place, String firstName, String lastName, long phoneNumber) {
        this.place = place;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public void updateContact(String firstName, String lastName, long number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.place +
                ". Name - " + this.firstName + " " + lastName +
                " / Number - " + this.phoneNumber ;
    }
}
