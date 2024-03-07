//Nathan Perez
//Library Management Software for Software Development 1 Module 2
//Last edited 24 Feb 2024

//Book Class
//stores  title, author, barcode number, genre, status, and due date

import java.time.LocalDate;

public class Book
{
    private static int numBooks = 0;
    private int barcode = -1;
    private String title;
    private String author;
    private String genre;
    private boolean status;
    private LocalDate dueDate = null;

    //getters and setters
    public static int getNumBooks() {
        return numBooks;
    }

    public int getBarcode() {
        return barcode;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isStatus() {
        return status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public static void setNumBooks(int numBooks) {
        Book.numBooks = numBooks;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


    //get book as string method
    public String getBookAsString() {
        return (barcode + "," + title + "," + author + "," + genre + "," + status + "," + dueDate);
    }

    public void setBook(int barcode, String title, String author, String genre, boolean status, LocalDate dueDate) {
        this.barcode = barcode;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
        this.dueDate = dueDate;
    }

    public static void plusBooks(){
        numBooks++;
    }

    public static void minusBooks(){
        numBooks--;
    }


    //prints the book.
    void Print()
    {
        //System.out.print(barcode + "," + title + "," + author + "," + genre + "," + status + "," + dueDate);
        System.out.print(barcode + ",\t" + title + ",\t" + author + ",\t" + genre);
    }

    //used to check out any book.
    //sets the due date to the date in 4 weeks.
    //sets the book's status as checked out (false).
    void Checkout()
    {
        status = false;
        dueDate = LocalDate.now().plusWeeks(4);
        Print();
        System.out.println(" has been checked out!");
    }

    //used to check in any books.
    //Changes the status to checked in (true) and dueDate to no due date (null).
    void Checkin()
    {
        status = true;
        dueDate = null;
        Print();
        System.out.println(" has been checked in!");
    }
}
