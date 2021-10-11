package ro.sci.library.book_util;

import ro.sci.library.books.Book;

import java.util.HashSet;
import java.util.Set;

public class ListOfBooks {
    private static Set<Book> listOfBooks = new HashSet<>();

    public static void addBook(Book book) {
        listOfBooks.add(book);
    }

    public static Set<Book> generateBookList() {
        return listOfBooks;
    }


    public static Set<Book> generateSearchForList(String searchFor) {
        Set<Book> searchForList = new HashSet<>();
        if (searchFor.equals("")){
            searchForList = generateBookList();
        }else {
            for (Book b : generateBookList()) {
                if ((b.getAuthor().toLowerCase().contains(searchFor.toLowerCase())) || (b.getTitle().toLowerCase().contains(searchFor.toLowerCase()))) {
                    searchForList.add(b);
                }
            }
        }
        return searchForList;
    }

}
