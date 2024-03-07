import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//Nathan Perez
//Library Management Software for Software Development 1
//Last edited 7 Jan 2024

//TESTS THE FOLLOWING:
//books can be added to the database
//a book can be removed from the database by barcode or title
//a book can be checked out.  If so, the due date is no longer "null".
//a book can be checked in. If so, the due date is "null".



class SDevLMSTest {



//tests that the numBooks in the library are 1 higher after 1 book is added.
    @Test
    void AddBookTest() {
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

    @Test
    void RemoveBookTest() {
        Book[] libraryTest = new Book[10];
        //initialize books
        for(int i = 0; i < libraryTest.length; i++)
        {
            libraryTest[i] = new Book();
        }

        //add book to be removed 
        SDevLMS.AddBook(10, "title", "author", "genre", true, null, libraryTest);


        //gets number of books before book is added
        int numberOfBooks = Book.getNumBooks();

        //adds book
        SDevLMS.RemoveBook(libraryTest);

        //adds 1 to number of books
        numberOfBooks--;

        //checks that the expected number of books = the actual number of books
        assertEquals(numberOfBooks, Book.getNumBooks());
    }

}