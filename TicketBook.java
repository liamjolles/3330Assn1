package proj;

public class TicketBook {
	
	private Ticket[] tickets;
	private int count; 

public TicketBook(int capacity) {
	if(capacity <= 0) {
		throw new IllegalArgumentException("Capacity must be positive");
		
	}
	tickets = new Ticket[capacity];
	count = 0;
}
public void createTicket(int id, Event event, TicketType type, String studentName) {
	
	if(count >= tickets.length) {
		throw new IllegalArgumentException("Ticket book is full");
	}
	Ticket ticket = new Ticket(id, event, type, studentName);
	tickets[count] = ticket;
	count++;
}

public Ticket findById(int id) {
	for (int i = 0; i < count; i++) {
		if(tickets[i].getId() == id) {
			return tickets[i];
		}
	}
	return null;
}
public void printAll() {
	for (int i = 0; i < count; i++) {
		System.out.println(tickets[i]);
	}
	
}
public void printForEvent(Event event) {
	for (int i = 0; i < count; i++) {
		if(tickets[i].isForEvent(event)) {
			System.out.println(tickets[i]);
		}
	}
}
	
 
}
