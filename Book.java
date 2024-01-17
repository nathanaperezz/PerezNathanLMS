
public class Book {
    static int numBooks = 0;
    int id = 0;
    String title;
    String author;

    //prints the book with commas separating attributes.
    void Print() {
        System.out.println(id + "," + title + "," + author);
    }
}
