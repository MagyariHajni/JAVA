import java.util.Optional;

public class FestivalAttendeeThread extends Thread {
    private final TicketType ticketType;
    private final int gateAccessId;

    public FestivalAttendeeThread(TicketType ticketType, int gateID) {
        this.ticketType = ticketType;
        this.gateAccessId = gateID;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    @Override
    public void run() {
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            accessFestival(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void accessFestival(FestivalAttendeeThread festivalAttendee) throws InterruptedException {

        Optional<FestivalGate> gate = FestivalStatisticsThread.getGateList().stream()
                .filter(festivalGate -> festivalGate.getGateId() == gateAccessId)
                .findFirst();
        if (gate.isPresent()) {
            gate.get().addAttendeeToGateList(festivalAttendee);
        }
    }

    @Override
    public String toString() {
        return ticketType +
                " for gate " + gateAccessId;
    }
}
