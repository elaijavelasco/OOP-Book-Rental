import java.util.*;

//imports packages that contain user-defined classes
import models.*;
import utils.*;

public class Rental{
    //method to display menu
    public void app_menu () {
        println ("\n\n\t\t\t    ****** Book Rental System ******");
        while (true) {
            println ("\n\t\t\t_________________________________________\n");
            println ("\t\t\t\t\tMain Menu\n");
            println ("\t\t\t\t (1) View available books");
            println ("\t\t\t\t (2) Add book");
            println ("\t\t\t\t (3) Rent books");
            println ("\t\t\t\t (4) Display rented books");
            println ("\t\t\t\t (5) Quit Application");
            println ("\n\t\t\t_________________________________________\n");
            input_choice();
        }
    } //end of method app_menu()
    
    //method to get choice
    private void input_choice() {
        while(true) {
            String choice;
            try {
            //input choice
                choice = Input.string("\t\t\tWhat do you want to do? ");
                int i = Integer.parseInt (choice); //returns integer
                if(i < 1 || i > 5) {
                    throw new ChoiceException();
                }
                execute_choice(i); 
                break;
            }
            //handle input errors
            catch(NumberFormatException e){
                println("\n\t\t\tInvalid entry! Input must be a number.\n");
            }
            catch(ChoiceException c){
                println("\n\t\t\tInvalid entry! Enter a choice from 1 to 5.\n");
            }
        }
    } //end of method input_choice()

    //method to execute choice 1,2,3,4, or 5
    private void execute_choice (int option) {
        switch (option) {
            case DISPLAY_BOOKS:
                display_books("");
            break;

            case ADD_BOOKS:
                add_books();
            break;

            case RENT_BOOKS:
                rent_books();
            break;

            case VIEW_RENTED_BOOKS:
                view_rented_books();
            break;

            case QUIT:
                quit_app();
            break;
        }
    } //end of method execute_choice()

    //constant variables
    private static final int DISPLAY_BOOKS = 1;
    private static final int ADD_BOOKS = 2;
    private static final int RENT_BOOKS = 3;
    private static final int VIEW_RENTED_BOOKS = 4;
    private static final int QUIT = 5;

    //creates arraylist named books 
    ArrayList<Book> books = new ArrayList<>();

    //method to display books
    private void display_books (String extra){
        if (books.isEmpty()) {
            println("\n\t\t\t No available books yet...");
            return;
        }
        //sorts books arraylist 
        Collections.sort(books);
        println("\n\t\t\t\t\t***Book List***\n" + extra);
        for (int i = 0; i < books.size(); i++) {
            print("\t\t\t\t (" + (i + 1) + ") ");
            books.get(i).print();
        }
    }

    //method to add books
    private void add_books() {
        switch(select_book()) {

            case SCIENCE_FICTION:
                books.add(new ScienceFiction());
            break;

            case THRILLER:
                books.add(new Thriller());
            break;

            case FANTASY:
                books.add(new Fantasy());
            break;

            case ROMANCE:
                books.add(new Romance());
            break;

            case SELF_HELP:
                books.add(new SelfHelp());
            break;
        }
        println("\n\t\t\tBooks successfully added!\n");
    } // end of method add_books()

    //constant variables
    private static final int SCIENCE_FICTION = 1;
    private static final int THRILLER = 2;
    private static final int FANTASY = 3;
    private static final int ROMANCE = 4;
    private static final int SELF_HELP = 5;

    //method to select book
    private int select_book() {
        //select book menu
        println("\n\t\t\t\t\t***Add Book***\n");
        println("\t\t\t\t (1) Science Fiction");
        println("\t\t\t\t (2) Thriller");
        println("\t\t\t\t (3) Fantasy");
        println("\t\t\t\t (4) Romance");
        println("\t\t\t\t (5) Self-Help");
        int choice = 0;
        while (true) {
            String input;
            try {
                //input choice from select book menu
                input = Input.string("\n\t\t\tEnter choice: ");
                choice = Integer.parseInt(input);
                if (choice < 1 || choice > 5) {
                    throw new ChoiceException();
                }
                break;
            }
            //handle input errors
            catch(ChoiceException c) {
                print ("\n\t\t\tInvalid entry! Enter a choice from 1 to 5.\n");
            }
        }
        return choice;
    } //end of method select_book()

    //creates arraylist named rent
    ArrayList<Rent> rent = new ArrayList<>();

    //method to rent book
    private void rent_books() {
        if (books.isEmpty()) {
            println ("\n\t\t\t [!] No books available for rent.\n");
            return;
        }

        //prompt user to input book number
        display_books("\n\t\t\tSelect book you want to rent: \n");
        int num = Input.number ("\n\t\t\tEnter book number: ")-1;
        if (num >= books.size() || num < 0) {
            println("\n\t\t\tInvalid input!");
            return;
        }

        //prompt user to input book quantity
        Book bk = books.get(num);
        int quantity = Input.number("\n\t\t\tQuantity of book you want to rent: ");

        //condition where user can't rent zero books
        if (quantity == 0) {
            println("\n\t\t\tYou're not able to rent 0 books!");
            return;
        }
        //condition where user can't rent more than the total number of books
        if (quantity > bk.total) {
            println("\n\t\t\tYou're not able to rent " + quantity + " books! ");
            return;
        }
        else {
            bk.total -= quantity;
            books.set(num, bk);
            println("\n\t\t\tYou have successfully rented " + quantity + " books!");
            rent.add(new Rent(bk.book_title, quantity));
        }
    } //end of method rent_books()

    //method to display rented books
    public void view_rented_books() {
        if (rent.isEmpty()) {
            println("\n\t\t\tYou have not rented any books yet...");
            return;
        }
        println("\n\t\t\t\t   ***Rented Books***\n");
        for (int i = 0; i < rent.size(); i++) {
            print("\t\t\t\t (" + (i + 1) + ") ");
            rent.get(i).print();
        }
    } //end of method view_rented_books()

    //method to quit application
    public void quit_app() {
        println("\n\n\t\t\t***Thank you for using the application!***\n\n");
        System.exit(0);
    }
    private void print(String message) {
        System.out.print(message);
    }
    private void println(String message){
        System.out.println(message);
    }
} //end 