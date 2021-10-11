package ro.sci.library.menu;

import ro.sci.library.Util;
import ro.sci.library.book_util.BookComparatorByAuthor;
import ro.sci.library.book_util.ListOfBooks;
import ro.sci.library.book_util.ModifyBook;
import ro.sci.library.books.Book;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import static ro.sci.library.Util.printMap;
import static ro.sci.library.book_util.ModifyBook.permanentlyDeleteBook;

public class MainMenu2 {

    public static void accessMainMenu2() {
        Scanner scanner = new Scanner(System.in);
        int nextChoice;
        int selectedBookIndex;

        Map<Integer, Book> bookMap;
        BookComparatorByAuthor bookComparatorByAuthor = new BookComparatorByAuthor();
        TreeSet<Book> bookSet;
        bookSet = new TreeSet<>(bookComparatorByAuthor);

        while (true) {
            System.out.print("Enter search word: ");
            String searchFor = scanner.nextLine();

            Set<Book> currentBookList = ListOfBooks.generateSearchForList(searchFor);
            bookSet.clear();
            bookSet.addAll(currentBookList);

            if (bookSet.isEmpty()) {
                System.out.println("No books were found for: " + searchFor);

            } else {
                bookMap = Util.convertSetToMap(bookSet);
                System.out.println("*****************************\n" +
                        "The search list is: ");
                printMap(bookMap);
                nextChoice = Util.nextChoice("\nPlease select an option from:\n"
                        + "*****************************\n"
                        + "1. New search \n"
                        + "2. Add books to a book selected by index\n"
                        + "3. Remove books from a book selected by index\n"
                        + "4. Permanently delete a book selected by index \n"
                        + "5. Exit to main\n"
                        + "What would you like to do?", 1, 5);
                if (nextChoice != 5) {
                    if (nextChoice != 1) {
                        System.out.println("*********************************\n"
                                + "Select from list below by index:");
                        printMap(bookMap);
                        selectedBookIndex = Util.selectValidNumber(bookMap.size()) - 1;

                        if (nextChoice == 2) {
                            ModifyBook.addNumberOfBooksByIndex(bookMap, searchFor, selectedBookIndex);
                        } else if (nextChoice == 3) {
                            ModifyBook.removeNumberOfBooksByIndex(bookMap, searchFor, selectedBookIndex);
                        } else {
                            permanentlyDeleteBook(bookMap.get(selectedBookIndex), searchFor);
                        }
                    } else {
                        continue;
                    }
                } else {
                    break;
                }
            }

            nextChoice = Util.nextChoice("\nPlease select an option from:\n"
                    + "*****************************\n"
                    + "1. New search \n"
                    + "2. Exit to main\n"
                    + "What would you like to do?", 1, 2);
            if (nextChoice != 1) {
                break;
            }
        }
    }


}
