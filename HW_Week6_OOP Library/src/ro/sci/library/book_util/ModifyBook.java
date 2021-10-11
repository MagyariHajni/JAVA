package ro.sci.library.book_util;

import ro.sci.library.Util;
import ro.sci.library.books.Book;
import ro.sci.library.menu.MainMenu3;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ModifyBook {

    public static Map<Integer, Book> addExistingBook(Book book, int numberToAdd, String searchFor) {
        TreeSet<Book> bookSet;
        BookComparatorByAuthor bookComparatorByAuthor = new BookComparatorByAuthor();
        bookSet = new TreeSet<>(bookComparatorByAuthor);

        for (Book e : ListOfBooks.generateSearchForList(searchFor)) {
            if (e == book) {
                ListOfBooks.generateBookList().remove(e);
                e.setNumberOfBooks(e.getNumberOfBooks() + numberToAdd);
                e.setAvailable(true);
                ListOfBooks.addBook(e);
                Set<Book> currentBookList = ListOfBooks.generateSearchForList(searchFor);
                bookSet.addAll(currentBookList);
                break;
            }
        }
        return Util.convertSetToMap(bookSet);
    }

    public static Map<Integer, Book> removeNumberOfExistingBook(Book book, int numberToRemove, String searchFor) {
        TreeSet<Book> bookSet;
        BookComparatorByAuthor bookComparatorByAuthor = new BookComparatorByAuthor();
        bookSet = new TreeSet<>(bookComparatorByAuthor);

        for (Book e : ListOfBooks.generateSearchForList(searchFor)) {
            if (e == book) {
                ListOfBooks.generateBookList().remove(e);
                e.setNumberOfBooks(e.getNumberOfBooks() - numberToRemove);
                if (e.getNumberOfBooks() <= 0) {
                    e.setNumberOfBooks(0);
                    e.setAvailable(false);
                }
                ListOfBooks.addBook(e);
                Set<Book> currentBookList = ListOfBooks.generateSearchForList(searchFor);
                bookSet.addAll(currentBookList);
                break;
            }
        }
        return Util.convertSetToMap(bookSet);
    }

    public static Map<Integer, Book> permanentlyDeleteBook(Book book, String searchFor) {

        TreeSet<Book> bookSet;
        BookComparatorByAuthor bookComparatorByAuthor = new BookComparatorByAuthor();
        bookSet = new TreeSet<>(bookComparatorByAuthor);

        for (Book e : ListOfBooks.generateSearchForList(searchFor)) {
            if (e == book) {
                System.out.println("You have permanently removed: " + book.getAuthor() + ", " + book.getTitle());
                ListOfBooks.generateBookList().remove(e);
                break;
            }
        }
        Set<Book> currentBookList = ListOfBooks.generateSearchForList(searchFor);
        bookSet.addAll(currentBookList);
        return Util.convertSetToMap(bookSet);
    }

    public static Map<Integer, Book> addNumberOfBooksByIndex(Map<Integer, Book> inputBookMap, String searchFor, int index) {
        int numberOfBooks = Util.selectPositiveNumber();
        System.out.println("You have added " + numberOfBooks + " book(s) to: "
                + inputBookMap.get(index).getAuthor() + ", "
                + inputBookMap.get(index).getTitle());
        return ModifyBook.addExistingBook(inputBookMap.get(index), numberOfBooks, searchFor);
    }

    public static Map<Integer, Book> removeNumberOfBooksByIndex(Map<Integer, Book> inputBookMap, String searchFor, int index) {
        if (inputBookMap.isEmpty()) {
            System.out.println("The book list is currently empty, no books to remove :).");
        } else {
            if (!inputBookMap.get(index).isAvailable()) {
                System.out.println("There are no books available to remove for the selected book.");
            } else {
                System.out.println("For the selected book enter how many you want to remove");
                int numberOfBooks = Util.selectValidNumber(inputBookMap.get(index).getNumberOfBooks());
                inputBookMap = removeNumberOfExistingBook(inputBookMap.get(index), numberOfBooks, searchFor);
                System.out.println("You have removed " + numberOfBooks + " book(s) from: "
                        + inputBookMap.get(index).getAuthor() + ", "
                        + inputBookMap.get(index).getTitle());
            }
        }
        return ModifyBook.removeNumberOfExistingBook(inputBookMap.get(index), index, searchFor);
    }


    public static boolean modifyListedSet(String searchFor) {
        int nextChoice = 0;
        int selectedBookIndex;

        BookComparatorByAuthor bookComparatorByAuthor = new BookComparatorByAuthor();
        TreeSet<Book> bookSet;
        bookSet = new TreeSet<>(bookComparatorByAuthor);

        Set<Book> currentSet = ListOfBooks.generateSearchForList(searchFor);
        bookSet.addAll(currentSet);
        Map<Integer, Book> bookMap = Util.convertSetToMap(bookSet);

        while (nextChoice != 5) {

            nextChoice = Util.nextChoice("\nPlease select an option from:\n"
                    + "*****************************\n"
                    + "1. Add books to a book selected by index\n"
                    + "2. Remove books from a book selected by index\n"
                    + "3. Permanently delete a book selected by index \n"
                    + "4. List all books\n"
                    + "5. Exit to main\n"
                    + "What would you like to do?", 1, 5);

            if (bookMap.isEmpty()) {
                System.out.println("The book list is currently empty :).");
            } else {
                if (nextChoice != 5) {
                    if (nextChoice != 4) {
                        System.out.println("*********************************\n"
                                + "Select from list below by index:");
                        Util.printMap(bookMap);
                        selectedBookIndex = Util.selectValidNumber(bookMap.size()) - 1;

                        if (nextChoice == 1) {
                            bookMap = addNumberOfBooksByIndex(bookMap, searchFor, selectedBookIndex);
                        } else if (nextChoice == 2) {
                            bookMap = removeNumberOfBooksByIndex(bookMap, searchFor, selectedBookIndex);
                        } else {
                            bookMap = permanentlyDeleteBook(bookMap.get(selectedBookIndex), searchFor);
                        }
                    } else {
                        MainMenu3.accessMainMenu3("");
                        return true;
                    }
                }
            }
        }
        return true;
    }


}
