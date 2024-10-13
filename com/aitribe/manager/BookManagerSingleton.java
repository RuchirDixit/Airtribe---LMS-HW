package aitribe.manager;

public class BookManagerSingleton {
    private static BookManager bookManager;

    public static BookManager getInstance(){
        if(bookManager==null){
            return new BookManager();
        }
        else{
            return bookManager;
        }
    }
}
