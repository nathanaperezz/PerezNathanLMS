import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    private JButton btnImportLibrary;
    private JButton btnRemoveBarcode;
    private JButton btnCheckOut;
    private JButton btnCheckIn;
    private JButton btnViewBooks;
    private JPanel mainPanel;
    private JButton btnRemoveTitle;
    //private JPanel addBookPanel;

    public MainFrame(Book[] library) {
        setContentPane(mainPanel);
        setTitle("Library Management System");
        setSize(450, 300);
        //setSize(550, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnImportLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckOutBookFrame myCheckOut = new CheckOutBookFrame(library);
            }
        });
        btnCheckIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckInBookFrame myCheckIn = new CheckInBookFrame(library);
            }
        });
        btnViewBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewBooksFrame myView = new ViewBooksFrame(library);
            }
        });
        btnRemoveTitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveBookTitleFrame myRemoveTitle = new RemoveBookTitleFrame(library);
            }
        });
        btnRemoveBarcode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveBookBarcodeFrame myRemoveBarcode = new RemoveBookBarcodeFrame(library);
            }
        });
        btnImportLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImportLibraryFrame myImportLibrary = new ImportLibraryFrame(library);
            }
        });
    }

}
