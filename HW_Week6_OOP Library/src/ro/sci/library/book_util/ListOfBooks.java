package ro.sci.library.book_util;

import ro.sci.library.books.ArtAlbum;
import ro.sci.library.books.Book;
import ro.sci.library.books.Novel;

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
                if ((b.getAuthor().toLowerCase().contains(searchFor.toLowerCase()))
                        || (b.getTitle().toLowerCase().contains(searchFor.toLowerCase()))
                        || (searchByType(b,searchFor))) {
                    searchForList.add(b);
                }
            }
        }
        return searchForList;
    }


    public static boolean searchByType(Book b, String searchFor){
        if (b instanceof Novel) {
           return String.join(" ",((Novel) b).getType()).toLowerCase().contains(searchFor.toLowerCase());
        } else {
            return String.join(" ",((ArtAlbum) b).getPaperQuality()).toLowerCase().contains(searchFor.toLowerCase());
        }
    }

}
