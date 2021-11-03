package ro.sci;

import java.time.Duration;
import java.util.Objects;

import static ro.sci.Util.processTimeResult;

public class Athlete {
    private final int athleteNumber;
    private final String athleteName;
    private final String countryCode;
    private final Duration skiTimeResults;
    private final String firstShootingRange;
    private final String secondShootingRange;
    private final String thirdShootingRange;
    private final Duration finalResult;

    public Athlete(int athleteNumber, String athleteName, String countryCode, Duration skiTimeResults, String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResults = skiTimeResults;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;

        this.finalResult = calculateFinalResult(skiTimeResults, firstShootingRange, secondShootingRange, thirdShootingRange);

    }

    public int getAthleteNumber() {
        return athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Duration getSkiTimeResults() {
        return skiTimeResults;
    }

    public String getFirstShootingRange() {
        return firstShootingRange;
    }

    public String getSecondShootingRange() {
        return secondShootingRange;
    }

    public String getThirdShootingRange() {
        return thirdShootingRange;
    }

    public Duration getFinalResult() {
        return finalResult;
    }

    public Duration calculateFinalResult(Duration initialTimeResult, String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
        int penalties = (int) (firstShootingRange.chars().filter(ch -> (ch == 'o')).count()
                + secondShootingRange.chars().filter(ch -> (ch == 'o')).count()
                + thirdShootingRange.chars().filter(ch -> (ch == 'o')).count());

        return Duration.ofSeconds(initialTimeResult.getSeconds() + (penalties * 10L));
    }


    public static Athlete processValidResult(String input) {
        String[] inputData = input.split(",");

        int newAthleteNumber = Integer.parseInt(inputData[0]);

        int separatorPos = inputData[3].indexOf(':');
        long minutes = Integer.parseInt(inputData[3].substring(0, separatorPos));
        long seconds = Integer.parseInt(inputData[3].substring(separatorPos + 1));
        Duration newSkiTimeResults = Duration.ofSeconds((minutes * 60) + seconds);

        return new Athlete(newAthleteNumber, inputData[1], inputData[2], newSkiTimeResults, inputData[4].toLowerCase(), inputData[5].toLowerCase(), inputData[6].toLowerCase());
    }


    public static String processToFileInputAthlete(Athlete athleteToProcess) {
//        StringBuilder processedAthleteInfo = new StringBuilder("");
//        processedAthleteInfo.append(athleteToProcess.athleteName)
//                .append(" ")
//                .append(Util.processTimeResult(athleteToProcess.finalResult))
//                .append(" (")
//                .append(Util.processTimeResult(athleteToProcess.skiTimeResults))
//                .append(" + ")
//                .append(athleteToProcess.finalResult.getSeconds() - athleteToProcess.skiTimeResults.getSeconds())
//                .append(")");
//
//        return processedAthleteInfo.toString();
        return String.format("%s %s (%s + %d)",
                athleteToProcess.athleteName,
                processTimeResult(athleteToProcess.finalResult),
                processTimeResult(athleteToProcess.skiTimeResults),
                (athleteToProcess.finalResult.getSeconds() - athleteToProcess.skiTimeResults.getSeconds()));
    }

    @Override
    public String toString() {
        return athleteName + " " +
                processTimeResult(skiTimeResults) + " " +
                processTimeResult(finalResult) +
                "\t";
    }

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Athlete)) return false;
        Athlete athlete = (Athlete) o;
        return getAthleteNumber() == athlete.getAthleteNumber() && Objects.equals(getAthleteName(), athlete.getAthleteName()) && Objects.equals(getCountryCode(), athlete.getCountryCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAthleteNumber(), getAthleteName(), getCountryCode());
    }
}
