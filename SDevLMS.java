//Nathan Perez
//Library Management Software for Software Development 1
//Last edited 7 Jan 2024

import java.io.*;
import java.util.Objects;
import java.util.Scanner; //import scanner class
import java.io.FileReader; //import file reader class
import java.time.LocalDate; //import time class


public class SDevLMS {
    //testing can be set to true if tests are being run. Otherwise leave false.
    static boolean testing = true;


    //scanner to be used in several methods
    static Scanner scan = new Scanner(System.in);

    //----------------------- MAIN -------------------------------------------------------------------

    public static void main(String[] args) throws IOException {



        //create Library (array of books)
        Book[] library = new Book[1000]; //can hold 1000 books, can be changed later if necessary

        //initialize array
        for(int i = 0; i < library.length; i++) {
            library[i] = new Book();
        }

        //start testing
        if(testing) {
            AddBook(2468, "Goat yoga", "Nate Perez", "nonfiction", true, null, library);
        }
        //end testing

        System.out.println("\nWelcome to the Library Management Software!");

        //while loop for select and performing functions
        while(true) {
            //user options
            System.out.println("\nPlease select an option from the ones below by entering the corresponding number.");
            System.out.println("1  -  Add books from a text file");
            System.out.println("2  -  Add a new book");
            System.out.println("3  -  Remove a book");
            System.out.println("4  -  Check-out a book");
            System.out.println("5  -  Check-in a book");
            System.out.println("6  -  Print library");
            System.out.println("-1 -  Quit");

            //create integer that stores users option choice
            int choice = 0;

            do {
                //catch any non-valid data types
                try {
                    choice = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Error, please enter only numbers. Please try again.");
                    scan.nextLine(); //clear the scanner after invalid input.
                }
            } while (choice == 0);

            //get user choice
            if(choice == -1) //quit
                break;
            else if(choice == 1) {   //file add

                try {
                    //file add function
                    ReadFile(library);
                } catch (Exception e) {
                    System.out.println("Error adding book(s) from text file.");
                    System.out.println("Please check that books in file are seperated by commas and barcode is an non-negative integer");
                }
            }
            //add
            else if(choice == 2) {
                //GetUserBook method
                GetUserBook(library);
            }
            //remove
            else if(choice == 3) {
                //remove book method
                RemoveBook(library);
            }
            //check out
            else if(choice == 4) {
                //check out method
                CheckOutBook(library);
            }
            //check in
            else if(choice == 5) {
                //check in method
                CheckInBook(library);
            }
            //print
            else if(choice == 6) {
                //print book method
                PrintBooks(library);
            }
            else {
                System.out.print(choice + " is not a valid option. Please try again.");
            }

        } //end while loop for running user options
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
            if (Objects.equals(library[i].getTitle(), title) && library[i].getBarcode() != -1)
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

            //add book to opening in array
//            library[openSpace].setBarcode(id);
//            library[openSpace].setTitle(title);
//            library[openSpace].setAuthor(author);
//            library[openSpace].setGenre(genre);
//            library[openSpace].setStatus(status);
//            library[openSpace].setDueDate(dueDate);

            //add book using setter
            library[openSpace].setBook(id, title, author, genre, status, dueDate);

            //print book for the user to let them know it has been added
            library[openSpace].Print();
            System.out.println(" has been added to your library.");
        }
        //if ID is not available (has already been used for another book).
        else System.out.println("Error, that ID has already been used.");
    }


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
    private static void ReadFile(Book[] library) throws IOException {

        String fileName;
        System.out.print("Please enter the name of the text file you would like to use. (Do not include .txt in your input): ");
        scan.nextLine();
        fileName = scan.nextLine();

        //testing
        System.out.println("Adding books from " + fileName + ".txt\n");

        //open file
        BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));

        //while there are lines to read, continue reading
        String line;
        while((line = reader.readLine()) != null) {
            //each line is read in separately and made into a book
            GetBookFromLine(line, library);
        }
    }


    // GET A BOOK FROM THE USER
    //get barcode, title, and author from user and run AddBook method
    //takes in library, returns nothing
    private static void GetUserBook(Book[] library) {
        //declare variables
        int barcode = -1;
        String title;
        String author;
        String genre;
        boolean status;
        LocalDate dueDate;


        //Prompt user to enter barcode, title, and author.
        System.out.println("Adding a book...");
        System.out.println("Please enter the Barcode Number, Title, Author, and Genre");

        //make sure that ID is available and allow user to try a different ID if it is not.
        boolean available = false;

        while(!available) {
            //get barcode from user
            System.out.print("Barcode: ");
            barcode = scan.nextInt();
            scan.nextLine(); //removes new line character so that title does not scan it.

            available = IdAvailability(barcode, library);

            if(!available)
                System.out.println("Sorry that barcode number has already been used. Please try again with a different barcode number.");
        }

        //get title from user
        System.out.print("Title: ");
        title = scan.nextLine();

        //get author from user
        System.out.print("Author: ");
        author = scan.nextLine();

        //get genre from user
        System.out.print("Genre: ");
        genre = scan.nextLine();

        //automatically set all new books added by the user to checked in (true)
        status = true;

        //since the books are checked in they don't have a due date (dueDate == null)
        dueDate = null;

        //add book using the AddBook method
        AddBook(barcode, title, author, genre, status, dueDate, library);
    }


    // REMOVE BOOK
    //removes a book from the library using either barcode or title
    //takes in library, returns nothing
    public static void RemoveBook(Book[] library) {
        //check to see if there are any books in library
        //if library has any books in it
        if(HasBooks(library)) {
            int barcode;
            int location = -1;

            do {
                //initialize choice variable. Will be changed to 1 for barcode or 2 for title.
                int choice = -1;

                do {
                    //ask user if they want to use barcode or title to remove
                    System.out.println("Would you like to remove the book using its barcode or title?");
                    System.out.println("1 - Barcode");
                    System.out.println("2 - Title");
                    choice = scan.nextInt();

                    //user chose 1, remove by barcode
                    if (choice == 1) {
                        //ask user for barcode of book to remove
                        System.out.println("Please enter the barcode number of the book you would like to remove: ");
                        barcode = scan.nextInt();

                        //find the location of the book in the library
                        location = FindBookUsingBarcode(barcode, library);
                    }
                    //user chose 2, remove by title
                    else if (choice == 2) {
                        //ask user for title of book to remove
                        System.out.println("Please enter the title of the book you would like to remove: ");
                        scan.nextLine();
                        String title = scan.nextLine();

                        //find the location of the book in the library
                        location = FindBookUsingTitle(title, library);
                    }
                    //user didn't choose 1 or 2.
                    else {
                        System.out.println(choice + " is not a valid option. Please try again.");
                    }
                } while (choice != 1 && choice != 2); //repeat if user enters an invalid option

                //if location is still -1 book with that barcode must not exist
                if(location == -1)
                    System.out.println("Error, no book could be found.");

            } while (location == -1); //repeat if book can not be found. Allow user to retry

            //check whether user would like to remove the given book.
            int yn; //stores 1 for yes and 2 for no
            do {
                //print book
                System.out.print("Are you sure you want to remove ");
                library[location].Print();
                System.out.println("?");

                System.out.println("1 - Yes");
                System.out.println("2 - No");
                yn = scan.nextInt();

                if (yn == 1) {
                    //remove book using its location
                    //set barcode to -1 so that it can be overwritten
                    library[location].setBarcode(-1);

                    System.out.println("Book has been removed. ");
                }
                else if (yn == 2) {
                    //don't remove book
                    System.out.println("Okay, we'll leave it for now. ");
                } else System.out.println(yn + " is not a valid option. Please try again.");
            } while (yn != 1 && yn != 2);

        }
        //there are no books in library
        else System.out.println("You currently do not have any books. ");

        //remove 1 from the book count
        Book.minusBooks();
    }


    // CHECK OUT BOOK
    //takes in library, returns nothing
    private static void CheckOutBook(Book[] library) {
        String title;
        int location;

        //get rid of extra new line character
        scan.nextLine();

        do {
            //get title from the user
            System.out.print("Please enter the title of the book you would like to check out: ");
            title = scan.nextLine();

            //get location in library using the title
            location = FindBookUsingTitle(title, library);

            if(location != -1) {
                //checkout book using book's method 'Checkout()' .
                library[location].Checkout();
            }
            else {
                System.out.println("Error, could not find the book titled " + title + ". Please try again.");
            }
        } while (location == -1);
    }


    // CHECK IN BOOK
    //takes in library, returns nothing
    private static void CheckInBook(Book[] library) {
        String title;
        int location;

        do {
            //get title from the user
            System.out.print("Please enter the title of the book you would like to check in: ");
            title = scan.next();

            //get location in library using the title
            location = FindBookUsingTitle(title, library);

            if(location != -1) {
                //check in book using book's method 'Checkin()' .
                library[location].Checkin();
            }
            else
                System.out.println("Error, could not find the book " + title + ". Please try again.");
        } while (location == -1);
    }


    // PRINT ALL BOOKS
    //prints all books in the library
    //takes in library, returns nothing
    private static void PrintBooks(Book[] library) {
        //check to make sure library has books in it
        if(HasBooks(library)) {
            System.out.println("Books: ");
            //for each book in the library
            for (Book book : library) {
                if (book.getBarcode() != -1) {
                    book.Print();
                    System.out.print("\n");
                }
            }
        }
        //there are no books in library
        else System.out.println("You currently do not have any books. ");
    }


} //end public class SDevLMS
