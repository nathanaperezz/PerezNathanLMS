import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveBookTitleFrame extends JFrame{
    private JPanel removeBookTitlePanel;
    private JTextField tfTitle;
    private JButton btnEnter;

    public RemoveBookTitleFrame(Book[] library) {
        setContentPane(removeBookTitlePanel);
        setTitle("Remove Book Using Title");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get title from text field
                String title = tfTitle.getText();
                //remove book using title
                LMS.RemoveBookTitle(title, library);
                setVisible(false);
            }
        });
    }
}
