import DBHelper.books;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckInBookFrame extends JFrame {
    private JTextField tfTitle;
    private JButton btnEnter;
    private JPanel checkInPanel;

    /**
     * Opens check in book panel
     * @param db Database to check book in to
     */
    public CheckInBookFrame(books db) {
        setContentPane(checkInPanel);
        setTitle("Check-in Book");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String title = tfTitle.getText();

                DatabaseLMS.Checkin(title, db);

                setVisible(false);
            }
        });
    }
}
