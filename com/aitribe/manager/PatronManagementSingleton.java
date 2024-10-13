package aitribe.manager;

public class PatronManagementSingleton {
    private static PatronManager patronManager;

    public static PatronManager getInstance(){
        if(patronManager==null){
            return new PatronManager();
        }
        else{
            return patronManager;
        }
    }
}
