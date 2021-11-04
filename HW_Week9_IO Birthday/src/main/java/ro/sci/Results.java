package ro.sci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ro.sci.Person.processValidResult;
import static ro.sci.Util.checkInputErrors;

public class Results {
    private static List<Person> validResults = new ArrayList<>();

    public static List<Person> getValidResults() {
//        validResults.sort(Comparator.comparing(People::getLastName).thenComparing(People::getFirstName));
        return Collections.unmodifiableList(validResults);
    }

    public static void addValidResultToList(Person validResult) {
        if (!getValidResults().contains(validResult)) {
            validResults.add(validResult);
        }
    }

    public static void listPeopleWithBirthdayInGivenMonth(Path fileIn, int monthToCheck, Path fileOutValid) {
        Path fileOutNotValid = new File("resources/people_notvalid_entries.csv").toPath();
        try {
            BufferedReader reader = Files.newBufferedReader(fileIn);
            BufferedWriter writeValid = Files.newBufferedWriter(fileOutValid);
            BufferedWriter writeNotValid = Files.newBufferedWriter(fileOutNotValid);

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String inputErrors = checkInputErrors(line);

                if (!inputErrors.equals("")) {
                    writeNotValid.write("Not valid input at line " + lineNumber + ": " + inputErrors + "\n");
                } else {
                    Person personToAdd = processValidResult(lineNumber, line);
                    if (getValidResults().contains(personToAdd)) {
                        Optional<Person> firstEntry = getValidResults().stream().filter(person -> person.equals(personToAdd)).findFirst();
                        if (firstEntry.isPresent()){
                            writeNotValid.write("Duplicate data at line " + firstEntry.get().getId() + " and line " + lineNumber + "\n");
                        }
                    } else {
                        addValidResultToList(personToAdd);
                    }
                }
            }
            List<String> filteredList = getValidResults().stream()
                    .filter(person -> person.getDateOfBirth().getMonthValue() == monthToCheck)
                    .map(person -> person.getLastName() + " " + person.getFirstName())
                    .sorted()
                    .collect(Collectors.toList());
            if (filteredList.isEmpty()) {
                writeValid.write("Nobody has their birthday in month " + monthToCheck + " (" + new DateFormatSymbols().getMonths()[monthToCheck - 1] + ")");

            } else {
                filteredList
                        .forEach(s -> {
                            try {
                                writeValid.write(s + "\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
            }

            writeValid.close();
            writeNotValid.close();

        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }


}
