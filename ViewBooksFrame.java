import javax.swing.*;
import java.awt.*;

public class ViewBooksFrame extends JFrame {

    private JPanel viewPanel;
    private JTable tableLibrary;



    public ViewBooksFrame(Book[] library) {
        setTitle("View Library");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Object[][] book2dArray = LMS.get2dArrayOfLibrary(library);
        String[] col = new String[] {"Barcode", "Title", "Author", "Genre", "Status", "Due date"};

        //create table
        tableLibrary = new JTable(book2dArray, col);

        // Create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(tableLibrary);

        viewPanel.setLayout(new BorderLayout()); // Set BorderLayout

        // Add the scroll pane containing the table to the viewPanel
        viewPanel.add(scrollPane, BorderLayout.CENTER);

        setContentPane(viewPanel);
        setVisible(true);
    }


}

