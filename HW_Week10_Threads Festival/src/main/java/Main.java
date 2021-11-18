import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        int n = 2; //set nr of gates
        int maxPeopleAllowed = 200;//set nr of people allowed
        int batchSize = 40;//set nr of people generated at once
        //TODO extend to close gates after a time or at a certain time
        //TODO extend set max number for a certain type of tickets

        StartProcesses.generateGates(n, maxPeopleAllowed);

        Thread openTheGatesThread = new Thread(() -> {
            try {
                StartProcesses.openTheGates(n, maxPeopleAllowed, batchSize);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        openTheGatesThread.start();

        Thread statisticsThread = new Thread(new FestivalStatisticsThread());
        statisticsThread.start();

    }

}
