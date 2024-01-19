//Nathan Perez
//Library Management Software for Software Development 1 Module 2
//Create a basic LMS using SDLC created in Part I

import java.util.Scanner; //import scanner class

public class SDevLMS
{
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {


        //create Library (array of books)
        Book[] library = new Book[100];

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

            int choice = scan.nextInt();

            //get user choice
            if(choice == -1) //quit
                break;
            else if(choice == 1) //file add
            {
                //file add function
                System.out.println("this is a test");
            }
            else if(choice == 2) //add
            {
                //GetUserBook method (which calls AddBook method
                GetUserBook(library);
            }
            else if(choice == 3) //remove
            {
                //remove book function
                System.out.println("this is a test");
            }
            else if(choice == 4) //print
            {
                //print book function
                PrintBooks(library);
            }
            else
            {
                System.out.println(choice + " is not an valid option. Please try again.");
            }

        } //end while loop for running program

    } //end main

    private static void AddBook(int id, String title, String author, Book[] library)
    {

    }
    private static void GetFileBooks(Book[] library)
    {

    }

    private static void GetUserBook(Book[] library)
    {
        //declare variables
        int id = -1;
        String title;
        String author;
        String removeNewLine;

        //Prompt user to enter id, title, and author.
        System.out.println("Adding a book...");
        System.out.println("Please enter the ID, Title, and Author");

        System.out.print("ID: ");
        id = scan.nextInt();
        removeNewLine = scan.nextLine(); //removes new line character so that title does not scan it.

        System.out.print("Title: ");
        title = scan.nextLine();

        System.out.print("Author: ");
        author = scan.nextLine();

        System.out.println(id + "," + title + "," + author + " has been saved to your library.");

        //AddBook(id, title, author, library);
    }

    private static void RemoveBook(Book[] library)
    {

    }

    //prints all books in the library
    private static void PrintBooks(Book[] library)
    {
        if(Book.numBooks > 0) {
            System.out.println("Books: ");
            //for each book in the library
            for (int i = 0; i < Book.numBooks; i++) {
                library[i].Print();
            }
        }
        else
            System.out.println("You currently do not have any books. ");
    }

} //end public class SDevLMS
