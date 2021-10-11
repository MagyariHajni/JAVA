package ro.sci.library.menu;

import ro.sci.library.book_util.ListOfBooks;
import ro.sci.library.books.ArtAlbum;
import ro.sci.library.books.Novel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainMenu1 {

    public static void accessMainMenu1() {
        Scanner scanner = new Scanner(System.in);
        String bookKind;
        do {
            System.out.println("Please select type of book from: Novel, Art Album ");
            bookKind = scanner.nextLine();
        } while (!bookKind.equalsIgnoreCase("Novel") && (!bookKind.equalsIgnoreCase("Art Album")));

        System.out.print("Please enter the name of the author: ");
        String author = scanner.nextLine();
        System.out.print("Please enter the title: ");
        String title = scanner.nextLine();
        System.out.print("Please enter the number of pages of the book: ");
        int numberOfPages = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Please enter the number of books to add: ");
        int numberOfBooks = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Please enter type of book/paper quality (separate with comma for multiple types): ");
        String type = scanner.nextLine();
        List<String> typeList = new ArrayList<>(Arrays.asList(type.split(",")));


        if (bookKind.equalsIgnoreCase("Novel")) {
            ListOfBooks.addBook(new Novel(author, title, numberOfPages, numberOfBooks, typeList.toArray(new String[0])));
        } else {
            ListOfBooks.addBook(new ArtAlbum(author, title, numberOfPages, numberOfBooks, typeList.toArray(new String[0])));
        }
        System.out.println("You have added the book: " + author + ", " + title);
    }
}
