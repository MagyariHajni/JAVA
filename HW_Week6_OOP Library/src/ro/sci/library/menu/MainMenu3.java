package ro.sci.library.menu;

import ro.sci.library.Util;
import ro.sci.library.book_util.*;
import ro.sci.library.books.Book;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MainMenu3 {

    public static void accessMainMenu3(String searchFor) {
        int nextChoice;
        BookComparatorByAuthor bookComparatorByAuthor = new BookComparatorByAuthor();
        BookComparatorByTitle bookComparatorByTitle = new BookComparatorByTitle();
        BookComparatorByCategory bookComparatorByCategory = new BookComparatorByCategory();
        TreeSet<Book> bookSet;

        boolean backToMain = false;

        while (!backToMain) {
            Set<Book> bookList = ListOfBooks.generateSearchForList(searchFor);
            if (bookList.isEmpty()) {
                System.out.println("The book list is currently empty :).");
                break;
            } else {
                nextChoice = Util.nextChoice("\nPlease select an option from:\n"
                        + "*****************************\n"
                        + "1. List by author \n"
                        + "2. List by title \n"
                        + "3. List by category \n"
                        + "4. Exit to main\n"
                        + "What would you like to do?", 1, 4);
                if (nextChoice == 1) {
                    bookSet = new TreeSet<>(bookComparatorByAuthor);
                    bookSet.addAll(bookList);
                } else if (nextChoice == 2) {
                    bookSet = new TreeSet<>(bookComparatorByTitle);
                    bookSet.addAll(bookList);
                } else if (nextChoice == 3) {
                    bookSet = new TreeSet<>(bookComparatorByCategory);
                    bookSet.addAll(bookList);
                } else {
                    break;
                }
                Map<Integer, Book> bookMap = Util.convertSetToMap(bookSet);
                Util.printMap(bookMap);

                backToMain = ModifyBook.modifyListedSet(searchFor);
            }
        }

    }


}
