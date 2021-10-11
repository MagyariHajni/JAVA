package ro.sci.library;

import ro.sci.library.books.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Util {
    static Scanner scanner = new Scanner(System.in);

    public static int nextChoice(String text, int left, int right) {
        int nextChoice = 0;
        while (nextChoice < left || nextChoice > right) {
            System.out.println(text);
            Scanner scanner = new Scanner(System.in);
            nextChoice = scanner.nextInt();
        }
        return nextChoice;
    }

    public static Map<Integer, Book> convertSetToMap(TreeSet<Book> bookSet) {
        Map<Integer, Book> bookMap = new HashMap<>();
        int i = 0;
        for (Book e : bookSet) {
            bookMap.put(i, e);
            i++;
        }
        return bookMap;
    }

    public static void printMap(Map<Integer, Book> bookMap) {
        for (Integer index : bookMap.keySet()) {
            int key = index + 1;
            Book value = bookMap.get(index);
            System.out.print(key + ". " + value);
        }
    }

    public static int selectValidNumber(int size) {
        int selectedNumber = 0;
        if (size != 0) {
            do {
                System.out.println("*****************************" +
                        "\nPlease select a number from 1 to " + size + ": ");
                selectedNumber = scanner.nextInt();
                scanner.nextLine();
            } while ((selectedNumber > size) || (selectedNumber <= 0));
        }
        return selectedNumber;
    }

    public static int selectPositiveNumber() {
        int number;
        do {
            System.out.print("Number of books to add: ");
            number = scanner.nextInt();
            scanner.nextLine();
        } while (number <= 0);
        return number;
    }



}
