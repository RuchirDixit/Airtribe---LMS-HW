package aitribe.manager;

import aitribe.book.Book;
import aitribe.patron.Patron;

import java.util.ArrayList;
import java.util.List;

public class PatronManager {

    private List<Patron> patronList;

    public PatronManager(){
        patronList = new ArrayList<>();
    }

    public void addNewPatron(Patron patron){
        this.patronList.add(patron);
    }

    public void updatePatronContactInfo(String patronName, String newContact){
        for(Patron patron : patronList){
            if(patron.getPatronName().equalsIgnoreCase(patronName)){
                patron.setContactInfo(newContact);
            }
        }
    }
    public List<Patron> getAllPatronsOfLibrary(){
        return this.patronList;
    }

    public void updatePatronAddress(String patronName, String newAddress){
        for(Patron patron : patronList){
            if(patron.getPatronName().equalsIgnoreCase(patronName)){
                patron.setAddress(newAddress);
            }
        }
    }

    public List<Book> getBorrowedBooksByPatron(String patronName){
        for(Patron patron : patronList){
            if(patron.getPatronName().equalsIgnoreCase(patronName)){
                return patron.getBorrowedBooks();
            }
        }
        return null;
    }

    public List<Book> getBorrowedBooksHistoryByPatron(String patronName){
        for(Patron patron : patronList){
            if(patron.getPatronName().equalsIgnoreCase(patronName)){
                return patron.getHistory();
            }
        }
        return null;
    }
}
