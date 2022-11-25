package models;

import utils.Input;
public class ScienceFiction extends Book {
    public ScienceFiction() {
        initialize();
    }
    @Override
    public void initialize() {
        this.book_title = Input.string("\n\t\t\tEnter Science Fiction book title: ");
        this.total = Input.number ("\t\t\tEnter Science Fiction book copies: ");
        this.rank = 1;
    }

    @Override
    public void print() {
        System.out.println(String.format("Science Fiction" + "\n\t\t\t\t\tTitle: " + book_title + "\n\t\t\t\t\tCopies: " + total + "\n"));
    }  
}
