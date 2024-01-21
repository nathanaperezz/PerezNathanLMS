
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
