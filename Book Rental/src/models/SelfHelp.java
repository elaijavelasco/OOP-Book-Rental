package models;

import utils.Input;

public class SelfHelp extends Book {
    public SelfHelp(){
        initialize();
    }
    @Override
    public void initialize() {
        this.book_title = Input.string("\n\t\t\tEnter Self-help book title: ");
        this.total = Input.number("\t\t\tEnter Self-help book copies: ");
        this.rank = 3;  
    }
    @Override
    public void print() {
        System.out.println(String.format("Self-help" + "\n\t\t\t\t\tTitle: " + book_title + "\n\t\t\t\t\tCopies: " + total + "\n"));
    }
}
