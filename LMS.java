//Nathan Perez
//Library Management Software for Software Development 1
//Last edited 13 March 2024

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;


public class LMS {

    //scanner to be used in several methods
    static Scanner scan = new Scanner(System.in);

    //----------------------- MAIN -------------------------------------------------------------------

    public static void main(String[] args) throws IOException {

        //create Library (array of books)
        Book[] library = new Book[1000]; //can hold 1000 books, can be changed later if necessary

        //initialize library array
        for(int i = 0; i < library.length; i++) {
            library[i] = new Book();
        }

        //run gui
        //MainFrame myMainFrame = new MainFrame(library);

    } //end main


    //----------------------- METHODS -------------------------------------------------------------------


    // CHECK ID AVAILABILITY
    /*checks availability of ID in library
    takes in the ID and library
    Returns true if ID is available, and false if ID has already been used */
    private static boolean IdAvailability(int id, Book[] library) {
        for (Book book : library) {
            if (book.getBarcode() == id)
                return false;
        }
        return true;
    }


    // CHECK IF THERE ARE BOOKS IN LIBRARY
    //checks to see if there are any books in the library array
    //Takes in the library
    //If there are books, return true, else return false
    private static boolean HasBooks(Book[] library) {
        for (Book book : library) {
            //if there are any books return true
            if (book.getBarcode() != -1)
                return true;
        }
        //if it gets to this point there are no books in the array
        return false;
    }


    // FIND BOOK USING BARCODE
    //finds a book in the library using the barcode, returns location of book in array, or -1 if book can't be found.
    private static int FindBookUsingBarcode(int barcode, Book[] library) {
        for (int i = 0; i < library.length; i++) {
            if (library[i].getBarcode() == barcode)
                return i;
        }
        return -1; //book could not be found
    }


    // FIND BOOK USING TITLE
    //finds a book in the library using the title, returns location of book in array, or -1 if book can't be found.
    private static int FindBookUsingTitle(String title, Book[] library) {
        for (int i = 0; i < library.length; i++) {
            //ensures that title matches and the books barcode does not equal -1
            if (Objects.equals(library[i].getTitle(), title) && library[i].getBarcode() != -1)
                //returns the location of the book in the array
                return i;
        }
        return -1; //book could not be found
    }


    // ADD BOOK
    //Adds the book to the first opening in the library
    //Takes in the ID, Title, and Author of book that is being created. Also takes in library
    public static void AddBook(int id, String title, String author, String genre, boolean status, LocalDate dueDate, Book[] library) {
        //if ID is available
        if(IdAvailability(id, library)) {
            int openSpace = -2;

            //add 1 to numBooks
            Book.plusBooks();

            //for loop that goes through library until it gets to an opening
            //checks for opening at the beginning first
            for (int i = 0; i < (Book.getNumBooks()); i++) {
                if (library[i].getBarcode() == -1) {
                    openSpace = i;
                    break;
                }
            }

            //add book using setter
            library[openSpace].setBook(id, title, author, genre, status, dueDate);

            //print book for the user to let them know it has been added
            library[openSpace].Print();
            System.out.println(" has been added to your library.");
        }
        //if ID is not available (has already been used for another book).
        else System.out.println("Error, that ID has already been used.");
    }

    //----------------------IMPORT LIBRARY -------------------------------------------------------------------------


    // GET A BOOK FROM A LINE
    //Separates line by commas and stores in id, title and author with their respective data types.
    //Sends this data to the AddBook method
    //Takes in a string (a line from the file), and library
    private static void GetBookFromLine(String line, Book[] library) {
        //declare variables that will hold the barcode, title, author, genre, status, and dueDate
        int barcode;
        String title;
        String author;
        String genre;
        boolean status;
        LocalDate dueDate;

        //split line into 3 strings (stored in array stringBook) using commas.
        String[] stringBook = line.split(",", 6);

        //set values of id, title, and author to values found in line
        barcode = Integer.parseInt(stringBook[0]); //change barcode from string to int
        title = stringBook[1];
        author = stringBook[2];
        genre = stringBook[3];
        status = Boolean.parseBoolean(stringBook[4]); //change status from string to boolean

        //if string says null, dueDate is null, otherwise dueDate is the date read in
        if(Objects.equals(stringBook[5], "null"))
            dueDate = null;
        else dueDate = LocalDate.parse(stringBook[5]);

        //add book to the library
        AddBook(barcode, title, author, genre, status, dueDate, library);
    }

    // READ FILE
    //Opens file and sends stores each line in a string called line.
    //This is then sent to the GetBookFromLine method
    //Takes in library, does not return anything.
    public static void ReadFile(String fileName, Book[] library) throws IOException {
        //read file
        BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));

        //while there are lines to read, continue reading
        String line;
        while((line = reader.readLine()) != null) {
            //each line is read in separately and made into a book
            GetBookFromLine(line, library);
        }
    }


    //----------------------REMOVE-------------------------------------------------------------------------

    // REMOVE BOOK
    //takes in a book and removes it from the library by setting its barcode to -1
    private static void RemoveBook(Book book) {
        //set barcode = -1
        book.setBarcode(-1);

        //remove 1 from the book count
        Book.minusBooks();
    }

    public static void RemoveBookTitle(String title, Book[] library){
        int location = FindBookUsingTitle(title, library);
        RemoveBook(library[location]);
    }


    //
    public static void RemoveBookBarcode(int barcode, Book[] library){
        int location = FindBookUsingBarcode(barcode, library);
        RemoveBook(library[location]);
    }

    //----------------------CHECK OUT / CHECK IN-------------------------------------------------------------------------

    // CHECK OUT BOOK
    //takes in title & library, returns nothing
    public static void CheckOutBook(String title, Book[] library) {
        //get location in library using the title
        int location = FindBookUsingTitle(title, library);

        //if book is in library
        if (location != -1) {
            //checkout book using book's method 'Checkout()' .
            library[location].Checkout();
        }
    }

    // CHECK IN BOOK
    //takes in title & library, returns nothing
    public static void CheckInBook(String title, Book[] library) {
            //get location in library using the title
            int location = FindBookUsingTitle(title, library);

            //if book is in library
            if(location != -1) {
                //check in book using book's method 'Checkin()' .
                library[location].Checkin();
            }
    }

    //----------------------PRINT-------------------------------------------------------------------------

    // PRINT ALL BOOKS
    //prints all books in the library
    //takes in library, returns nothing
    private static void PrintBooks(Book[] library) {
        //check to make sure library has books in it
        if(HasBooks(library)) {
            for (Book book : library) {
                if (book.getBarcode() != -1) {
                    book.Print();
                }
            }
        }
        //there are no books in library
//        else System.out.println("You currently do not have any books. ");
    }

    public static Object [][] get2dArrayOfLibrary(Book[] library) {
        Object [][] array2d;
        //array2d = new Object[6][Book.getNumBooks()];
        array2d = new Object[Book.getNumBooks()][6];

        int j = 0;
        for(int i = 0; i < library.length; i++) {
            if(library[i].getBarcode() != -1) {
                array2d[j] = library[i].getBookAsArray();
                j++;
            }
        }
        return array2d;
    }

} //end class LMS
