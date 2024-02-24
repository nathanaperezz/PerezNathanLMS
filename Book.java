//Nathan Perez
//Library Management Software for Software Development 1 Module 2
//Last edited 24 Feb 2024

//Book Class
//stores  title, author, barcode number, genre, status, and due date

public class Book {
    static int numBooks = 0;
    int id = -1;
    String title;
    String author;
    String genre;
    boolean status; 
    //date dueDate;

    //prints the book with commas separating attributes (no spaces).
    void Print() {
        System.out.print(id + "," + title + "," + author);
    }
}
