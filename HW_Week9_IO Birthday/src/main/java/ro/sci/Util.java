package ro.sci;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static String checkInputErrors(String input) {
        String[] inputData = input.split(",");
        StringBuilder invalidData = new StringBuilder();

        if ((inputData.length != 3) || Arrays.asList(inputData).contains("")) {
            return " -missing data";
        } else {

            if (inputData[2].chars().filter(ch -> ch == '/').count() != 2) {
                invalidData.append(" -not valid birthdate input ").append(inputData[2]).append(" (format must be dd/MM/yyyy, numbers only)");
            } else {
                int separatorPos1 = inputData[2].indexOf('/');
                int separatorPos2 = inputData[2].lastIndexOf('/');
                try {
                    int birthdateDay = Integer.parseInt(inputData[2].substring(0, separatorPos1));
                    int birthdateMonth = Integer.parseInt(inputData[2].substring(separatorPos1 + 1, separatorPos2));
                    int birthdateYear = Integer.parseInt(inputData[2].substring(separatorPos2 + 1));

                    String errorInDate = findErrorInDate(birthdateDay, birthdateMonth, birthdateYear);

                    if (!errorInDate.equals("")) {
                        invalidData.append(" -not valid birthdate input").append(errorInDate);
                    }

                } catch (NumberFormatException e) {
                    invalidData.append(" -not valid birthdate input ").append(inputData[2]);
                }
            }
        }
        return invalidData.toString();
    }

    private static String findErrorInDate(int day, int month, int year) {
        StringBuilder error = new StringBuilder();
        if ((day == 0) || (day > 31)) {
            error.append(" -invalid number ").append(day).append(" for day (must be a number between 01 and 31)");
        }
        if ((month == 0) || (month > 12)) {
            error.append(" -invalid number ").append(month).append(" for month (must be a number between 01 and 12)");
        }
        if ((year < 1900) || (year > LocalDate.now().getYear())) {
            error.append(" -invalid number ").append(year).append(" for year (must be a number between 1900 and ").append(LocalDate.now().getYear()).append(")");
        } else if (year == LocalDate.now().getYear()) {
            if (month > LocalDate.now().getMonthValue()) {
                error.append(" -invalid number ").append(month).append(" for month in date of birth for the current year (must be number <= ").append(LocalDate.now().getMonthValue()).append(")");
            } else if (month == LocalDate.now().getMonthValue()) {
                if (day > LocalDate.now().getDayOfMonth()) {
                    error.append("Invalid number ").append(day).append(" for day in date of birth for the current year (must be a number <= ").append(LocalDate.now().getDayOfMonth()).append(")");
                }
            }
        }

        error.append(checkDate(year, month, day));

        return error.toString();
    }

    private static String checkDate(int year, int month, int day){
        List<Integer> smallMonths = Arrays.asList(4, 6, 9, 11);
        StringBuilder error = new StringBuilder();

        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            if ((month == 2) && (day > 29)) {
                error.append(" -invalid number for day ").append(day).append(" (in leap years february has only 29 days)");
            }
        } else {
            if ((month == 2) && (day > 28)) {
                error.append(" -invalid number for day ").append(day).append(" (in non leap years february has only 28 days)");
            }
        }
        if ((smallMonths.contains(month)) && (day > 30)) {
            error.append(" -invalid number for day ").append(day).append(" (").append(new DateFormatSymbols().getMonths()[month - 1]).append(" has only 30 days)");
        }
        return error.toString();
    }

}
