import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.Thread.sleep;

public class FestivalStatisticsThread implements Runnable {

    private static int maxNumberOfPeople;
    private static int currentNumberOfAttendees = 0;
    private static List<FestivalGate> gateList = new ArrayList<>();
    private static Map<FestivalGate, List<FestivalAttendeeThread>> attendeeMapByGate = new HashMap<>();
    private static BufferedWriter writeStatistics;

    public FestivalStatisticsThread() throws IOException {
        Path fileOut = new File("resources/festival_statistics.txt").toPath();
//        writeStatistics = Files.newBufferedWriter(fileOut,APPEND);
        writeStatistics = Files.newBufferedWriter(fileOut);
    }

    public static List<FestivalGate> getGateList() {
        return gateList;
    }

    public static void setMaxNumberOfPeople(int maxNumberOfPeople) {
        FestivalStatisticsThread.maxNumberOfPeople = maxNumberOfPeople;
    }

    public static void addGate(FestivalGate gate) {
        gateList.add(gate);
    }

    @Override
    public void run() {
        Thread dataToBeProcessedThread = null;
        do {
            try {
                sleep(5000);

                gateList.stream().forEach(FestivalGate::inactivateGate);

                currentNumberOfAttendees += countAttendeesInThisBatch();
                System.out.println("-----Processing data for current batch");

                dataToBeProcessedThread = startProcessing();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        } while ((currentNumberOfAttendees) < maxNumberOfPeople);

        System.out.println(currentNumberOfAttendees);
        
        try {
            assert dataToBeProcessedThread != null;
            dataToBeProcessedThread.join();
            writeStatistics.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private int countAttendeesInThisBatch() throws IOException {
        int numberOfAttendeesInThisBatch = gateList.stream().reduce(0, ((partialSum, gate) -> partialSum + gate.getPeopleAtThisGateList().size()), Integer::sum);
        LocalDateTime time = LocalDateTime.now();

        writeStatistics.write("***********************************************************************************************\n");
        writeStatistics.write("At " + time.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + ": "
                + numberOfAttendeesInThisBatch + " people have entered\n\n");

        return numberOfAttendeesInThisBatch;
    }

    private static Thread startProcessing() {
        attendeeMapByGate.clear();

        for (FestivalGate gate : gateList) {
            attendeeMapByGate.put(gate, new ArrayList<>(gate.getPeopleAtThisGateList()));
            gate.clearGateList();
            gate.activateGate();
            gate.notifyWaitingAttendees(gate.getPeopleAtThisGateList());
        }

        Thread processDataThread = new Thread(() -> {
            try {
                processData(attendeeMapByGate);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        processDataThread.start();
        return processDataThread;
    }

    private synchronized static void processData(Map<FestivalGate, List<FestivalAttendeeThread>> infoMapByGate) throws IOException {
        ArrayList<FestivalGate> sortedGates = new ArrayList<>(infoMapByGate.keySet());
        sortedGates.sort(Comparator.comparing(FestivalGate::getGateId));

        for (FestivalGate gate : sortedGates) {
            processGateData(gate.getGateId(), infoMapByGate.get(gate));
        }
    }

    private static void processGateData(int gateId, List<FestivalAttendeeThread> attendeeListToProcess) throws IOException {
        writeStatistics.write("Gate nr " + gateId + ": " + attendeeListToProcess.size() + " people have entered through here\n");

        if (!attendeeListToProcess.isEmpty()) {
            sortAttendeesByType(attendeeListToProcess);
        }
    }

    private static void sortAttendeesByType(List<FestivalAttendeeThread> attendeeListToProcess) throws IOException {
        for (TicketType type : TicketType.values()) {
            int numberOfAttendeesByType = (int) attendeeListToProcess.stream()
                    .filter(FestivalAttendeeThread -> FestivalAttendeeThread.getTicketType().equals(type))
                    .count();
            if (numberOfAttendeesByType != 0) {
                writeStatistics.write("\t" + numberOfAttendeesByType + " people have " + type + " passes\n");
            }
        }
    }

}
