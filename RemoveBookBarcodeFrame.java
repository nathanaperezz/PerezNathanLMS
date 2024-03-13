import javax.swing.*;

public class RemoveBookBarcodeFrame extends JFrame{
    private JTextField tfBarcode;
    private JPanel removeBarcodePanel;

    public RemoveBookBarcodeFrame() {
        setContentPane(removeBarcodePanel);
        setTitle("Remove Book Using Barcode");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
