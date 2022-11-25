package models;

public class Rent {
    public Rent (String book_title, int quantity) {
        this.book_title = book_title;
        this.quantity = quantity;
    }
    private String book_title;
    private int quantity;

    public void print() {
        System.out.println(book_title + ", " + quantity + " copies");
    }
}
