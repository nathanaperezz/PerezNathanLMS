import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookFrame extends JFrame{
    private JTextField tfBarcode;
    private JTextField tfTitle;
    private JTextField tfAuthor;
    private JTextField tfGenre;
    private JButton btnClear;
    private JButton btnEnter;
    public JPanel addBookPanel;
    private JButton btnBack;


    public AddBookFrame() {
        setContentPane(addBookPanel);
        setTitle("Library Management System");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
