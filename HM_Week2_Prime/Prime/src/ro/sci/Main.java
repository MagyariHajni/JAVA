package ro.sci;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        boolean checkNumber = true;

        while (checkNumber) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("What number will we be checking?");
            int number = scanner.nextInt();

            if (number == 0 || number == 1) {
                System.out.println(number + " is a special number, but according to the Fundamental Theorem of Arithmetic \n(every integer can be written uniquely as a product of prime numbers)\nit cannot be considered a prime.");
            } else {

                int numberHalf = number / 2;
                boolean isPrime = true;
                int i = 2;

                while (isPrime && i <= numberHalf) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                    i++;
                }

                String result = (isPrime) ? "a prime" : "not a prime";

                System.out.println(number + " is " + result + " number");

            }
            System.out.println("************************************************************************");
            System.out.println("Want to check another number? y/n -n stands for anything else but y :)-");
            String answer = scanner.next();
//            checkNumber = (answer.equals("y")) ? true : false;
            checkNumber = answer.equals("y");

        }
    }
}
