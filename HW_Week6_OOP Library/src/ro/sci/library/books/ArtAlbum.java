package ro.sci.library.books;

import ro.sci.library.book_util.ListOfBooks;

import java.util.*;


public class ArtAlbum extends Book{
    private List<String> paperQuality = new ArrayList<>();


    public List<String> getPaperQuality() {
        return paperQuality;
    }

    public void setPaperQuality(List<String> paperQuality) {
        this.paperQuality = paperQuality;
    }

    public ArtAlbum(String author, String title, int numberOfPages, int numberOfBooks, String... type) {
        defineAttributesArtAlbum(this,author,title,numberOfPages,numberOfBooks,type);
    }

    @Override
    public String toString() {
        return "ArtAlbum: " +
                "\tAuthor='" + this.getAuthor() + '\'' +
                "\tTitle='" + this.getTitle() + '\'' +
                "\tNumber of pages='" + this.getNumberOfPages() + '\'' +
                "\tBooks available='" + this.getNumberOfBooks() + '\'' +
                "\tPaper quality='" + paperQuality + "'\n";
    }

    public static void defineAttributesArtAlbum(Book book, String author, String title, int numberOfPages, int numberOfBooks, String... paperQuality) {
        book.setAuthor(author);
        book.setTitle(title);
        book.setNumberOfPages(numberOfPages);
//        book.setNumberOfBooks(numberOfBooks);
        book.setAvailable(true);
//        ((ArtAlbum) book).setPaperQuality(Arrays.asList(paperQuality));

        if ((ListOfBooks.generateBookList().contains(book))) {
            for (Book e : ListOfBooks.generateBookList()) {
                if (e.getAuthor().equalsIgnoreCase(author) && (e.getTitle().equalsIgnoreCase(title))) {

                    ListOfBooks.generateBookList().remove(book);
                    book.setNumberOfBooks(numberOfBooks + e.getNumberOfBooks());

                    List<String> elementType = Arrays.asList(paperQuality);
                    Set<String> mergedType = new HashSet<>(((ArtAlbum) e).getPaperQuality());
                    mergedType.addAll(elementType);

                    ((ArtAlbum) book).setPaperQuality(new ArrayList<>(mergedType));

                    ListOfBooks.addBook(book);
                    break;
                }
            }
        } else {
            book.setNumberOfBooks(numberOfBooks);
            ((ArtAlbum) book).setPaperQuality(Arrays.asList(paperQuality));
            ListOfBooks.addBook(book);
        }
    }




}
