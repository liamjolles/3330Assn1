public class Main {
    public static void main(String[] args) {
        Event lecture = new Event("Cybersecurity Guest Lecture", "Engineering Building");
        Event workshop = new Event("Intro to Robotics Workshop", "Lab 204");

        TicketType student = new TicketType("Student", 0.00);
        TicketType general = new TicketType("General", 10.00);
        TicketType vip = new TicketType("VIP", 25.00);

        TicketManager manager = new TicketManager(10);

        int t1 = manager.createTicket(lecture, student, "Alice");
        int t2 = manager.createTicket(lecture, general, "Bob");
        int t3 = manager.createTicket(workshop, student, "Carla");
        int t4 = manager.createTicket(workshop, vip, "Dev");
        int t5 = manager.createTicket(lecture, vip, "Eve");

        System.out.println("=== Cancel and admit ===");
        System.out.println("Cancel ticket " + t2 + ": " + manager.cancelTicket(t2));
        System.out.println("Admit ticket " + t1 + ": " + manager.admitTicket(t1));

        System.out.println("\n=== Invalid operations ===");
        System.out.println("Admit canceled ticket " + t2 + ": " + manager.admitTicket(t2));
        System.out.println("Cancel admitted ticket " + t1 + ": " + manager.cancelTicket(t1));
        System.out.println("Admit ticket " + t1 + " twice: " + manager.admitTicket(t1));
        try {
            manager.admitTicket(999);
        } catch (IllegalArgumentException e) {
            System.out.println("Unknown ticket rejected: " + e.getMessage());
        }
        try {
            new TicketType("Broken", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid ticket type rejected: " + e.getMessage());
        }

        System.out.println("\n=== All tickets ===");
        manager.printAll();

        System.out.println("\n=== Tickets for " + lecture + " ===");
        manager.printForEvent(lecture);
    }
}
