import DBHelper.books;

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

    public MainFrame(books db) {
        setContentPane(mainPanel);
        setTitle("Library Management System");
        setSize(450, 300);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckOutBookFrame myCheckOut = new CheckOutBookFrame(db);
            }
        });
        btnCheckIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckInBookFrame myCheckIn = new CheckInBookFrame(db);
            }
        });
        btnViewBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewBooksFrame myView = new ViewBooksFrame(db);
            }
        });
        btnRemoveTitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveBookTitleFrame myRemoveTitle = new RemoveBookTitleFrame(db);
            }
        });
        btnRemoveBarcode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveBookBarcodeFrame myRemoveBarcode = new RemoveBookBarcodeFrame(db);
            }
        });
    }

}
