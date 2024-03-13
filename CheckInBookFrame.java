import javax.swing.*;

public class CheckInBookFrame extends JFrame {
    private JTextField tfTitle;
    private JButton btnEnter;
    private JPanel checkInPanel;

    public CheckInBookFrame() {
        setContentPane(checkInPanel);
        setTitle("Check-in Book");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
