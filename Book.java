//Nathan Perez
//Library Management Software for Software Development 1 Module 2
//Last edited 24 Feb 2024

//Book Class
//stores  title, author, barcode number, genre, status, and due date

import java.time.LocalDate;

public class Book {
    static int numBooks = 0;
    int barcode = -1;
    String title;
    String author;
    String genre;
    boolean status;
    LocalDate dueDate = null;

    //prints the book with commas separating attributes (no spaces).
    void Print() {
        System.out.print(barcode + "," + title + "," + author + "," + genre + "," + status + "," + dueDate);
    }

    //sets the due date to the date in 4 weeks.
    void Checkout() {
        status = false;
        dueDate = LocalDate.now().plusWeeks(4);
        Print();
        System.out.println(" has been checked out!");
    }

    void Checkin() {
        status = true;
        dueDate = null;
        Print();
        System.out.println(" has been checked in!");
    }
}
