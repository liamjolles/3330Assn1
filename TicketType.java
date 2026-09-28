package Proj;

public class TicketType {
	private final String name;
	private final double price;
	
	public TicketType(String name, double price)
	{
		if (name == null || name.isBlank())
		{
			throw new IllegalArgumentException("Ticket name is invalid");
		}
		
		if (!(price >= 0))
		{
			throw new IllegalArgumentException("Ticket price cannot be negative");
		}
		
		this.name = name;
		this.price = price;
			
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	
	@Override
	public String toString() {
		return name + " ($" + String.format("%.2f", price) + ")";
	}
}

