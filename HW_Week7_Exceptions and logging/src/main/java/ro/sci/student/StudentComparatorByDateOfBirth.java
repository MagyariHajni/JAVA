package ro.sci.student;

import ro.sci.student.Student;

import java.util.Comparator;

public class StudentComparatorByDateOfBirth implements Comparator <Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return -o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
