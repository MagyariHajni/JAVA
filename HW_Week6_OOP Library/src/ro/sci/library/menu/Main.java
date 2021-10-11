package ro.sci.library.menu;

import ro.sci.library.Util;
import ro.sci.library.book_util.ListOfBooks;
import ro.sci.library.books.ArtAlbum;
import ro.sci.library.books.Novel;

public class Main {
    public static void main(String[] args) {
        int mainChoice;

        ListOfBooks.addBook(new Novel("Oscar Wilde", "The picture of Dorian Gray", 288, 2, "fiction", "classic"));
        ListOfBooks.addBook(new Novel("Neil Gaiman", "American Gods", 662, 1, "fantasy"));
        ListOfBooks.addBook(new Novel("J.R.R. Tolkien", "The Lord of the Rings", 1216, 1, "fantasy", "classic"));
        ListOfBooks.addBook(new Novel("Isaac Asimov", "I, Robot", 256, 3, "science-fiction", "classic", "short stories"));
        ListOfBooks.addBook(new Novel("Oscar Wilde", "The picture of Dorian Gray", 288, 1, "fiction", "realism"));
        ListOfBooks.addBook(new Novel("Isaac Asimov", "Foundation", 320, 1, "science-fiction", "classic"));
        ListOfBooks.addBook(new Novel("Agatha Christie", "Death on the Nile", 384, 1, "mystery", "fiction", "detective"));

        ListOfBooks.addBook(new ArtAlbum("Dominic Bradbury", "Atlas of interior design", 432, 1, "white opaque"));
        ListOfBooks.addBook(new ArtAlbum("Dominic Bradbury", "Atlas of interior design", 432, 1, "matte coated"));
        ListOfBooks.addBook(new ArtAlbum("Ferran Adria", "Unelaborated products", 520, 1, "matte coated"));
        ListOfBooks.addBook(new ArtAlbum("Derin Bresnitz & Greg Bresnitz", "Snacky tunes", 320, 2, "laminated"));


        while (true) {
            mainChoice = Util.nextChoice("\nPlease select an option from:\n"
                    + "*****************************\n"
                    + "Main menu\n"
                    + "1. Add book \n"
                    + "2. Search and modify list \n"
                    + "3. List and modify \n"
                    + "4. Exit \n"
                    + "What would you like to do?", 1, 4);

            if (mainChoice == 1) {
                MainMenu1.accessMainMenu1();
            } else if (mainChoice == 2) {
                MainMenu2.accessMainMenu2();
            } else if (mainChoice == 3) {
                MainMenu3.accessMainMenu3("");
            } else {
                break;
            }
        }
    }
}
