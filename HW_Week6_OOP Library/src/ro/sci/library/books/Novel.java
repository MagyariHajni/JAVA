package ro.sci.library.books;

import ro.sci.library.book_util.ListOfBooks;

import java.util.*;

public class Novel extends Book {
    private List<String> type = new ArrayList<>();

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public Novel(String author, String title, int numberOfPages, int numberOfBooks, String... type) {
        defineAttributesNovel(this,author,title,numberOfPages,numberOfBooks,type);
    }

    @Override
    public String toString() {
        return "Novel:" +
                "\tAuthor='" + this.getAuthor() + '\'' +
                "\tTitle='" + this.getTitle() + '\'' +
                "\tNumber of pages='" + this.getNumberOfPages() + '\'' +
                "\tBooks available='" + this.getNumberOfBooks() + '\'' +
                "\tType='" + type + "'\n";
    }

    public static void defineAttributesNovel(Book book, String author, String title, int numberOfPages, int numberOfBooks, String... type) {
        book.setAuthor(author.toLowerCase());
        book.setTitle(title.toLowerCase());
        book.setNumberOfPages(numberOfPages);
//        book.setNumberOfBooks(numberOfBooks);
        book.setAvailable(true);
//        ((Novel) book).setType(Arrays.asList(type));

        if (ListOfBooks.generateBookList().contains(book)) {
            for (Book e : ListOfBooks.generateBookList()) {
                if (e.getAuthor().equalsIgnoreCase(author) && (e.getTitle().equalsIgnoreCase(title))) {

                    ListOfBooks.generateBookList().remove(book);
                    book.setNumberOfBooks(numberOfBooks + e.getNumberOfBooks());

                    List<String> elementType = Arrays.asList(type);
                    Set<String> mergedType = new HashSet<>(((Novel) e).getType());
                    mergedType.addAll(elementType);

                    ((Novel) book).setType(new ArrayList<>(mergedType));

                    ListOfBooks.addBook(book);
                    break;
                }
            }
        } else {
            ((Novel) book).setType(Arrays.asList(type));
            book.setNumberOfBooks(numberOfBooks);
            ListOfBooks.addBook(book);
        }
    }









}
