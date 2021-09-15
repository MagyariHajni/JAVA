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
//        Util.bigString(myString);
//
//        System.out.println("Backward way to say:");
//        Collections.reverse(Arrays.asList(myString));
//        Util.bigString(myString);
//
//        System.out.println("Yoda way to say:");
//        Collections.shuffle(Arrays.asList(myString));
//        Util.bigString(myString);



//       ***************** Another way :)**************


        String[] myString = {"every", "day", "sends", "future", "to", "past"};

        System.out.println("Usual way to say:");
        Util.bigStringBuilder(myString);

        System.out.println("Backward way to say:");
        Collections.reverse(Arrays.asList(myString));
        Util.bigStringBuilder(myString);

        System.out.println("Yoda way to say:");
        Collections.shuffle(Arrays.asList(myString));
        Util.bigStringBuilder(myString);

    }



}
