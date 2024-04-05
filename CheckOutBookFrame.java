
import DBHelper.books;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOutBookFrame extends JFrame{
    private JTextField tfTitle;
    private JButton btnEnter;
    private JPanel checkOutPanel;

    public CheckOutBookFrame(books db) {
        setContentPane(checkOutPanel);
        setTitle("Check-out Book");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get title from text field
                String title = tfTitle.getText();
                //check out book using checkout method in DatabaseLMS
                DatabaseLMS.Checkout(title, db);
                //LibraryDatabase.CheckOutBook(title, db);
                setVisible(false);
            }
        });
    }
}
