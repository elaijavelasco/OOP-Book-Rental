import java.util.*;

import models.*;
import utils.*;

public class Rental{
    public void open_shop () {
        println ("\n\n\t\t\t    ****** Book Rental System ******");
        while (true) {
            println ("\n\t\t\t_________________________________________\n");
            println ("\t\t\t\t\tMain Menu\n");
            println ("\t\t\t\t (1) View available books");
            println ("\t\t\t\t (2) Add book");
            println ("\t\t\t\t (3) Rent books");
            println ("\t\t\t\t (4) Display rented books");
            println ("\t\t\t\t (5) Close");
            println ("\n\t\t\t_________________________________________\n");
            input_choice();
        }
    }
    private void input_choice() {
        while(true) {
            String choice;
            try {
                choice = Input.string("\t\t\tWhat do you want to do? ");
                int i = Integer.parseInt (choice);
                if(i < 1 || i > 5) {
                    throw new ChoiceException();
                }
                execute_choice(i);
                break;
            }
            catch(NumberFormatException e){
                println("\n\t\t\tInvalid entry! Input must be a number.\n");
            }
            catch(ChoiceException c){
                println("\n\t\t\tInvalid entry! Enter a choice from 1 to 5.\n");
            }
        }
    }

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

            case CLOSE_SHOP:
            println("\n\n\t\t\t***Thank you for using the application!***\n\n");
            System.exit(0);
            break;
        }
    }
    private void display_books (String extra){
        if (books.isEmpty()) {
            println("\n\t\t\t No available books yet...");
            return;
        }
        Collections.sort(books);
        println("\n\t\t\t\t\t***Book List***\n" + extra);
        for (int i = 0; i < books.size(); i++) {
            print("\t\t\t\t (" + (i + 1) + ") ");
            books.get(i).print();
        }
    }
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
    }
    private int select_book() {
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
                input = Input.string("\n\t\t\tEnter choice: ");
                choice = Integer.parseInt(input);
                if (choice < 1 || choice > 5) {
                    throw new ChoiceException();
                }
                break;
            }
            catch(ChoiceException c) {
                print ("\n\t\t\tInvalid entry! Enter a choice from 1 to 5.\n");
            }
        }
        return choice;
    }
    private void rent_books() {
        if (books.isEmpty()) {
            println ("\n\t\t\t [!] No books available for rent.\n");
            return;
        }
        display_books("\n\t\t\tSelect book you want to rent: \n");
        int num = Input.number ("\n\t\t\tEnter book number: ")-1;
        if (num >= books.size() || num < 0) {
            println("\n\t\t\tInvalid input!");
            return;
        }
        Book bk = books.get(num);
        int quantity = Input.number("\n\t\t\tQuantity of book you want to rent: ");
        if (quantity == 0) {
            println("\n\t\t\tYou're not able to rent 0 books!");
            return;
        }
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
    }
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
    }
    public void close_shop() {
        System.exit(0);
    }
    private void print(String message) {
        System.out.print(message);
    }
    private void println(String message){
        System.out.println(message);
    }

    private static final int DISPLAY_BOOKS = 1;
    private static final int ADD_BOOKS = 2;
    private static final int RENT_BOOKS = 3;
    private static final int VIEW_RENTED_BOOKS = 4;
    private static final int CLOSE_SHOP = 5;

    private static final int SCIENCE_FICTION = 1;
    private static final int THRILLER = 2;
    private static final int FANTASY = 3;
    private static final int ROMANCE = 4;
    private static final int SELF_HELP = 5;

    ArrayList<Rent> rent = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
}