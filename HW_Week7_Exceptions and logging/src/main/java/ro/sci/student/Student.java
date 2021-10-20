package ro.sci.student;

import ro.sci.Util;
import ro.sci.exceptions.InvalidInputException;
import ro.sci.exceptions.InvalidNumberException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Student {
    private static List<Student> studentList = new ArrayList<>();

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private char gender;
    private long id;

    public Student() throws InvalidInputException, InvalidNumberException {
        this("", "", "", '\u0000', 0);
    }

    public Student(String firstName, String lastName, String dateOfBirth, char gender, long id) throws InvalidInputException, InvalidNumberException {
        Util.checkEmptyData(firstName, lastName, dateOfBirth);
        Util.checkGender(gender);

        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = Util.convertStringToDate(dateOfBirth);
        this.gender = gender;

        Util.checkID(id, dateOfBirth, gender);
        this.id = id;

    }

    public static List<Student> getStudentList() {
        return studentList;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public static void addStudent(Student student) throws InvalidInputException {
        for (Student s : studentList) {
            if (s.id == student.id) {
                throw new InvalidInputException("The ID " + student.id + " already exists in the database");
            }
        }
        studentList.add(student);
    }

    public static void deleteStudent(long id) throws InvalidInputException {
        Util.validateIdFormat(id);

        boolean found = false;
        if (studentList.isEmpty()) {
            System.out.println("The student list is currently empty");
            return;
        }
        for (Student s : studentList) {
            if (s.id == id) {
                studentList.remove(s);
                System.out.println("You have deleted student: " + s.getFirstName() + " " + s.getLastName());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student is not in the database");
        }
    }

    public static List<Student> searchByAge(int age) throws InvalidInputException {
        if (age < 0) {
            throw new InvalidInputException("Invalid age " + age + " input");
        }

        List<Student> searchListByAge = new ArrayList<>();
        if (studentList.isEmpty()) {
            System.out.println("The student list is currently empty");
        } else {
            LocalDate today = LocalDate.now();

            for (Student s : studentList) {
                LocalDate dateToCheck = LocalDate.of(s.getDateOfBirth().getYear() + 1900, s.getDateOfBirth().getMonth() + 1, s.getDateOfBirth().getDate());
                Period p = Period.between(dateToCheck, today);

                if (p.getYears() >= age) {
                    searchListByAge.add(s);
                }
            }
            searchListByAge.sort(new StudentComparatorByDateOfBirth());
            if (searchListByAge.isEmpty()) {
                System.out.println("No students were found with the age: " + age);
            }
        }
        return searchListByAge;
    }

    public static List<Student> sortByCriteria(String criteria) throws InvalidInputException {
        if (Objects.equals(criteria, "")) {
            throw new InvalidInputException("Sorting criteria is required");
        }

        if ((criteria.equalsIgnoreCase("date of birth")) || (criteria.equalsIgnoreCase("name"))) {
            if (studentList.isEmpty()) {
                System.out.println("The student list is currently empty");
                return null;
            } else {
                List<Student> sortedlist = new ArrayList<>(studentList);

                if (criteria.equalsIgnoreCase("date of birth")) {
                    sortedlist.sort(new StudentComparatorByDateOfBirth());
                } else {
                    sortedlist.sort(new StudentComparatorByName());
                }
                return sortedlist;
            }
        } else {
            throw new InvalidInputException("List can be sorted only by name or date of birth");
        }
    }

    @Override
    public String toString() {
        return "Student: " +
                lastName +
                " " + firstName +
                ", Date of birth " + new SimpleDateFormat("dd/MM/yyyy").format(dateOfBirth) +
                ", gender " + gender +
                ", id " + id;
    }


}
