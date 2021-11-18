package ro.sci;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.function.Predicate;

import static ro.sci.Results.*;

public class Main {

    public static void main(String[] args) {

        Path fileIn = new File("resources/people_data.csv").toPath();
        Path fileOutValid = new File("resources/people_results.csv").toPath();

        Scanner scanner = new Scanner(System.in);
        int monthToCheck;

        do {
            System.out.print("Please enter a valid month (number between 1 and 12): ");
            try {
                monthToCheck = Integer.parseInt(scanner.next());
                System.out.println();
            } catch (NumberFormatException e) {
                monthToCheck = 0;
            }
        } while (monthToCheck < 1 || monthToCheck > 12);

        listPeopleWithBirthdayInGivenMonth(fileIn, monthToCheck, fileOutValid);

    }

}

