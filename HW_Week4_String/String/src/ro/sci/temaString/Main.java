package ro.sci.temaString;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

//        One way :)


//        String[] myString = {"every", "day", "sends", "future", "to", "past"};
//        String bigString = "";
//
//        for (String s : myString) {
//            bigString = bigString + s + " ";
//        }
//
//        System.out.println("Usual way to say:");
//        System.out.println(capitalize(bigString)+"\n");
//
//        Collections.shuffle(Arrays.asList(myString));
//
//        bigString = "";
//
//        for (String s : myString) {
//            bigString = bigString + s + " ";
//        }
//
//        System.out.println("Yoda way to say:");
//        System.out.println(capitalize(bigString));



//        Another way :)


        String[] myString = {"every", "day", "sends", "future", "to", "past"};
        StringBuilder bigString = new StringBuilder();

        for (String s : myString) {
            bigString.append(s).append(" ");
        }

        System.out.println("Usual way to say:");
        System.out.println(capitalize(bigString.toString()) + "\n");

        Collections.shuffle(Arrays.asList(myString));

        bigString.setLength(0);

        for (String s : myString) {
            bigString.append(s).append(" ");
        }

        System.out.println("Yoda way to say:");
        System.out.println(capitalize(bigString.toString()));

    }

    public static String capitalize(String stringCapitalized) {
        stringCapitalized = stringCapitalized.substring(0, 1).toUpperCase() + stringCapitalized.substring(1);
        return stringCapitalized;
    }
}
