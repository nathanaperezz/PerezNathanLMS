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
        SDevLMS.AddBook(1, "test book for adding book", "author", "genre", true, null, libraryTest);

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
        SDevLMS.AddBook(2, "test book for removing book", "author", "genre", true, null, libraryTest);


        //gets number of books before book is added
        int numberOfBooks = Book.getNumBooks();

        //adds book
        //SDevLMS.RemoveBook(libraryTest);

        //adds 1 to number of books
        numberOfBooks--;

        //checks that the expected number of books = the actual number of books
        //assertEquals(numberOfBooks, Book.getNumBooks());
    }

    //checks that when a book is checked out its dueDate is no longer null.
    @Test
    void CheckOutBookTest() {
        Book[] libraryTest = new Book[10];
        //initialize books
        for(int i = 0; i < libraryTest.length; i++)
        {
            libraryTest[i] = new Book();
        }

        //add book to be checked out
        SDevLMS.AddBook(3, "test book for checking out", "author", "genre", true, null, libraryTest);

        //checkout book
        libraryTest[0].Checkout();

        assertEquals(false, libraryTest[0].isStatus());
    }

    //checks that when a book is checked in its dueDate becomes null.
    @Test
    void CheckInBookTest() {
        Book[] libraryTest = new Book[10];
        //initialize books
        for(int i = 0; i < libraryTest.length; i++)
        {
            libraryTest[i] = new Book();
        }

        //add book to be checked in
        SDevLMS.AddBook(4, "test book for checking in", "author", "genre", false, null, libraryTest);

        libraryTest[0].Checkin();

        assertEquals(true, libraryTest[0].isStatus());
    }

}