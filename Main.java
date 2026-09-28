package Proj;

public class Main {

	 public static void main(String[] args) {
	        // events
	        Event lecture = new Event("Virtual Reality Lecture", "Lafferre Hall");
	        Event workshop = new Event("Resume Workshop", "Cornell Hall");

	        // ticket types
	        TicketType student = new TicketType("Student", 0.0);
	        TicketType vip = new TicketType("VIP", 40.0);
	        TicketManager manager = new TicketManager(10);

	        // 5 tickets, both events and both types
	        int tix1 = manager.createTicket(lecture, student, "Drew");
	        int tix2 = manager.createTicket(lecture, vip, "Jim");
	        int tix3 = manager.createTicket(workshop, student, "Liam");
	        int tix4 = manager.createTicket(workshop, vip, "Jeffrey");
	        int tix5 = manager.createTicket(lecture, student, "Masen");

	        // Cancel one ticket
	        System.out.println("Cancel ticket " + tix2 + ": " + manager.cancelTicket(tix2));

	        // Admit one ticket
	        System.out.println("Admit ticket " + tix1 + ": " + manager.admitTicket(tix1));

	        // Invalid operation, can't admit a canceled ticket
	        System.out.println("Admit canceled ticket " + tix2 + ": " + manager.admitTicket(tix2));

	        // Reports
	        System.out.println("\n=== All tickets ===");
	        manager.printAll();

	        System.out.println("\n=== Tickets for " + lecture + " ===");
	        manager.printForEvent(lecture);
	    }
}
