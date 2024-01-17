//Nathan Perez
//Library Management Software for Software Development 1 Module 2
//Create a basic LMS using SDLC created in Part I

import java.util.Scanner; //import scanner class

public class SDevLMS
{
    void AddBook(int id, String title, String author)
    {

    }
    void GetUserBooks()
    {

    }

    void GetUserBook()
    {

    }

    void RemoveBook()
    {

    }



    void

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Library Management Software!");
        //while loop for select and performing functions
        while(true)
        {
            //user options
            System.out.println("Please select an option from the ones below by entering the corresponding number.");
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
                //add book function
                System.out.println("this is a test");
            }
            else if(choice == 3) //remove
            {
                //remove book function
                System.out.println("this is a test");
            }
            else if(choice == 4) //print
            {
                //print book function
                System.out.println("this is a test");
            }
            else
            {
                System.out.println(choice + " is not an valid option. Please try again.");
            }

        } //end while loop for running program

    } //end main
} //end public class SDevLMS
