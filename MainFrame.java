import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JButton btnAddBook;
    private JButton btnImportLibrary;
    private JButton btnRemoveBarcode;
    private JButton btnCheckOut;
    private JButton btnCheckIn;
    private JButton btnViewBooks;
    private JPanel mainPanel;
    private JButton btnRemoveTitle;
    //private JPanel addBookPanel;

    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("Library Management System - Home");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnImportLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnAddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookFrame myAddBookForm = new AddBookFrame();
            }
        });
        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckOutBookFrame myCheckOut = new CheckOutBookFrame();
            }
        });
        btnCheckIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckInBookFrame myCheckIn = new CheckInBookFrame();
            }
        });
        btnViewBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewBooksFrame myView = new ViewBooksFrame();
            }
        });
        btnRemoveTitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveBookTitleFrame myRemoveTitle = new RemoveBookTitleFrame();
            }
        });
        btnRemoveBarcode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveBookBarcodeFrame myRemoveBarcode = new RemoveBookBarcodeFrame();
            }
        });
        btnImportLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImportLibraryFrame myImportLibrary = new ImportLibraryFrame();
            }
        });
    }

    public static void main(String[] args){
        MainFrame myMainFrame = new MainFrame();
    }
}
