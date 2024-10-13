package aitribe.main;

import aitribe.book.Book;
import aitribe.librarian.Librarian;
import aitribe.patron.Patron;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Angels & Demons","Dan Brown","IN12345");
        Book book2 = new Book("The morning miracle","Hal Elrod","IN48575");
        Patron patron = new Patron("Raman","Kothrud, Pune","9999999");
        Patron patron2 = new Patron("Raju","Bangalore","47575849");

        Librarian librarian = new Librarian();
        librarian.addNewBookToInventory(book1);
        librarian.addNewBookToInventory(book2);
        librarian.addNewPatron(patron);
        librarian.addNewPatron(patron2);
        librarian.checkout(patron,book1);
        List<Book> allBooks = librarian.getAllAvailableBooks();
        if(allBooks.size()!=0){
            System.out.println("All Available books:");
            for(Book books : allBooks){
                System.out.println(books);
            }
        }
        else{
            System.out.println("No Books available");
        }
        List<Book> allBorrowedBooks = librarian.getAllBorrowedBooks();
        if(allBorrowedBooks.size()!=0){
            System.out.println("All Borrowed books:");
            for(Book books : allBorrowedBooks){
                System.out.println(books);
            }
        }
        else{
            System.out.println("No Books borrowed");
        }
        List<Book> patronBorrowedBooks = librarian.getCurrentlyBorrowedBookListByPatron(patron.getPatronName());
        if(patronBorrowedBooks.size()!=0){
            System.out.println("Books borrowed by patron : "+patron.getPatronName());
            for(Book books : patronBorrowedBooks){
                System.out.println(books);
            }
        }
        else{
            System.out.println("No Books borrowed");
        }

        librarian.returnBook(patron,book1);
        List<Book> allBooks1 = librarian.getAllAvailableBooks();
        if(allBooks1.size()!=0){
            System.out.println("All Available books:");
            for(Book books : allBooks1){
                System.out.println(books);
            }
        }
        else{
            System.out.println("No Books available");
        }
        System.out.println(librarian.showAllPatrons());
    }
}
