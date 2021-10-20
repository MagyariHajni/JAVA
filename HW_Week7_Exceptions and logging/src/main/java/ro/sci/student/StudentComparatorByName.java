package ro.sci.student;

import ro.sci.student.Student;

import java.util.Comparator;

public class StudentComparatorByName implements Comparator <Student>{

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getLastName().compareToIgnoreCase(o2.getLastName()) == 0){
            return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
        }else {
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
        }
    }
}
