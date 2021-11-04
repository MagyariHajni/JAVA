package ro.sci;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private int id;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;

    public Person(int id, String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


    public static Person processValidResult(int lineNumber, String input) {
        String[] inputData = input.split(",");

        int separatorPos1 = inputData[2].indexOf('/');
        int separatorPos2 = inputData[2].lastIndexOf('/');
        int birthdateDay = Integer.parseInt(inputData[2].substring(0, separatorPos1));
        int birthdateMonth = Integer.parseInt(inputData[2].substring(separatorPos1 + 1, separatorPos2));
        int birthdateYear = Integer.parseInt(inputData[2].substring(separatorPos2 + 1));

        return new Person(lineNumber, inputData[0], inputData[1], LocalDate.of(birthdateYear, birthdateMonth, birthdateDay));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person people = (Person) o;
        return Objects.equals(getFirstName(), people.getFirstName()) && Objects.equals(getLastName(), people.getLastName()) && Objects.equals(getDateOfBirth(), people.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getDateOfBirth());
    }

    @Override
    public String toString() {
        return firstName +
                " " + lastName +
                " " + dateOfBirth.getMonthValue() +
                " " + dateOfBirth + "\n";
    }
}
