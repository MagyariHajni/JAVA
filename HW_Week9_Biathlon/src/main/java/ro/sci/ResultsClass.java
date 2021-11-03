package ro.sci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class ResultsClass {
    private static List<Athlete> validResults = new ArrayList<>();


    public static List<Athlete> getValidResultsStandings(){
        validResults.sort(Comparator.comparing(Athlete::getFinalResult));
        return Collections.unmodifiableList(validResults);
    }

   public static void addValidResultToList(Athlete validResult){
        if (!findAthleteInCurrentList(validResult)){
            validResults.add(validResult);
        }
   }

   public static boolean findAthleteInCurrentList(Athlete athleteToFind){
        return getValidResultsStandings().contains(athleteToFind);
   }

}
