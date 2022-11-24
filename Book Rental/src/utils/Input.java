package utils;

import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);
    public static String string(String message){
        System.out.print(message);
        return sc.nextLine();
    }
    
    public static int number(String message){
        System.out.print(message);
        while(true){
            String input = sc.nextLine();
            try{
                return Integer.parseInt(input);
            }catch(NumberFormatException e){
                System.out.print("Enter a valid number: ");
            }
        }
    }

    public static void close(){
        sc.close();
    }
}
