package models;

import utils.Input;

public class SelfHelp extends Book {
    public SelfHelp(){
        initialize();
    }
    @Override
    public void initialize() {
        this.book_title = Input.string("Enter Self-help Book Title: ");
        this.total = Input.number("Enter Self-help book copies: ");
        this.rank = 3;  
    }
    @Override
    public void print() {
        System.out.println(String.format("Self-help: [%s] %s",total, book_title));
    }
}
