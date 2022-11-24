package models;

import utils.Input;

public class Thriller extends Book {
    public Thriller() {
        initialize();
    }
    @Override
    public void initialize() {
        this.book_title = Input.string("Enter Thriller Book Title: ");
        this.total = Input.number("Enter Thriller book copies: ");
        this.rank = 2;
    }
    @Override
    public void print() {
        System.out.println(String.format("Thriller: [%s} %s",total, book_title));
    }
}
