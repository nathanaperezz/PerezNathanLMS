/*
 * Nathan Perez
 * Software Development 1
 *
 * Library Management System
 * Uses a GUI to perform the following:
 *      Print the contents of the database to the GUI screen.
 *      Remove a book from the database (SQLite file) by title or barcode.
 *      Check out a book.  The book's status will change to "checked out" and the due date will be updated.
 *      Check in a book.  The book's status will change to "checked in" and the due date will be updated to "null".
 * Uses a SQLite database to store library
 */

import DBHelper.books;
import java.util.ArrayList;

public class DatabaseLMS {

    public static void main(String[] args) {
        books db = new books();
        MainFrame myMainFrame = new MainFrame(db);
    }

    
    /**
     * Get a 2d Array of database
     * @param db Database to use
     * @return 2d array of entire database
     */
    public static ArrayList<ArrayList<Object>> get2dArrayOfLibrary (books db) {
        ArrayList<ArrayList<Object>> array2d;
        array2d = db.getExecuteResult("SELECT * FROM books;");
        return array2d;
    }

    /**
     * Deletes book from database
     * @param title Title of book to remove
     * @param db Database to remove from
     */
    public static void DeleteUsingTitle(String title, books db) {
        db.delete("title", title);
    }

    /**
     * Deletes book from database
     * @param barcode Barcode of book to remove
     * @param db Database to remove from
     */
    public static void DeleteUsingBarcode(int barcode, books db) {
        db.delete("barcode", String.valueOf(barcode));
    }

    /**
     * Changes status to checked out and adds dueDate in 14 days
     * @param title Title of book to check out
     * @param db Database to check out from
     */
    public static void Checkout(String title, books db) {
        db.update("status", String.valueOf(false), "title", title);
        db.execute("UPDATE books SET due_date = DATE('now', '+14 day') WHERE title = '" + title + "';");
    }

    /**
     * Changes status to checked in and changes dueDate to null.
     * @param title Title of book to check in
     * @param db Database to check in to
     */
    public static void Checkin(String title, books db) {
        db.update("status", String.valueOf(true), "title", title);
        db.execute("UPDATE books SET due_date = NULL WHERE title = '" + title + "';");
    }

}