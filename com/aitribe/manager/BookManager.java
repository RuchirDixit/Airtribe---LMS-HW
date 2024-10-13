package aitribe.manager;

import aitribe.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BookManager {
    private List<Book> availableBooksInLibrary;
    private List<Book> borrowedBooksFromLibrary;

    public BookManager(){
        this.availableBooksInLibrary = new ArrayList<>();
        this.borrowedBooksFromLibrary = new ArrayList<>();
    }

    public void addNewBook(Book book){
        Logger.getAnonymousLogger().info("Added new book : " + book);
        this.availableBooksInLibrary.add(book);
    }

    public List<Book> getListOfAllAvailableBooks(){
        return this.availableBooksInLibrary;
    }

    public List<Book> getListOfAllBorrowedBooks(){
        return this.borrowedBooksFromLibrary;
    }


    public boolean isBookAvailableToBorrow(Book book){
        return book.isBookAvailable();
    }

    public void borrowBook(Book book){
        Logger.getAnonymousLogger().info("Book borrowed : " + book);
        this.availableBooksInLibrary.remove(book);
        this.borrowedBooksFromLibrary.add(book);
    }

    public void returnBook(Book book){
        Logger.getAnonymousLogger().info("Book Returned : " + book);
        this.borrowedBooksFromLibrary.remove(book);
        this.availableBooksInLibrary.add(book);
    }

    public void removeBookFromInventory(Book book){
        Logger.getAnonymousLogger().info("Book removed from inventory : " + book);
        this.availableBooksInLibrary.remove(book);
    }

    public Book searchBookByTitle(String title){
        for(Book book : availableBooksInLibrary){
            if(book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }
        return null;
    }

    public Book searchBookByISBN(String isbn){
        for(Book book : availableBooksInLibrary){
            if(book.getISBN().equalsIgnoreCase(isbn)){
                return book;
            }
        }
        return null;
    }

    public List<Book> searchBooksByAuthor(String author){
        List<Book> booksWithAuthor = new ArrayList<>();
        for(Book book : availableBooksInLibrary){
            if(book.getAuthor().equalsIgnoreCase(author)){
                booksWithAuthor.add(book);
            }
        }
        return booksWithAuthor;
    }
}
