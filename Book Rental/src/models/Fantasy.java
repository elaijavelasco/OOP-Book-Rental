package models;

import utils.Input;

public class Fantasy extends Book {
    public Fantasy(){
        initialize();
    }
    @Override
    public void initialize() {
        this.book_title = Input.string("\n\t\t\tEnter Fantasy book title: ");
        this.total = Input.number("\t\t\tEnter Fantasy book copies: ");
        this.rank = 3;  
    }
    @Override
    public void print() {
        System.out.println(String.format("Fantasy" + "\n\t\t\t\t\tTitle: " + book_title + "\n\t\t\t\t\tCopies: " + total + "\n"));
    }
}
