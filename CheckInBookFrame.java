import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckInBookFrame extends JFrame {
    private JTextField tfTitle;
    private JButton btnEnter;
    private JPanel checkInPanel;

    public CheckInBookFrame(Book[] library) {
        setContentPane(checkInPanel);
        setTitle("Check-in Book");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get title from text field
                String title = tfTitle.getText();
                //check in book using checkinbook method in LMS
                LMS.CheckInBook(title, library);
                setVisible(false);
            }
        });
    }
}
