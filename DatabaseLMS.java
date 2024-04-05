import DBHelper.books;

import java.util.ArrayList;

public class DatabaseLMS {

    public static void main(String[] args) {

        //create instance of database class, books
        books db = new books();

        //run gui
        MainFrame myMainFrame = new MainFrame(db);

    } //end main

    //--------------------- FUNCTIONS -----------------------------------------------------

    //Print the contents of the database to the GUI screen.
    //Create 2d array of db for printing
    public static ArrayList<ArrayList<Object>> get2dArrayOfLibrary (books db) {
        ArrayList<ArrayList<Object>> array2d;
        array2d = db.getExecuteResult("SELECT * FROM books;");
        return array2d;
    }

    //Remove a book from the database (SQLite file) by title or barcode.
    //  using title
    public static void DeleteUsingTitle(String title, books db) {
        db.delete("title", title);
    }
    //  using barcode
    public static void DeleteUsingBarcode(int barcode, books db) {
        db.delete("barcode", String.valueOf(barcode));
    }

    //Check out a book.  The book's status will change to "checked out" and the due date will be updated.
    public static void Checkout(String title, books db) {
        db.update("status", String.valueOf(false), "title", title);
        db.execute("UPDATE books SET due_date = DATE('now', '+14 day') WHERE title = '" + title + "';");
    }

    //Check in a book.  The book's status will change to "checked in" and the due date will be updated to "null".
    public static void Checkin(String title, books db) {
        db.update("status", String.valueOf(true), "title", title);
    }

} // end class