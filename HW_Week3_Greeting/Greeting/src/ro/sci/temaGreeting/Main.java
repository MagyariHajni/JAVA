package ro.sci.temaGreeting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Who will we be greeting today?");
        Scanner scanner = new Scanner(System.in);
        String name= scanner.nextLine();

        if (!name.equals("")) {
            System.out.println("Hello, "+name+"!");
        }else {
            System.out.println("Hello, stranger.");
        }
    }
}
