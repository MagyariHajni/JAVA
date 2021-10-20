package ro.sci;

import ro.sci.exceptions.InvalidInputException;
import ro.sci.exceptions.InvalidNumberException;
import ro.sci.student.Student;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static ro.sci.student.Student.*;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());


    static {

        try (InputStream is = Main.class.getClassLoader().
                getResourceAsStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            logger.log(Level.INFO, "Adding new students");
//            Student studenty = new Student("Rudi", "Wardle", "aaa", 'm', 1710210154483L);
//        Student studentx = new Student();

            Student student1 = new Student("Rudi", "Wardle", "10/02/1971", 'M', 1710210154483L);
            Student student2 = new Student("Chanelle", "Mackenzie", "30/03/1926", 'F', 2260330127793L);
            Student student3 = new Student("Grover", "Shaffer", "05/12/1910", 'M', 1101205115852L);
            Student student4 = new Student("Zaydan", "House", "08/11/2000", 'M', 5001108138098L);
            Student student5 = new Student("Calista", "Church", "10/01/1963", 'F', 2630110144270L);
            Student student6 = new Student("Manisha", "Glass", "02/11/1971", 'F', 2711102118517L);
            Student student7 = new Student("Seamus", "Lawson", "04/08/1992", 'M', 1920804118256L);
            Student student8 = new Student("Maisha", "Holcomb", "12/02/2002", 'F', 6020212155590L);
            Student student9 = new Student("Jack", "Nava", "30/10/1989", 'M', 1891030124560L);
            Student student10 = new Student("Roscoe", "Hodges", "09/01/2001", 'M', 5010109137228L);

            LocalDate today = LocalDate.now();

            logger.log(Level.INFO, "Adding students to list");

            System.out.println("***** Add student and list students *****************************************************");
            List<Student> studentsToPutIn = Arrays.asList(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10);
            for (Student s : studentsToPutIn) {
                addStudent(s);
            }

            logger.log(Level.INFO, "Listing current student list");
            if (!getStudentList().isEmpty()) {
                for (Student s : getStudentList()) {
                    System.out.println(s);
                }
            } else {
                System.out.println("The student list is currently empty");
            }

            logger.log(Level.INFO, "Deleting student based on ID");
            System.out.println();
            System.out.println("***** Delete student ********************************************************************");
//            deleteStudent(1021312155590L);
            deleteStudent(6020212155590L);
            deleteStudent(1891030124560L);


            logger.log(Level.INFO, "Searching student list based on age");
            System.out.println();
            System.out.println("***** Search by given age ***************************************************************");
            List<Student> listGreaterThanGivenAge = searchByAge(41);

//            listGreaterThanGivenAge = searchByAge(-1);
            if (!listGreaterThanGivenAge.isEmpty()) {
                for (Student s : listGreaterThanGivenAge) {
                    LocalDate dateToCheck = LocalDate.of(s.getDateOfBirth().getYear() + 1900, s.getDateOfBirth().getMonth() + 1, s.getDateOfBirth().getDate());
                    System.out.print(s);
                    System.out.println(" - " + Period.between(dateToCheck, today).getYears());
                }
            }

            logger.log(Level.INFO, "Sorting student list by last name");
            System.out.println();
            System.out.println("***** Sort student list by name *********************************************************");
            List<Student> listSortedByname = sortByCriteria("name");
//            listSortedByname=sortByCriteria("sthing");

            if (listSortedByname != null) {
                for (Student s : listSortedByname) {
                    System.out.println(s);
                }
            }

            logger.log(Level.INFO, "Sorting student list by last age");
            System.out.println();
            System.out.println("***** Sort student list by date of birth ************************************************");
            List<Student> listSortedByAge = sortByCriteria("date of birth");

            if (listSortedByAge != null) {

                for (Student s : listSortedByAge) {
                    LocalDate dateToCheck = LocalDate.of(s.getDateOfBirth().getYear() + 1900, s.getDateOfBirth().getMonth() + 1, s.getDateOfBirth().getDate());
                    System.out.print(s);
                    System.out.println(" - " + Period.between(dateToCheck, today).getYears());
                }
            }
        } catch (InvalidInputException | InvalidNumberException e) {
            logger.log(Level.WARNING, "Invalid entry: " + e.getMessage());
//            e.printStackTrace();
        }


    }
}
