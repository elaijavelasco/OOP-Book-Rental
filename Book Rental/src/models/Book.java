package models;

public abstract class Book implements Comparable<Book>{
    protected String size;
    protected int rank;
    public String book_title;
    public int total;

    public abstract void initialize();
    public abstract void print();

    @Override
    public int compareTo (Book bk) {
        if (this.rank > bk.rank) {
            return 1;
        }
        else if(this.rank < bk.rank) {
            return -1;
        }
        return 0;
    }
}
