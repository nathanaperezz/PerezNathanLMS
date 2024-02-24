Module 2 SDLC (LMS)
Nathan Perez
Software Development I CEN-3024C-24667
15 Jan 2024

-------------------- Define Requirements: --------------------

Users:
The Library Management Software (LMS) will be used by the librarian and library users. It must
be simple and easy for them to use. Error messages must tell the user what the issue is and how
to solve it.

Tasks:
The LMS will allow for
▪ Adding new books to the collection from a text file
▪ Adding new books to the collection through user input.
▪ Removing a book from the collection using only its ID number.
▪ Printing a list of all books currently in the collection.

Constraints:
Each book must have a unique ID number, title, and author. Which will follow this formatting.

1,To Kill a Mockingbird,Harper Lee
2,1984,George Orwell
3,The Great Gatsby,F. Scott Fitzgerald
Note that there are commas but no spaces between the id, title, and author.

-------------------- Gather Requirements: --------------------

The user should be able to use the program to store and delete books with no prior knowledge of
Java or the workings of the LMS. It must be straightforward and easy to use. Users can choose
from a set of options including adding, deleting, and printing. The options will be numbered and
tell the user to enter a number. All errors will print a detailed description so that the user can
understand what is wrong. The user will then have a chance to retry without having to quit the
program.
When adding a book (through user input) the user would like the ability to add the id, title, and
author in separate spaces to avoid making a mistake (for example, using the wrong order or
forgetting a comma). They would like it to look similar to this:
I have used red to represent user input.

Please enter the id, title and author
ID: 1234
Title: IT
Author: Stephen King
1234,IT,Stephen King - has been saved into your catalog.

-------------------- Implementation Plan: --------------------
There will only need to be one class which will be called ‘Book’. Each book will have three
attributes which will be id, title, and author. The book class will have a method that takes no
parameters and prints the book.
All books will be stored in an array of books which will be named ‘Library’.
The entire program will be a while loop allowing the user to keep adding, deleting, and printing
until they type –1 to quit. Upon quitting all books will be printed.
A static integer numBooks will store the number of books in our library inside of the Book class.
numBooks will be initialized at 0.

The following methods will be included:

AddBook(id, title, author, library)
▪ Make sure matching id does not already exist.
▪ Create new book and stores the parameters.
▪ Add the book the Library.
▪ Add one to the number of books.

AddFileBook(library)
▪ Read input from text file.
▪ For each book in the file:
o Stores id, title, and author in variables.
o Calls the AddBook method

AddUserBook(library)
▪ Prompts and scans for user input.
▪ Stores input in variables
▪ Calls AddBook method

DeleteBook(library)
▪ Get id from user.
▪ Search library array for id. If id does not exist, print error message.
▪ Remove the book by setting it to null.
▪ Subtract 1 from number of books.

PrintLibrary(library)
▪ Run a for-loop to print all books using their print method in the book class.

-------------------- Testing Plan: --------------------

Before testing I will check and fix any flags/errors that IntelliJ shows. I will make sure that all
code has sufficient commenting and space making it as easy to understand as possible.
I will start my testing with simple tasks. My first tests will include opening and quitting the
program as well as performing each method.
I will create a text file with many books to see how my program runs with higher volume. I plan
to use ChatGPT to generate as many random books as possible which I can copy and paste into
my text file.
Once every normal use works perfectly, I will begin more difficult tests. I will try to break the
program by entering numbers that don’t correspond to an option, typing incomplete books,
attempting to delete non-existing books and attempting to create duplicate books.
