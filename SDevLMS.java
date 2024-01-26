//Nathan Perez
//Library Management Software for Software Development 1 Module 2
//Create a basic LMS using SDLC created in Part I
//Last edited 25 Jan 2024

import java.io.*;
import java.util.Scanner; //import scanner class
import java.io.FileReader; //import file reader class

public class SDevLMS
{
    //scanner to be used in several methods
    static Scanner scan = new Scanner(System.in);

    //----------------------- MAIN -------------------------------------------------------------------

    public static void main(String[] args) throws IOException {

        //create Library (array of books)
        Book[] library = new Book[1000]; //can hold 1000 books, can be changed later if necessary

        //initialize array
        for(int i = 0; i < library.length; i++)
        {
            library[i] = new Book();
        }

        System.out.println("Welcome to the Library Management Software!");

        //while loop for select and performing functions
        while(true)
        {
            //user options
            System.out.println("\nPlease select an option from the ones below by entering the corresponding number.");
            System.out.println("1 - Add books from a text file");
            System.out.println("2 - Add a new book");
            System.out.println("3 - Remove a book");
            System.out.println("4 - Print library");
            System.out.println("-1 - Quit");

            //create integer that stores users option choice
            int choice = 0;

            //catch any non-valid data types
            try
            {
                choice = scan.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("Error please enter only numbers");
            }

            //get user choice
            if(choice == -1) //quit
                break;
            else if(choice == 1) //file add
            {
                try {
                    //file add function
                    ReadFile(library);
                } catch (Exception e) {
                    System.out.println("Error adding book(s) from text file.");
                    System.out.println("Please check that books in file are seperated by commas and ID is an non-negative integer");
                }
            }
            else if(choice == 2) //add
            {
                //GetUserBook method
                GetUserBook(library);
            }
            else if(choice == 3) //remove
            {
                //remove book method
                RemoveBook(library);
            }
            else if(choice == 4) //print
            {
                //print book method
                PrintBooks(library);
            }
            else
            {
                System.out.println(choice + " is not an valid option. Please try again.");
            }

        } //end while loop for running user options
    } //end main


    //----------------------- METHODS -------------------------------------------------------------------

    //checks availability of ID in library
    //takes in the ID and library
    //Returns true if ID is available, and false if ID has already been used
    private static boolean IdAvailability(int id, Book[] library)
    {
        for (Book book : library) {
            if (book.id == id)
                return false;
        }
        return true;
    }

    //checks to see if there are any books in the library array
    //Takes in the library
    //If there are books, return true, else return false
    private static boolean HasBooks(Book[] library)
    {
        for (Book book : library) {
            //if there are any books return true
            if (book.id != -1)
                return true;
        }
        //if it gets to this point there are no books in the array
        return false;
    }


    //Adds the book to the first opening in the library
    //Takes in the ID, Title, and Author of book that is being created. Also takes in library
    private static void AddBook(int id, String title, String author, Book[] library)
    {
        //if ID is available
        if(IdAvailability(id, library))
        {
            int openSpace = -2;

            Book.numBooks++;

            //for loop that goes through library until it gets to an opening
            //checks for opening at the beginning first
            for (int i = 0; i < (Book.numBooks); i++) {
                if (library[i].id == -1) {
                    openSpace = i;
                    break;
                }
            }

            //add book to opening in array
            library[openSpace].id = id;
            library[openSpace].title = title;
            library[openSpace].author = author;

            //print book for the user to let them know it has been added
            library[openSpace].Print();
            System.out.println(" has been added to your library.");
        }
        //if ID is not available (has already been used for another book).
        else System.out.println("Error, that ID has already been used.");
    }

    //Separates line by commas and stores in id, title and author with their respective data types.
    //Sends this data to the AddBook method
    //Takes in a string (a line from the file), and library
    private static void GetBookFromLine(String line, Book[] library)
    {
        //declare variables that will hold the id, title, and author
        int id;
        String title;
        String author;

        //split line into 3 strings (stored in array stringBook) using commas.
        String[] stringBook = line.split(",", 3);

        //set values of id, title, and author to values found in line
        id = Integer.parseInt(stringBook[0]); //change id from string to int
        title = stringBook[1];
        author = stringBook[2];

        //add book to the library
        AddBook(id, title, author, library);
    }


    //Opens file and sends stores each line in a string called line.
    //This is then sent to the GetBookFromLine method
    //Takes in library, does not return anything.
    private static void ReadFile(Book[] library) throws IOException {

        //open file
        BufferedReader reader = new BufferedReader(new FileReader("libraryBooks.txt"));

        String line;
        while((line = reader.readLine()) != null)
        {
            GetBookFromLine(line, library);
        }
    }


    //get id, title, and author from user and run AddBook method
    //takes in library, returns nothing
    private static void GetUserBook(Book[] library)
    {
        //declare variables
        int id = -1;
        String title;
        String author;
        //String removeNewLine;

        //Prompt user to enter id, title, and author.
        System.out.println("Adding a book...");
        System.out.println("Please enter the ID, Title, and Author");

        //make sure that ID is available and allow user to try a different ID if it is not.
        boolean available = false;

        while(!available) {
            //get id from user
            System.out.print("ID: ");
            id = scan.nextInt();
            scan.nextLine(); //removes new line character so that title does not scan it.

            available = IdAvailability(id, library);

            if(!available)
                System.out.println("Sorry that ID has already been used. Please try again with a different ID.");
        }

        //get title from user
        System.out.print("Title: ");
        title = scan.nextLine();

        //get author from user
        System.out.print("Author: ");
        author = scan.nextLine();

        //add book using the AddBook method
        AddBook(id, title, author, library);
    }


    //removes a book from the library
    //takes in library, returns nothing
    private static void RemoveBook(Book[] library)
    {
        //check to see if there are any books in library
        //if library has any books in it
        if(HasBooks(library)) //remove a book
        {
            int id;
            int location = -1;

            do
            {            //ask user for ID of book to remove
                System.out.println("Please enter the ID of the book you would like to remove: ");
                id = scan.nextInt();

                //make sure that the id exists

                //find the location of the book in the library
                for (int i = 0; i < library.length; i++) {
                    if (id == library[i].id)
                        location = i;
                }

                //if location is still -1 book with that id must not exist
                if(location == -1)
                    System.out.println("Error, no book matches the ID you entered.");

            } while (location == -1);

            //check whether user would like to remove the given book.
            int yn; //stores 1 for yes and 2 for no
            do {
                //print book
                System.out.print("Are you sure you want to remove ");
                library[location].Print();
                System.out.println("?");

                System.out.println("1. Yes");
                System.out.println("2. No");
                yn = scan.nextInt();

                if (yn == 1) {
                    //remove book using its location
                    //set id to -1 so that it can be overwritten
                    library[location].id = -1;
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
        Book.numBooks--;
    }


    //prints all books in the library
    //takes in library, returns nothing
    private static void PrintBooks(Book[] library)
    {
        //check to see if there are any books in library
        //check to make sure library has books in it
        if(HasBooks(library))
        {
            System.out.println("Books: ");
            //for each book in the library
            for (Book book : library) {
                if (book.id != -1) {
                    book.Print();
                    System.out.print("\n");
                }
            }
        }
        //there are no books in library
        else System.out.println("You currently do not have any books. ");
    }

} //end public class SDevLMS
