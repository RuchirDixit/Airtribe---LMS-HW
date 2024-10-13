package aitribe.book;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isBookAvailable = true;

    public Book(String title, String author, String ISBN){
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isBookAvailable() {
        return isBookAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", isBookAvailable=" + isBookAvailable +
                '}';
    }

    public void setBookAvailable(boolean bookAvailable) {
        isBookAvailable = bookAvailable;
    }
}
