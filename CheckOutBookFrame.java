import javax.swing.*;

public class CheckOutBookFrame extends JFrame{
    private JTextField tfTitle;
    private JButton btnEnter;
    private JPanel checkOutPanel;

    public CheckOutBookFrame() {
        setContentPane(checkOutPanel);
        setTitle("Check-out Book");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
