public class Ticket {
    private final int id;
    private final Event event;
    private final TicketType ticketType;
    private final String studentName;
    private boolean canceled;
    private boolean admitted;

    public Ticket(int id, Event event, TicketType ticketType, String studentName) {
        if (id <= 0) {
            throw new IllegalArgumentException("Ticket id must be positive: " + id);
        }
        if (event == null) {
            throw new IllegalArgumentException("Event must not be null");
        }
        if (ticketType == null) {
            throw new IllegalArgumentException("Ticket type must not be null");
        }
        if (studentName == null || studentName.isBlank()) {
            throw new IllegalArgumentException("Student name must not be null or blank");
        }
        this.id = id;
        this.event = event;
        this.ticketType = ticketType;
        this.studentName = studentName;
        this.canceled = false;
        this.admitted = false;
    }

    public boolean cancel() {
        if (!isActive()) {
            return false;
        }
        canceled = true;
        return true;
    }

    public boolean admit() {
        if (!isActive()) {
            return false;
        }
        admitted = true;
        return true;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public boolean isAdmitted() {
        return admitted;
    }

    public boolean isActive() {
        return !canceled && !admitted;
    }

    public boolean isForEvent(Event other) {
        return event == other;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    private String statusText() {
        if (canceled) {
            return "CANCELED";
        }
        if (admitted) {
            return "ADMITTED";
        }
        return "ACTIVE";
    }

    public String toString() {
        return "Ticket #" + id + " | " + studentName + " | " + event
                + " | " + ticketType + " | " + statusText();
    }
}
