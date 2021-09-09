package ro.sci;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        boolean goodValue = false;
        double height = 0;
        double weight = 0;

        while (!goodValue) {
            System.out.print("Please enter your height in m: ");
            height = scanner.nextDouble();

            if (height <= 0) {
                System.out.println("Please enter a valid height value");
            } else {
                goodValue = true;
            }
        }

        goodValue = false;

        while (!goodValue) {
            System.out.print("Please enter your weight in kg: ");
            weight = scanner.nextDouble();

            if (weight <= 0) {
                System.out.println("Please enter a valid weight value");
            } else {
                goodValue = true;
            }
        }

        double bodyMassIndex = weight / height / height;
        System.out.println("Your BMI is: " + new DecimalFormat("##.##").format(bodyMassIndex));

        String indexcategory = "";

        if (bodyMassIndex <= 18.49) {
            indexcategory = "underweight";
        } else {
            int formattedBmi = (int) (bodyMassIndex - 20) / 5;

            switch (formattedBmi) {
                case 0:
                    indexcategory = "normal weight";
                    break;
                case 1:
                    indexcategory = "overweight";
                    break;
                case 2:
                    indexcategory = "class 1 (moderately) obese";
                    break;
                case 3:
                    indexcategory = "class 2 (severely) obese";
                    break;
                default:
                    indexcategory = "class 3 (morbidly) obese";
            }

        }

        System.out.println("According to the generic BMI table you are: " + indexcategory);

    }
}

