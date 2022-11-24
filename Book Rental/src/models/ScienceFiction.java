package models;

import utils.Input;
public class ScienceFiction extends Book {
    public ScienceFiction() {
        initialize();
    }
    @Override
    public void initialize() {
        this.book_title = Input.string("Enter Sci-fi Book Title: ");
        this.total = Input.number ("Enter Sci-fi book copies: ");
        this.rank = 1;
    }

    @Override
    public void print() {
        System.out.println(String.format("Sci-fi: [%s] %s",total, book_title));
    }  
}
