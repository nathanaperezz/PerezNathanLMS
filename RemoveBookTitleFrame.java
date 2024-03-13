import javax.swing.*;

public class RemoveBookTitleFrame extends JFrame{
    private JPanel removeBookTitlePanel;
    private JTextField tfTitle;
    private JButton btnEnter;

    public RemoveBookTitleFrame() {
        setContentPane(removeBookTitlePanel);
        setTitle("Remove Book Using Title");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
