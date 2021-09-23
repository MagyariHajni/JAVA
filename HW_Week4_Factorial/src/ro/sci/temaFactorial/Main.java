package ro.sci.temaFactorial;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        while (true) {
            factorialProduct();
            System.out.println("***********************************************************************");
            System.out.println("Want to check another number? y/n -n stands for anything else but y :)-");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    public static void factorialProduct() {
        Scanner scanner = new Scanner(System.in);
        int n;

        while (true) {
            System.out.println("How many numbers will we be putting in a sequence?");
            n = scanner.nextInt();
            if (n < 0) {
                System.out.println("Please input a valid positive number :)");
            } else {
                break;
            }
        }

        if (n == 0) {
            System.out.println("The number of ways we can put nothing in order: " + 1);
        } else if (n <= 5) {
           productTypeByte(n);
        } else if (n <= 7) {
           productTypeShort(n);
        } else if (n < 12) {
          productTypeInt(n);
        } else if (n <= 20) {
           productTypeLong(n);
        } else {
            System.out.println("The task is too great for primitives :), choose a positive number <=20");
        }
    }

    public static void productTypeByte(int number) {
        byte factorialProduct = 1;
        for (int i = 1; i <= number; i++) {
            factorialProduct = (byte) (factorialProduct * i);
        }
        System.out.println("The number of ways we can put " + number + " numbers in order (factorial of " + number + ") is: " + factorialProduct);
    }

    public static void productTypeShort(int number) {
        short factorialProduct = 1;
        for (int i = 1; i <= number; i++) {
            factorialProduct = (short) (factorialProduct * i);
        }
        System.out.println("The number of ways we can put " + number + " numbers in order (factorial of " + number + ") is: " + factorialProduct);
    }

    public static void productTypeInt(int number) {
        int factorialProduct = 1;
        for (int i = 1; i <= number; i++) {
            factorialProduct = (factorialProduct * i);
        }
        System.out.println("The number of ways we can put " + number + " numbers in order (factorial of " + number + ") is: " + factorialProduct);
    }

    public static void productTypeLong(int number) {
        long factorialProduct = 1;
        for (int i = 1; i <= number; i++) {
            factorialProduct = (factorialProduct * i);
        }
        System.out.println("The number of ways we can put " + number + " numbers in order (factorial of " + number + ") is: " + factorialProduct);
    }

}
