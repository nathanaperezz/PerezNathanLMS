import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SDevLMSTest {

//tests that the numBooks in the library are 1 higher after 1 book is added.
    @Test
    void addBook() {
        Book[] libraryTest = new Book[10];
        //initialize books
        for(int i = 0; i < libraryTest.length; i++)
        {
            libraryTest[i] = new Book();
        }

        //gets number of books before book is added
        int numberOfBooks = Book.getNumBooks();

        //adds book
        SDevLMS.AddBook(10, "title", "author", "genre", true, null, libraryTest);

        //adds 1 to number of books
        numberOfBooks++;

        //checks that the expected number of books = the actual number of books
        assertEquals(numberOfBooks, Book.getNumBooks());
    }
}