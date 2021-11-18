import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class StartProcesses {

    public static void openTheGates(int n, int maxPeopleAllowed, int batchSize) throws IOException, InterruptedException {
        int numberOfBatches = maxPeopleAllowed / batchSize;
        int lastBatch = maxPeopleAllowed % batchSize;

        for (int i = 0; i < numberOfBatches; i++) {
            System.out.println(batchSize + " People are validating tickets");
            Thread.sleep(1000);
            for (int j = 0; j < batchSize; j++) {
                access(n, new Random().nextInt(TicketType.values().length));
            }
        }

        if (lastBatch != 0){
            Thread.sleep(1000);
            System.out.println(lastBatch + " People are validating tickets");
            for (int k = 0; k < lastBatch; k++) {
                access(n, new Random().nextInt(TicketType.values().length));
            }
        }
    }

    private static void access(int n, int randomNR) {
        FestivalAttendeeThread newAttendee = null;
        Optional<TicketType> ticketType = Arrays.stream(TicketType.values())
                .filter(ticketType1 -> ticketType1.getTicketTypeCode() == randomNR)
                .findFirst();

        if (ticketType.isPresent()) {
            newAttendee = new FestivalAttendeeThread(ticketType.get(), (new Random().nextInt(n) + 1));
        }
        assert newAttendee != null;
        newAttendee.start();
    }

    public static synchronized void generateGates(int n, int maxPeopleAllowed) {
        for (int i = 1; i <= n; i++) {
            FestivalGate newGate = new FestivalGate(i);
            FestivalStatisticsThread.addGate(newGate);
        }
        FestivalStatisticsThread.setMaxNumberOfPeople(maxPeopleAllowed);
        System.out.println(n + " gates opened successfully");
    }
}
