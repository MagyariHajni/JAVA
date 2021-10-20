package ro.sci;

import ro.sci.exceptions.InvalidInputException;
import ro.sci.exceptions.InvalidNumberException;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {

    private static Logger logger = Logger.getLogger(Util.class.getName());

    public static Date convertStringToDate(String stringDate) throws InvalidNumberException {
        String strPattern = "^\\d{2}/\\d{2}/\\d{4}$";
        if (!stringDate.matches(strPattern)) {
            logger.log(Level.WARNING,"Invalid date entry " + stringDate + ". Format must be dd/MM/yyyy, numbers only",new NumberFormatException());
            throw new NumberFormatException("Invalid date entry " + stringDate + ". Format must be dd/MM/yyyy, numbers only");
        }
        else {
            return validateDate(stringDate);
        }
    }

    public static Date validateDate(String stringDate) throws InvalidNumberException {
        int day = Integer.parseInt(stringDate.substring(0, 2));
        int month = Integer.parseInt(stringDate.substring(3, 5));
        int year = Integer.parseInt(stringDate.substring(6));
        if ((day == 0) || (day > 31)) {
            throw new InvalidNumberException("Invalid number " + day + " for day, must be a number between 01 and 31");
        }
        if ((month == 0) || (month > 12)) {
            throw new InvalidNumberException("Invalid number " + month + " for month, must be a number between 01 and 12");
        }
        if ((year < 1900) || (year > LocalDate.now().getYear())) {
            throw new InvalidNumberException("Invalid number " + year + " for year, must cu a number between 1900 and " + LocalDate.now().getYear());
        } else if (year == LocalDate.now().getYear()) {
            if (month > LocalDate.now().getMonthValue()) {
                throw new InvalidNumberException("Invalid number " + month + " for month in date of birth for the current year, must be number <= " + LocalDate.now().getMonthValue());
            } else if (month == LocalDate.now().getMonthValue()) {
                if (day > LocalDate.now().getDayOfMonth()) {
                    throw new InvalidNumberException("Invalid number " + day + " for day in date of birth for the current year, must be a number <= " + LocalDate.now().getDayOfMonth());
                }
            }
        }

        if (checkDate(year, month, day)) {
            DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                return dateFormatter.parse(stringDate);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static boolean checkDate(int year, int month, int day) throws InvalidNumberException {
        List<Integer> smallMonths = Arrays.asList(4, 6, 9, 11);

        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            if ((month == 2) && (day > 29)) {
                throw new InvalidNumberException("Invalid number for day, in leap years february has only 29 days");
            }
        } else {
            if ((month == 2) && (day > 28)) {
                throw new InvalidNumberException("Invalid number for day, in non leap years february has only 28 days");
            }
        }
        if ((smallMonths.contains(month)) && (day > 30)) {
            throw new InvalidNumberException("Invalid number for day, " + new DateFormatSymbols().getMonths()[month - 1] + " has only 30 days");
        } else return true;
    }

    public static void checkID(long id, String dateOfBirth, char gender) throws InvalidInputException, InvalidNumberException {
        validateIdFormat(id);

        String idToString = Long.toString(id);
        int idDay = Integer.parseInt(idToString.substring(5, 7));
        int idMonth = Integer.parseInt(idToString.substring(3, 5));
        int idYear = Integer.parseInt(idToString.substring(1, 3));

        if (!checkGenderId(idToString.charAt(0), gender)) {
            throw new InvalidInputException("The id " + id + " doesn't match the given gender "
                    + gender);
        }

        if ((idToString.charAt(0) == '1') || ((idToString.charAt(0) == '2'))) {
            idYear += 1900;
        } else {
            idYear += 2000;
        }
        String idDateString = (idDay < 10 ? ("0" + idDay) : idDay) + "/"
                + (idMonth < 10 ? ("0" + idMonth) : idMonth) + "/" + idYear;
        Date idDate = convertStringToDate(idDateString);
        Date dobDate = convertStringToDate(dateOfBirth);
        if (!Objects.equals(idDate, dobDate)) {
            throw new InvalidInputException("The id " + id + " doesn't match the given date of birth "
                    + new SimpleDateFormat("dd/MM/yyyy").format(dobDate));
        }

    }

    public static boolean checkGenderId(char idGender, char gender) {
        if (idGender == '1' || idGender == '5') {
            return (gender == 'm') || (gender == 'M');
        } else {
            return (gender == 'f') || (gender == 'F');
        }
    }

    public static void checkEmptyData(String firstName, String lastName, String dateOfBirth) throws InvalidInputException {
        if (Objects.equals(firstName, "")
                || Objects.equals(lastName, "")
                || Objects.equals(dateOfBirth, "")) {
            throw new InvalidInputException("Every field is required" + (Objects.equals(firstName, "") ? ", first name is empty" : "")
                    + (Objects.equals(lastName, "") ? ", last name is empty" : "")
                    + (Objects.equals(dateOfBirth, "") ? ", date of birth is empty" : ""));
        }
    }

    public static void checkGender(char gender) throws InvalidInputException {
        if ((gender != 'M') && (gender != 'm') && (gender != 'F') && (gender != 'f')) {
            throw new InvalidInputException("Invalid data input for gender, must be F or M");
        }
    }

    public static void validateIdFormat(long id) throws InvalidInputException {
        String idToString = Long.toString(id);
        List<Character> genderNumber = Arrays.asList('1', '2', '5', '6');

        if ((idToString.length() != 13)
                || idToString.charAt(0) == '-'
                || !genderNumber.contains(idToString.charAt(0))) {
            throw new InvalidInputException("Invalid id input " + id + ", must have 13 numbers, start with [1,2,5,6]");
        }
    }
}
