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

        } //end while loop for running program

    } //end main

    //checks to see if there are any books in the library array, if yes return true
    private static boolean HasBooks(Book[] library)
    {
        for(int i = 0; i < library.length; i++)
        {
            //if there are any books return true
            if(library[i].id != -1)
                return true;
        }
        //if it gets to this point there are no books in the array
        return false;
    }

    //Adds the book to the first opening in the library
    private static void AddBook(int id, String title, String author, Book[] library)
    {
        int openSpace = -1;

        //for loop that goes through library until it gets to an opening
        //checks for opening at the beginning first
        for(int i = 0; i < (Book.numBooks +1); i++)
        {
            if(library[i].id == -1)
            {
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
    private static void GetFileBooks(Book[] library)
    {

    }

    //get id, title, and author from user and run AddBook method
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

        //get id from user
        System.out.print("ID: ");
        id = scan.nextInt();
        removeNewLine = scan.nextLine(); //removes new line character so that title does not scan it.

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
    private static void RemoveBook(Book[] library)
    {
        //check to see if there are any books in library
        if(HasBooks(library) == true) //remove a book
        {
            int id = -1;
            int location = -1;

            //ask user for ID of book to remove
            System.out.println("Please enter the ID of the book you would like to remove: ");
            id = scan.nextInt();

            //find the location of the book in the library
            for(int i = 0; i < library.length; i++)
            {
                if(id == library[i].id)
                    location = i;
            }

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
            } while (yn != 1 || yn != 2);

        }
        //there are no books in library
        else System.out.println("You currently do not have any books. ");
    }

    //prints all books in the library
    private static void PrintBooks(Book[] library)
    {
        //check to see if there are any books in library
        if(HasBooks(library) == true)
        {
            System.out.println("Books: ");
            //for each book in the library
            for (int i = 0; i < library.length; i++)
            {
                if(library[i].id != -1)
                {
                    library[i].Print();
                    System.out.print("\n");
                }
            }
        }
        //there are no books in library
        else System.out.println("You currently do not have any books. ");
    }

} //end public class SDevLMS
