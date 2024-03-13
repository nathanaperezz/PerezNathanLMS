import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveBookBarcodeFrame extends JFrame{
    private JTextField tfBarcode;
    private JPanel removeBarcodePanel;
    private JButton btnEnter;

    public RemoveBookBarcodeFrame(Book[] library) {
        setContentPane(removeBarcodePanel);
        setTitle("Remove Book Using Barcode");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get barcode as string from text field and change it to an int
                int barcode = Integer.parseInt(tfBarcode.getText());
                //remove book using barcode
                LMS.RemoveBookBarcode(barcode, library);
                setVisible(false);
            }
        });
    }
}
