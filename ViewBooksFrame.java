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


    /**
     * Opens view library panel
     * @param db Database to view
     */
    public ViewBooksFrame(books db) {
        setTitle("View Library");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ArrayList<ArrayList<Object>> table = DatabaseLMS.get2dArrayOfLibrary(db);

        String[] columnNames = new String[]{"Barcode", "Title", "Author", "Genre", "Status", "Due date"};

        //convert table to array, so it will fit my printing format and make status more readable
        Object[][] array = new Object[table.size()][];
        for (int i = 0; i < table.size(); i++) {
            ArrayList<Object> innerList = table.get(i);
            array[i] = innerList.toArray(new Object[0]);

            //display status as available/checked
            if(array[i][4].equals(1) || array[i][4].equals("true"))
                array[i][4] = "Available";
            else
                array[i][4] = "Checked out";

        }

        tableLibrary = new JTable(array, columnNames);
        JScrollPane scrollPane = new JScrollPane(tableLibrary);
        viewPanel.setLayout(new BorderLayout());
        viewPanel.add(scrollPane, BorderLayout.CENTER);

        setContentPane(viewPanel);
        setVisible(true);
    }

}

