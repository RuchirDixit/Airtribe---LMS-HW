package aitribe.librarian;

import aitribe.book.Book;
import aitribe.manager.BookManager;
import aitribe.manager.PatronManager;
import aitribe.patron.Patron;

import java.util.List;
import java.util.UUID;

public class Librarian {

    private String libarianId;
    private BookManager bookManager;
    private PatronManager patronManager;

    public Librarian(){
        libarianId = UUID.randomUUID().toString();
        bookManager = new BookManager();
        patronManager = new PatronManager();
    }

    public List<Book> getAllAvailableBooks(){
        return bookManager.getListOfAllAvailableBooks();
    }

    public List<Book> getAllBorrowedBooks(){
        return bookManager.getListOfAllBorrowedBooks();
    }

    public void addNewBookToInventory(Book book){
        bookManager.addNewBook(book);
    }

    public void removeBookFromInventory(Book book){
        bookManager.removeBookFromInventory(book);
    }

    public Book searchBookByTitle(String title){
        return bookManager.searchBookByTitle(title);
    }

    public List<Book> searchBookByAuthor(String author){
        return bookManager.searchBooksByAuthor(author);
    }

    public Book searchBookByISBN(String isbn){
        return bookManager.searchBookByISBN(isbn);
    }

    // patrons management

    public void addNewPatron(Patron patron){
        patronManager.addNewPatron(patron);
    }

    public List<Patron> showAllPatrons(){
        return patronManager.getAllPatronsOfLibrary();
    }

    public void updatePatronContact(String patronName,String newContactInfo){
        patronManager.updatePatronContactInfo(patronName,newContactInfo);
    }

    public void updatePatronAddress(String patronName,String newAddress){
        patronManager.updatePatronAddress(patronName,newAddress);
    }

    public List<Book> getListOfBorrowingHistoryOfPatron(String patronName){
        return patronManager.getBorrowedBooksHistoryByPatron(patronName);
    }

    public List<Book> getCurrentlyBorrowedBookListByPatron(String patronName){
        return patronManager.getBorrowedBooksByPatron(patronName);
    }

    public void checkout(Patron patron,Book book){
        patron.borrowBook(book);
        book.setBookAvailable(false);
        bookManager.borrowBook(book);
    }

    public void returnBook(Patron patron,Book book){
        patron.returnBorrowedBook(book);
        book.setBookAvailable(true);
        bookManager.returnBook(book);
    }

}
