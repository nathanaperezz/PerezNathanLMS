import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ImportLibraryFrame extends JFrame{
    private JTextField tfFileName;
    private JButton btnEnter;
    private JPanel importLibraryPanel;

    public ImportLibraryFrame(Book[] library) {
        setContentPane(importLibraryPanel);
        setTitle("Remove Book Using Title");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);


        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = tfFileName.getText();

                try {
                    LMS.ReadFile(fileName, library);
                    setVisible(false);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });

    }
}
