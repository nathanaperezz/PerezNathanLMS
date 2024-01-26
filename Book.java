//Nathan Perez
//Library Management Software for Software Development 1 Module 2
//Last edited 25 Jan 2024

//Book Class

public class Book {
    static int numBooks = 0;
    int id = -1;
    String title;
    String author;

    //prints the book with commas separating attributes.
    void Print() {
        System.out.print(id + "," + title + "," + author);
    }
}
