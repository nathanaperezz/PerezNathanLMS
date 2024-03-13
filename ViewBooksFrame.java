import javax.swing.*;

public class ViewBooksFrame extends JFrame {

    private JPanel viewPanel;

    public ViewBooksFrame() {
        setContentPane(viewPanel);
        setTitle("View Library");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

