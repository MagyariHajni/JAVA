import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FestivalGate {
    private final int gateId;
    private boolean isActive;
    private List<FestivalAttendeeThread> peopleAtThisGate = Collections.synchronizedList(new ArrayList<>());

    public FestivalGate(int gateId) {
        this.isActive = true;
        this.gateId = gateId;
    }

    public int getGateId() {
        return gateId;
    }

    public void inactivateGate() {
        isActive = false;
    }

    public void activateGate() {
        isActive = true;
    }

    public List<FestivalAttendeeThread> getPeopleAtThisGateList() {
        return peopleAtThisGate;
    }

    public synchronized void clearGateList() {
        peopleAtThisGate.clear();
    }

    public synchronized void addAttendeeToGateList(FestivalAttendeeThread attendee) throws InterruptedException {
        if(!isActive){
            wait();
        }
        peopleAtThisGate.add(attendee);
    }

    public synchronized void notifyWaitingAttendees(List<FestivalAttendeeThread> peopleToNotify){
        notifyAll();
    }

    @Override
    public String toString() {
        return "FestivalGate " +
                gateId +
                " - isOpen=" + isActive;
    }
}
