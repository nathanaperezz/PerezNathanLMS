
import DBHelper.books;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveBookTitleFrame extends JFrame{
    private JPanel removeBookTitlePanel;
    private JTextField tfTitle;
    private JButton btnEnter;

    /**
     * Opens remove book panel
     * @param db Database to remove book from
     */
    public RemoveBookTitleFrame(books db) {
        setContentPane(removeBookTitlePanel);
        setTitle("Remove Book Using Title");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = tfTitle.getText();
                DatabaseLMS.DeleteUsingTitle(title, db);

                setVisible(false);
            }
        });
    }
}
