package aitribe.patron;

import aitribe.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Patron {
    private String patronId;
    private String patronName;
    private String contactInfo;
    private String address;
    private List<Book> borrowedBooks;
    private List<Book> history;


    public Patron(String name, String address, String contactInfo){
        patronId = UUID.randomUUID().toString();
        this.patronName = name;
        this.address = address;
        this.contactInfo = contactInfo;
        borrowedBooks = new ArrayList<>();
        history = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Patron{" +
                "patronId='" + patronId + '\'' +
                ", patronName='" + patronName + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", address='" + address + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                ", history=" + history +
                '}';
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void borrowBook(Book book){
        this.borrowedBooks.add(book);
    }

    public void returnBorrowedBook(Book book){
        this.borrowedBooks.remove(book);
        this.history.add(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<Book> getHistory() {
        return history;
    }

}
