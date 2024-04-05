import DBHelper.books;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewBooksFrame extends JFrame {

    private JPanel viewPanel;
    private JButton refreshButton;
    private JTable tableLibrary;



    public ViewBooksFrame(books db) {
        setTitle("View Library");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //get table of books from database using DatabaseLMS method get2dArrayOfLibrary()
        ArrayList<ArrayList<Object>> table = DatabaseLMS.get2dArrayOfLibrary(db);

        //names for the columns
        String[] colNames = new String[]{"Barcode", "Title", "Author", "Genre", "Status", "Due date"};

        //convert table to array, so it will fit my printing format
        Object[][] array = new Object[table.size()][];
        for (int i = 0; i < table.size(); i++) {
            ArrayList<Object> innerList = table.get(i);
            array[i] = innerList.toArray(new Object[0]);
        }

        //create table
        tableLibrary = new JTable(array, colNames);

        // Create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(tableLibrary);

        viewPanel.setLayout(new BorderLayout()); // Set BorderLayout

        // Add the scroll pane containing the table to the viewPanel
        viewPanel.add(scrollPane, BorderLayout.CENTER);

        setContentPane(viewPanel);
        setVisible(true);


    }


}

