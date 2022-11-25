import java.util.*;

import models.*;
import utils.*;

public class Rental{
    public void open_shop () {
        println ("Book Rental System");
        while (true) {
            println ("Book Rental Menu");
            println ("1 - View available books");
            println ("2 - Add book");
            println ("3 - Rent books");
            println ("4 - Display rented books");
            println ("5 - Close");
            input_choice();
        }
    }
    private void input_choice() {
        while(true) {
            String choice;
            try {
                choice = Input.string("What do you want to do? ");
                int i = Integer.parseInt (choice);
                if(i < 1 || i > 5) {
                    throw new ChoiceException();
                }
                execute_choice(i);
                break;
            }
            catch(NumberFormatException e){
                println("Invalid entry! Input must be a number.");
            }
            catch(ChoiceException c){
                println("Invalid entry! Choice should be from the ff: [1,2,3,4,5].");
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
            println("No available books to be rented.");
            return;
        }
        Collections.sort(books);
        println("Available Books" + extra);
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

            case POETRY:
                books.add(new Poetry());
            break;

            case ROMANCE:
                books.add(new Romance());
            break;

            case SELF_HELP:
                books.add(new SelfHelp());
            break;
        }
        println("Successfully added!");
    }
    private int select_book() {
        println("Select a book genre to add.");
        println("1 - Science Fiction");
        println("2 - Thriller");
        println("1 - Fantasy");
        println("1 - Poetry");
        println("1 - Romance");
        println("1 - Self-Help");
        int choice = 0;
        while (true) {
            String input;
            try {
                input = Input.string("Enter choice: ");
                choice = Integer.parseInt(input);
                if (choice < 1 || choice > 4) {
                    throw new ChoiceException();
                }
                break;
            }
            catch(ChoiceException c) {
                print ("Invalid entry! Enter a choice from 1 to 5.");
            }
        }
        return choice;
    }
    private void rent_books() {
        if (books.isEmpty()) {
            println ("No books available for rent.");
            return;
        }
        display_books("Select book to rent");
        int num = Input.number ("Enter book number: ")-1;
        if (num >= books.size() || num < 0) {
            println("Invalid input!");
            return;
        }
        Book bk = books.get(num);
        int quantity = Input.number("Enter the quantity of books to be rented: ");
        if (quantity == 0) {
            println("You're not able to rent 0 books");
            return;
        }
        if (quantity > bk.total) {
            println("You're not able to rent " + quantity + " books. ");
            return;
        }
        else {
            bk.total -= quantity;
            books.set(num, bk);
            println("You have successfully rented " + quantity + "books!");
            rent.add(new Rent(bk.book_title, quantity));
        }
    }
    public void view_rented_books() {
        if (rent.isEmpty()) {
            println("You have not rented any books yet.");
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
    private static final int POETRY = 4;
    private static final int ROMANCE = 5;
    private static final int SELF_HELP = 6;

    ArrayList<Rent> rent = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
}
