import java.util.*;

import models.*;
import utils.*;

public class Rental{
    public void open_shop () {
        println ("\n\n\n\t\t\t    ****** Book Rental System ******");
        while (true) {
            println("\n\t\t\t_________________________________________\n");
            println ("\t\t\t\t\tMain Menu\n");
            println ("\t\t\t\t (1) View available books");
            println ("\t\t\t\t (2) Add book");
            println ("\t\t\t\t (3) Rent books");
            println ("\t\t\t\t (4) Display rented books");
            println ("\t\t\t\t (5) Close");
            println("\n\t\t\t_________________________________________\n");
            input_choice();
        }
    }
    private void input_choice() {
        while(true) {
            String choice;
            try {
                choice = Input.string("\t\t\t\tWhat do you want to do? ");
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
                println("\n\t\t\tInvalid entry! Enter a choice from 1 to 5.");
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
            System.exit(0);
            break;
        }
    }
    private void display_books (String extra){
        if (books.isEmpty()) {
            println("\n\t\t\t [!] No books available for rent.\n");
            return;
        }
        Collections.sort(books);
        println("\n\t\tAvailable Books" + extra);
        for (int i = 0; i < books.size(); i++) {
            println ((i + 1) + ".) ");
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
        println("\n\t\t\t [1] Books successfully added.\n");
    }
    private int select_book() {
        println("\n\t\tAdd Book:\n");
        println("\t\t\t1 - Science Fiction");
        println("\t\t\t2 - Thriller");
        println("\t\t\t3 - Fantasy");
        println("\t\t\t4 - Romance");
        println("\t\t\t5 - Self-Help");
        int choice = 0;
        while (true) {
            String input;
            try {
                input = Input.string("\n\t\tEnter choice: ");
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
        display_books("\nRent Book\n");
        int num = Input.number ("Enter book number: ")-1;
        if (num >= books.size() || num < 0) {
            println("Invalid input!");
            return;
        }
        Book bk = books.get(num);
        int quantity = Input.number("Enter the quantity of books to be rented: ");
        if (quantity == 0) {
            println("\t\tYou're not able to rent 0 books");
            return;
        }
        if (quantity > bk.total) {
            println("\t\tYou're not able to rent " + quantity + " books. ");
            return;
        }
        else {
            bk.total -= quantity;
            books.set(num, bk);
            println("\t\tYou have successfully rented " + quantity + " books!");
            rent.add(new Rent(bk.book_title, quantity));
        }
    }
    public void view_rented_books() {
        if (rent.isEmpty()) {
            println("\n\t\tYou have not rented any books yet.");
            return;
        }
        println("Rented Books");
        for (int i = 0; i < rent.size(); i++) {
            print((i + 1) + ".)");
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
