import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FestivalGate {
    private final int gateId;
    private boolean isActive;
    private List<FestivalAttendeeThread> peopleAtThisGate = Collections.synchronizedList(new ArrayList<>());
    private List<FestivalAttendeeThread> waitingList = Collections.synchronizedList(new ArrayList<>());

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

    public List<FestivalAttendeeThread> getWaitingList() {
        return waitingList;
    }

    public synchronized void clearGateList() {
        peopleAtThisGate.clear();
    }

    public synchronized void clearWaitingList() {
        waitingList.clear();
    }

    public synchronized void addAttendeeToGateList(FestivalAttendeeThread attendee) throws InterruptedException {
        if(!isActive){
            waitingList.add(attendee);
            wait();
        } else {
            notifyAll();
        }
        peopleAtThisGate.add(attendee);
    }

    @Override
    public String toString() {
        return "FestivalGate " +
                gateId +
                " - isOpen=" + isActive;
    }
}
