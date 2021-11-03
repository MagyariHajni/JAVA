package ro.sci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static ro.sci.Athlete.processValidResult;
import static ro.sci.ResultsClass.*;
import static ro.sci.Util.checkInputErrors;
import static ro.sci.Util.outPutFinalStandings;


public class Main {

    public static void main(String[] args) {

        Path fileIn = new File("resources/biathlon_data.csv").toPath();
        Path fileOutValid = new File("resources/biathlon_results.csv").toPath();
        Path fileOutNotValid = new File("resources/biathlon_notvalid_entries.csv").toPath();

//        System.out.println(fileIn.toAbsolutePath());
        try {
            BufferedReader reader = Files.newBufferedReader(fileIn);
            BufferedWriter writeValid = Files.newBufferedWriter(fileOutValid);
            BufferedWriter writeNotValid = Files.newBufferedWriter(fileOutNotValid);

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
//                System.out.println(line);
                String inputErrors = checkInputErrors(line);
                if (!inputErrors.equals("")) {
                    writeNotValid.write("Not valid input at line " + lineNumber + ": " + inputErrors + "\n");
                    System.out.print("Not valid input at line " + lineNumber + ": " + inputErrors + "\n");
                } else {
                    Athlete athleteToAdd = processValidResult(line);

                    if (findAthleteInCurrentList(athleteToAdd)){
                        writeNotValid.write("Duplicate athlete data at line " + lineNumber + " (only first entry is registered)\n");
                        System.out.print("Duplicate athlete data at line " + lineNumber + " (only first entry is registered)\n");
                    } else {
                        addValidResultToList(athleteToAdd);
                    }
                }
            }
            System.out.println("**************************************************************************************************");
            List<Athlete> athleteStandings = getValidResultsStandings();
            outPutFinalStandings(writeValid, athleteStandings);

            writeValid.close();
            writeNotValid.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

}
