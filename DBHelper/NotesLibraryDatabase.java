package DBHelper;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
public class NotesLibraryDatabase {
    public static void main (String [] args) {

        //create instance of database class, books
        books booksdb = new books();

        /*create a 2d arraylist to hold the result of a query
        (can hold rows and cols of any type) */
        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();

        //perform a query to get all the contents of database
        data = booksdb.getExecuteResult("select * from books;");

        //print the result of the query, by printing what is stored in ArrayList data
        for(List<Object> record : data) {
            System.out.println(record.toString());
        }

        //delete a row of data from the database, based on barcode
        booksdb.delete("barcode", "101010");
        System.out.println("Deleted.");

        data = booksdb.getExecuteResult("select * from books");
        System.out.println("\nHere are the contents of the database: \n");
        printDatabase(data);

        //add a new entry to the database (can use either)
        booksdb.execute("INSERT INTO books VALUES (123, 'It', 'Stephen King' ..... ");
        booksdb.insert(99999, "book book", "writer", "fiction", true, null);

        //pull all records from DB and print
        data = booksdb.getExecuteResult("select * from books");
        System.out.println("\nHere are the contents of the database: \n");
        printDatabase(data);

        //update a row of data
        booksdb.update(booksdb.title, "updated title blah blah", booksdb.barcode, "12");

        //perform a specific query on db
        data = booksdb.getExecuteResult("select genre from books where barcode = 12;");
        //OR you can use select method
        data = booksdb.select("barcode, title", "barcode", "123445", "barcode", "DESC");


        DefaultTableModel table = new DefaultTableModel();

        //printing a table
        String data2 = null;
        System.out.println("\nHere is the table: ");

        for (int row = 0; row < table.getRowCount(); row++) {
            for (int col = 0; col < table.getColumnCount(); col++) {
                System.out.print(table.getValueAt(row, col).toString() + " | ");
            }
            System.out.println();
        }
    }

    public static void printDatabase(ArrayList<ArrayList<Object>> data) {

        for(List<Object> record : data) {
            System.out.println(record.toString());
        }
    }
}
