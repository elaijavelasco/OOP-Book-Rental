//driver code
public class App {
    //Public means that the class can be accessed by any other class in any package 
    //Main is a method of the class
    //Static means it is defined as a member of the class rather than a member of an instance of the class.
    //Void means it returns nothing

    public static void main (String args[]) throws Exception {
        Rental rental = new Rental();
        rental.app_menu();
    }  
}
