package models;

import utils.Input;

public class Romance extends Book {
    public Romance(){
        initialize();
    }
    @Override
    public void initialize() {
        this.book_title = Input.string("\n\t\t\tEnter Romance book title: ");
        this.total = Input.number("\t\t\tEnter Romance book copies: ");
        this.rank = 3;  
    }
    @Override
    public void print() {
        System.out.println(String.format("Romance" + "\n\t\t\t\t\tTitle: " + book_title + "\n\t\t\t\t\tCopies: " + total + "\n"));
    }
}
