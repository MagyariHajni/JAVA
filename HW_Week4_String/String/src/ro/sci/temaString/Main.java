package ro.sci.temaString;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

//        ***************** One way :)**************
//
//
//        String[] myString = {"every", "day", "sends", "future", "to", "past"};
//
//        System.out.println("Usual way to say:");
//        bigString(myString);
//
//        System.out.println("Backward way to say:");
//        Collections.reverse(Arrays.asList(myString));
//        bigString(myString);
//
//        System.out.println("Yoda way to say:");
//        Collections.shuffle(Arrays.asList(myString));
//        bigString(myString);



//       ***************** Another way :)**************


        String[] myString = {"every", "day", "sends", "future", "to", "past"};

        System.out.println("Usual way to say:");
        bigStringBuilder(myString);

        System.out.println("Backward way to say:");
        Collections.reverse(Arrays.asList(myString));
        bigStringBuilder(myString);

        System.out.println("Yoda way to say:");
        Collections.shuffle(Arrays.asList(myString));
        bigStringBuilder(myString);

    }

    public static String capitalize(String stringCapitalized) {
        stringCapitalized = stringCapitalized.substring(0, 1).toUpperCase() + stringCapitalized.substring(1);
        return stringCapitalized;
    }

    public static String buildString(String[] myString, String bigString) {

        for (String s : myString) {
            bigString = bigString + s + " ";
        }
        return bigString;
    }

    public static StringBuilder buildStringBuilder(String[] myString, StringBuilder bigString) {
        for (String s : myString) {
            bigString.append(s).append(" ");
        }
        return bigString;
    }

    public static void bigString(String[] myString) {
        String bigString = "";
        bigString = buildString(myString, bigString);
        System.out.println(capitalize(bigString) + "\n");
    }

    public static void bigStringBuilder(String[] myString) {
        StringBuilder bigString = new StringBuilder();
        bigString.setLength(0);
        buildStringBuilder(myString, bigString);
        System.out.println(capitalize(bigString.toString()) + "\n");
    }

}
