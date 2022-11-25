package models;

import utils.Input;

public class Thriller extends Book {
    public Thriller() {
        initialize();
    }
    @Override
    public void initialize() {
        this.book_title = Input.string("\n\t\t\tEnter Thriller book title: ");
        this.total = Input.number("\t\t\tEnter Thriller book copies: ");
        this.rank = 2;
    }
    @Override
    public void print() {
        System.out.println(String.format("Thriller" + "\n\t\t\t\t\tTitle: " + book_title + "\n\t\t\t\t\tCopies: " + total + "\n"));
    }
}
