import java.util.*;

import models.*;
import utils.*;

public class Rental{
    public void open_shop () {
        System.out.println ("Book Rental System");
        while (true) {
            System.out.println("Book Rental Menu");
            System.out.println ("1 - View available books");
            System.out.println ("2 - Add book");
            System.out.println ("3 - Rent books");
            System.out.println ("4 - Display rented books");
            System.out.println ("5 - Close");
            input_choice();
        }
    }
    private void input_choice() {
        while(true) {
            String choice;
            try {
                choice = Input.string("What do you want to do? ");
                int i = Integer.parseInt (choice);
                if(i < 1 || i < 5) {
                    throw new ChoiceException();
                }
                execute_choice(i);
                break;
            }
            catch(NumberFormatException e){
                System.out.println("Invalid entry! Input must be a number.");
            }
            catch(ChoiceException c){
                System.out.println("Invalid entry! Enter a choice from 1 to 5.");
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
            System.out.println("No available books to be rented.");
            return;
        }
        Collections.sort(books);
        System.out.println("Available Books" + extra);
        for (int i = 0; i < books.size(); i++) {
            System.out.println ((i + 1) + ".) ");
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
        System.out.println("Successfully added!");
    }
    private int select_book() {
        System.out.println("Select a book genre to add.");
        System.out.println("1 - Science Fiction");
        System.out.println("2 - Thriller");
        System.out.println("1 - Fantasy");
        System.out.println("1 - Poetry");
        System.out.println("1 - Romance");
        System.out.println("1 - Self-Help");
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
                System.out.print ("Invalid entry! Enter a choice from 1 to 5.");
            }
        }
        return choice;
    }
    private void rent_books() {
        if (books.isEmpty()) {
            System.out.print ("No books available for rent.");
            return;
        }
        display_books("Select book to rent");
        int num = Input.number ("Enter book number: ")-1;
        if (num >= books.size() || num < 0) {
            System.out.println("Invalid input!");
            return;
        }
        Book bk = books.get(num);
        int quantity = Input.number("Enter the quantity of books to be rented: ");
        if (quantity == 0) {
            System.out.println("You're not able to rent 0 books");
            return;
        }
        if (quantity > bk.total) {
            System.out.println("You're not able to rent " + quantity + " books. ");
            return;
        }
        else {
            bk.total -= quantity;
            books.set(num, bk);
            System.out.println("You have successfully rented " + quantity + "books!");
            rent.add(new Rent(bk.book_title, quantity));
        }
    }
    public void view_rented_books() {
        if (rent.isEmpty()) {
            System.out.println("You have not rented any books yet.");
            return;
        }
        System.out.println("Rented Books");
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