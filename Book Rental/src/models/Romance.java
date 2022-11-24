package models;

import utils.Input;

public class Romance extends Book {
    public Romance(){
        initialize();
    }
    @Override
    public void initialize() {
        this.book_title = Input.string("Enter Romance Book Title: ");
        this.total = Input.number("Enter Romance book copies: ");
        this.rank = 3;  
    }
    @Override
    public void print() {
        System.out.println(String.format("Romance: [%s] %s",total, book_title));
    }
}
