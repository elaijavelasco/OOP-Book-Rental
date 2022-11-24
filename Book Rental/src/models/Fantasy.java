package models;

import utils.Input;

public class Fantasy extends Book {
    public Fantasy(){
        initialize();
    }
    @Override
    public void initialize() {
        this.book_title = Input.string("Enter Fantasy Book Title: ");
        this.total = Input.number("Enter Fantasy book copies: ");
        this.rank = 3;  
    }
    @Override
    public void print() {
        System.out.println(String.format("Fantasy: [%s] %s",total, book_title));
    }
}
