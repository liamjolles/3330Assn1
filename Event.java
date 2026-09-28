package Proj;

public class Event {
	
	private final String name;
	private final String location;
	
	public Event(String name, String location)
	{

		if (name == null || name.isBlank())
		{
			throw new IllegalArgumentException("Name isnt valid");
		}
		
		if (location == null || location.isBlank())
		{
			throw new IllegalArgumentException("Location isnt valid");
		}
		
		this.name = name;
		this.location = location;
	}
		
	public String getName()
	{
		return name;
	}
		
	public String getLocation()
	{
			return location;
	}
	
	public String toString()
	{
		return (name + " @ " + location);
	}

}
