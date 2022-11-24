import java.util.*;

import models.*;
import utils.*;

public class Book {
    public void open_shop () {
        System.out.println ("Book Rental System");
        while (true) {
            System.out.println("Book Rental Menu")
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

            case RENTED_BOOKS:
                rented_books();
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
        System.out.println("Select a book genre to add.");
        switch(select_book()) {
            case FICTION:
                books.add(new Fiction());
            break:

            case SCIENCE_FICTION:
                books.add(new ScienceFiction());
            break;

            case THRILLER
        }
    }
}