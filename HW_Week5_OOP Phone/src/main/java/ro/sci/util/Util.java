package ro.sci.util;

import org.apache.commons.math3.random.RandomDataGenerator;
import ro.sci.phoneType.Phone;
import ro.sci.phoneType.PhoneList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Util {

    public static String choose(String text, List<String> phoneList) {
        Scanner scanner = new Scanner(System.in);
        String phoneChoice;

        do {
            System.out.println(text + Arrays.toString(phoneList.toArray()));
            phoneChoice = scanner.nextLine();
        } while (!phoneList.contains(phoneChoice));

        return phoneChoice;
    }

    public static long getGeneratedLong() {
        long leftLimit = 100_000_000_000_000L;
        long rightLimit = 999_999_999_999_999L;
        return new RandomDataGenerator().nextLong(leftLimit, rightLimit);
    }

    public static int nextChoice(String text, int left, int right) {
        int nextChoice;

        do {
            System.out.println(text);
            Scanner scanner = new Scanner(System.in);
            nextChoice = scanner.nextInt();
        } while (nextChoice < left || nextChoice > right);

        return nextChoice;
    }

    public static void listCurrentList() {
        List<Phone> currentPhoneList = PhoneList.generatePhoneList();
        int i = 0;
        for (Phone e : currentPhoneList) {
            i++;
            System.out.print(i + ". " + e);
        }

        if (currentPhoneList.isEmpty()) {
            System.out.println("There are no phones added yet");
        }
    }

}




