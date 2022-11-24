package models;

import utils.Input;

public class Poetry extends Book {
    public Poetry(){
        initialize();
    }
    @Override
    public void initialize() {
        this.book_title = Input.string("Enter Poetry Book Title: ");
        this.total = Input.number("Enter Poetry book copies: ");
        this.rank = 4;  
    }
    @Override
    public void print() {
        System.out.println(String.format("Poetry: [%s] %s",total, book_title));
    }
}
