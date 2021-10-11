package ro.sci.library.books;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int numberOfPages;
    private int numberOfBooks;
    private boolean available;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getTitle().toLowerCase(), book.getTitle().toLowerCase())
                && Objects.equals(getAuthor().toLowerCase(), book.getAuthor().toLowerCase())
                && Objects.equals(getClass(),book.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor());
    }


}
