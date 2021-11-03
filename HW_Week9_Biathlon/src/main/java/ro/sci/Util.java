package ro.sci;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static ro.sci.Athlete.processToFileInputAthlete;

public class Util {

    public static String checkInputErrors(String input) {
        String[] inputData = input.split(",");
        StringBuilder invalidData = new StringBuilder();

        if (inputData.length != 7) {
            return " -missing data";
        } else {
            try {
                Integer.parseInt(inputData[0]);
            } catch (NumberFormatException e) {
                invalidData.append(" -not valid athlete number ").append(inputData[0]);
            }

            if (inputData[3].chars().filter(ch -> ch == ':').count() != 1) {
                invalidData.append(" -not valid time result input ").append(inputData[3]);
            } else {
                int separatorPos = inputData[3].indexOf(':');
                try {
                    Integer.parseInt(inputData[3].substring(0, separatorPos));
                    Integer.parseInt(inputData[3].substring(separatorPos + 1));
                } catch (NumberFormatException e) {
                    invalidData.append(" -not valid time result input ").append(inputData[3]);
                }
            }

            if (findShootingRangeError(inputData[4].toLowerCase())) {
                invalidData.append(" -not valid first shooting range result input ").append(inputData[4]);
            }
            if (findShootingRangeError(inputData[5].toLowerCase())) {
                invalidData.append(" -not valid second shooting range result input ").append(inputData[5]);
            }
            if (findShootingRangeError(inputData[6].toLowerCase())) {
                invalidData.append(" -not valid third shooting range result input ").append(inputData[6]);
            }

//            if (IntStream.of(4, 5, 6).anyMatch(i -> (inputData[i].length() != 5 || !checkShootingRange(inputData[i])) )) {
//                invalidData.append(" -not valid shooting result input");
//            }

        }
        return invalidData.toString();
    }

    private static boolean findShootingRangeError(String inputShootingRange) {
        return (inputShootingRange.chars().filter(ch -> (ch == 'x' || ch == 'o')).count() != 5
                || inputShootingRange.length() != 5);
    }

    public static void outPutFinalStandings(BufferedWriter writeValid, List<Athlete> athleteStandings) throws IOException {
        if (athleteStandings.isEmpty()) {
            writeValid.write("We didn't have any valid entries. ");
            System.out.print("We didn't have any valid entries. ");
        } else {
            String currentPos = "Winner: ";
            String nextPos = "\nRunner-up: ";

//            List<String> outPutFinalStandingsList = athleteStandings.stream()
//                    .parallel()
//                    .map(athleteToProcess -> String.format("%s %s (%s + %d)",
//                            athleteToProcess.getAthleteName(),
//                            processTimeResult(athleteToProcess.getFinalResult()),
//                            processTimeResult(athleteToProcess.getSkiTimeResults()),
//                            (athleteToProcess.getFinalResult().getSeconds() - athleteToProcess.getSkiTimeResults().getSeconds())))
//                    .collect(Collectors.toList());
//            System.out.println(outPutFinalStandingsList);
//            System.out.println(athleteStandings);

            writeValid.write(currentPos + processToFileInputAthlete(athleteStandings.get(0)));
            System.out.print(currentPos + processToFileInputAthlete(athleteStandings.get(0)));

            if (athleteStandings.size() > 1) {
                if (athleteStandings.get(0).getFinalResult().getSeconds() == athleteStandings.get(1).getFinalResult().getSeconds()) {
                    currentPos = "\nWinner: ";
                    writeValid.write(currentPos + processToFileInputAthlete(athleteStandings.get(1)));
                    System.out.print(currentPos + processToFileInputAthlete(athleteStandings.get(1)));
                } else {
                    writeValid.write(nextPos + processToFileInputAthlete(athleteStandings.get(1)));
                    System.out.print(nextPos + processToFileInputAthlete(athleteStandings.get(1)));
                    currentPos = nextPos;
                }
                nextPos = "\nThird place: ";
            }

            if (athleteStandings.size() > 2) {
                if (athleteStandings.get(1).getFinalResult().getSeconds() == athleteStandings.get(2).getFinalResult().getSeconds()) {
                    writeValid.write(currentPos + processToFileInputAthlete(athleteStandings.get(2)));
                    System.out.print(currentPos + processToFileInputAthlete(athleteStandings.get(2)));
                } else {
                    writeValid.write(nextPos + processToFileInputAthlete(athleteStandings.get(2)));
                    System.out.print(nextPos + processToFileInputAthlete(athleteStandings.get(2)));
                    currentPos = nextPos;
                }
                nextPos = "\nPlace 4: ";
            }

            if (athleteStandings.size() > 3) {
                for (int i = 4; i <= athleteStandings.size(); i++) {
                    if (athleteStandings.get(i - 2).getFinalResult().getSeconds() == athleteStandings.get(i - 1).getFinalResult().getSeconds()) {
                        writeValid.write(currentPos + processToFileInputAthlete(athleteStandings.get(i - 1)));
                        System.out.print(currentPos + processToFileInputAthlete(athleteStandings.get(i - 1)));
                    } else {
                        writeValid.write(nextPos + processToFileInputAthlete(athleteStandings.get(i - 1)));
                        System.out.print(nextPos + processToFileInputAthlete(athleteStandings.get(i - 1)));
                        currentPos = "\nPlace " + i + ": ";
                    }
                    nextPos = "\nPlace " + (i + 1) + ": ";
                }
            }
        }
    }

    public static String processTimeResult(Duration timeResult) {
        return timeResult.toMinutes() + ":" +
                ((timeResult.getSeconds() - (timeResult.toMinutes() * 60)) < 10 ? "0" : "")
                + (timeResult.getSeconds() - (timeResult.toMinutes() * 60));

    }
}
