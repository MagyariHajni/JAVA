package ro.sci.temaString;

public class Util {
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
