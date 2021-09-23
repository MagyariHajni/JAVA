package ro.sci.temaCalculatePrice;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the base price:");
        float basePrice = scanner.nextFloat();
        System.out.println("Please input the VAT %: ");
        float vatPercentage = scanner.nextFloat();

        while (true) {

            if (!(vatPercentage >= 0 || !(vatPercentage <= 100))) {
                System.out.println("Input a valid positive number between 0 and 100");
                vatPercentage = scanner.nextFloat();
            } else {
                break;
            }
        }

        System.out.println("The full price is: " + calculatePrice(basePrice, vatPercentage));
    }

    public static String calculatePrice(float base, float vat) {
        float fullPrice = base + base * (vat / 100);

        return new DecimalFormat("0.00").format(fullPrice);
    }

}
